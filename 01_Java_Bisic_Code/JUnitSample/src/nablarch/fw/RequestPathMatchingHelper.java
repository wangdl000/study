package nablarch.fw;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import nablarch.core.log.Logger;
import nablarch.core.log.LoggerManager;
import nablarch.core.util.Builder;
import nablarch.core.util.Glob;
import nablarch.core.util.StringUtil;

/**
 * リクエストパスとリクエストパスのパターンの照合を行うクラス。
 * 
 * <pre>
 * リクエストパスは、URI、Unixのシステムパス、Javaの名前空間のように、"/"で区切られた
 * 階層構造をもつリクエストパスを想定し、そのパターンをGlob式に似た書式で指定する。
 * 
 * 1. ワイルドカードの指定等、基本的にUnixやDOSで使用されるGlob式の記法に準じる。
 *    '*'はワイルドカードであり'.'と'/'を除く任意の文字の任意個の列にマッチする。
 * -------------------------------  ---------------------       ------------------
 *    リクエストパスのパターン       リクエストパス                  照合結果
 * -------------------------------  ---------------------       ------------------
 * /                                /                           OK
 *                                  /index.jsp                  NG
 * -------------------------------  ---------------------       ------------------
 * /*                               /                           OK
 *                                  /app                        OK
 *                                  /app/                       NG (*は'/'にはマッチしない)
 *                                  /index.jsp                  NG (*は'.'にはマッチしない)
 * -------------------------------  ---------------------       ------------------
 * /app/*.jsp                       /app/index.jsp              OK
 *                                  /app/admin                  NG
 * -------------------------------  ---------------------       ------------------
 * /app/* /test                     /app/admin/test             OK
 *                                  /app/test/                  NG
 * -------------------------------  ---------------------       ------------------
 * 
 * 2. 最後尾の'/'が'//'と重ねられていた場合、それ以前の文字列について
 *    前方一致すればマッチ成功と判定する。
 *    リソース名を表す'//'以降の文字列については別途マッチ判定が行われる。
 *    (すなわち、"サブディレクトリ全体"に対してマッチする。)
 * --------------------------------  --------------------  ------------------
 *    リクエストパスのパターン        リクエストパス        照合結果
 * --------------------------------  --------------------  ------------------
 * /app//                            /                     NG
 *                                   /app/                 OK
 *                                   /app/admin/           OK
 *                                   /app/admin/index.jsp  OK
 * --------------------------------  --------------------  ------------------
 * //*.jsp                           /app/index.jsp        OK
 *                                   /app/admin/index.jsp  OK
 *                                   /app/index.html       NG('*.jsp'がマッチしない)
 * --------------------------------  --------------------  ------------------
 * </pre>
 * <p/>
 * リクエストパスのパターンのマッチングは、リクエストパス中のすべてのドット(.)をスラッシュ(/)に置換してから行う。
 * この仕様は、Nablarch のバッチ処理で過去に使用していたドット区切りのリクエストパス（例： ss01A001.B01AA001Action/B01AA0010）との互換性を保つために存在している。
 * 
 * @author Masato Inoue
 */
public class RequestPathMatchingHelper {

	/** ロガー */
	private static final Logger LOGGER = LoggerManager.get(RequestPathMatchingHelper.class);

	/** リクエストパスのパターン中のディレクトリパス部分 */
	private String directoryPath;
	/** リクエストパスのパターン中のリソース名部分 */
	private String resourceName;
	/** リクエストパスのパターン中にリソース名部分が含まれるか？ */
	private boolean hasResourceNamePattern;
	/** リソース名のパターン文字列をコンパイルしたオブジェクト */
	private Pattern resourceNamePattern;
	/** リクエストパスのパターンはサブノードにも適用されるか？ */
	private boolean affectsDescendantNodes;
	/** ドットをスラッシュに置換するかどうか */
	private boolean isReplaceDot;

	/**
	 *  コンストラクタ。
	 *  <p/>
	 *  リクエストパスとしてクラスの完全修飾名が渡される場合、本引数にtrueを設定することで、リクエストパス中のドット(.)をスラッシュに変換して、ディスパッチを行うことが可能となる。
	 *  @param isReplaceDot リクエストパス内のドットをスラッシュに置換する場合、true
	 */
	public RequestPathMatchingHelper(boolean isReplaceDot) {
		this.isReplaceDot = isReplaceDot;
	}

	/**
	 * 照合に使用するリクエストパスのパターン文字列を設定する。
	 * @param requestPattern リクエストパスのパターン文字列
	 * @return このインスタンス自体
	 */
	public RequestPathMatchingHelper setRequestPattern(String requestPattern) {
		requestPattern = encodeRequestPath(requestPattern.trim());
		Matcher m = REQUEST_PATH_PATTERN_SYNTAX.matcher(requestPattern);
		if (!m.matches()) {
			String message = "Invalid pattern format: " + requestPattern;
			LOGGER.logInfo(message);
			throw new IllegalArgumentException(message);
		}
		directoryPath = m.group(1);
		resourceName = m.group(2);
		affectsDescendantNodes = directoryPath.endsWith("//");
		hasResourceNamePattern = !StringUtil.isNullOrEmpty(resourceName);

		if (hasResourceNamePattern) {
			resourceNamePattern = Glob.compile(resourceName);
		}
		if (affectsDescendantNodes) {
			directoryPath = directoryPath.replaceAll("//$", "/");
		}
		return this;
	}

	/**
	 * 与えられたリクエストパスをエスケープする。
	 * @param requestPath 処理対象リクエストパス文字列
	 * @return エスケープ後文字列
	 */
	private String encodeRequestPath(String requestPath) {
		requestPath = requestPath.trim();
		if ("//".equals(requestPath)) {
			return requestPath;
		}
		try {
			requestPath = new URI(requestPath).toASCIIString();
		} catch (URISyntaxException e) {
			throw new IllegalArgumentException("invalid requestPath: " + requestPath, e);
		}
		return requestPath;
	}

	/**
	 * 渡されたリクエストパスと、リクエストパスのパターン文字列との照合を行う。
	 * 
	 * @param req HTTPリクエストオブジェクト
	 * @param context 実行コンテキスト
	 * @return マッチする場合はtrue
	 */
	public boolean isAppliedTo(Request<?> req,
			ExecutionContext context) {
		if (directoryPath == null) {
			throw new IllegalStateException("requestPattern must be set.");
		}

		String normalizedRequestPath = normalizeRequestPath(req);

		Matcher m = REQUEST_PATH_SYNTAX.matcher(normalizedRequestPath);
		if (!m.matches()) {
			return false;
		}
		String directoryPath = m.group(1);
		String resourceName = (m.group(2) == null) ? "" : m.group(2);

		String extendedDirectory = directoryPath + "/" + resourceName + "/";
		return matchesWith(extendedDirectory, "")
				|| matchesWith(directoryPath, resourceName);
	}

	/**
	 * リクエストパスを正規化する。
	 * <pre>
	 * 具体的には以下の処理を行う。
	 *   1. 前後の空白文字を除去する。
	 *   2. 先頭が"/"でない場合は補完する。
	 *   3. リクエストパス中のドット(.)をスラッシュに変換する。（replaceDotフィールドがtrueの場合のみこの変換処理は行われる）
	 * </pre>
	 * <p/>
	 * コンストラクタでreplaceDotフィールドにtrueが設定されている場合、リクエストパス中のドット(.)をスラッシュに置換するので、
	 * クラスの完全修飾名がリクエストパスとして渡された場合でもディスパッチを行うことができる。<br/>
	 * 例） abc.def.HogeAction/B00AA0000 -> abc/def/HogeAction/B00AA0000 <br/>
	 *
	 * @param req HTTPリクエストオブジェクト
	 * @return 正規化したリクエストパス
	 */
	protected String normalizeRequestPath(Request<?> req) {
		String replacedRequestPath = req.getRequestPath()
				.trim()
				.replaceAll("^/?", "/");
		if (isReplaceDot) {
			return replacedRequestPath.replaceAll("\\.", "/");
		}
		return replacedRequestPath;
	}

	/**
	 * リクエストパスのパターンが、引数で指定されたディレクトリパスとリソース名に合致すればtrueを返す。
	 *
	 * @param directoryPath ディレクトリパス
	 * @param resourceName リソース名
	 * @return 引数で指定されたディレクトリパスとリソース名に合致すればtrue
	 */
	protected boolean matchesWith(String directoryPath, String resourceName) {
		if (affectsDescendantNodes) {
			// サブディレクトリ全体にマッチするので、
			// ディレクトリパスの前方一致のみを検証する。
			if (!directoryPath.startsWith(this.directoryPath)) {
				return false;
			}
		} else {
			// ディレクトリパスの完全一致を検証
			// (サブディレクトリにはマッチしない。)
			if (!directoryPath.equals(this.directoryPath)) {
				return false;
			}
		}
		return hasResourceNamePattern
				? resourceNamePattern.matcher(resourceName).matches()
				: true;
	}

	/** リクエストパスとして許容する文字 */
	private static final String ALLOWED_CHAR = "[^\\p{Cntrl}/]";

	/** リクエストパスのパターンの書式 */
	private static final Pattern REQUEST_PATH_PATTERN_SYNTAX = Pattern.compile(
			Builder.linesf(
					"(                       " // キャプチャ#1: ディレクトリパス
					, " (?: ^/|^// )           " //   '/' もしくは '//' で開始する。
					, " (?: %s+ //? )*?", ALLOWED_CHAR //   末尾が'/'で区切られたトークンを取得する。
					, ")                       " //
					, "( %s+ )?        ", ALLOWED_CHAR // キャプチャ#2: リソース名
					, "$                       " //   最後の'/'以降の文字列全てを取得する。
			), Pattern.COMMENTS);

	/** リクエストパスの書式 */
	private static final Pattern REQUEST_PATH_SYNTAX = Pattern.compile(
			Builder.linesf(
					"(              " // キャプチャ#1: ディレクトリパス
					, " ^/            " //
					, " (?: %s* / )*? ", ALLOWED_CHAR //
					, ")              " //
					, "( %s+ )?       ", ALLOWED_CHAR // キャプチャ#2: リソース名
			), Pattern.COMMENTS);

	/** {@inheritDoc} */
	public String toString() {
		String directoryPathStr = directoryPath
				+ (affectsDescendantNodes ? "/" : "");
		return Builder.linesf(
				"directoryPath         : %s", directoryPathStr, "resourceName          : %s", resourceName,
				"hasResourceNamePattern: %s", hasResourceNamePattern, "resourceNamePattern   : %s",
				resourceNamePattern);
	}
}
