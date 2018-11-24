package nablarch.core.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

import nablarch.core.util.annotation.Published;

/**
 * ファイルの取り扱いに関するユーティリティクラス。
 *
 * @author Koichi Asano
 * @author Masato Inoue
 */
@Published(tag = "architect")
public final class FileUtil {

	/** 隠蔽コンストラクタ。 */
	private FileUtil() {
	}

	/**
	 * リソースを解放する。
	 * <p/>
	 * 例外が発生した場合は何もせず、次のリソース解放を行う。
	 *
	 * @param closeables リソース解放を行うクラス
	 */
	public static void closeQuietly(Closeable... closeables) {
		if (closeables == null) {
			return;
		}

		for (Closeable closeable : closeables) {
			try {
				if (closeable != null) {
					closeable.close();
				}
			} catch (IOException e) { // SUPPRESS CHECKSTYLE 例外を抑止するため
			} catch (RuntimeException e) { // SUPPRESS CHECKSTYLE 例外を抑止するため
				// closable.close() で実行時例外が発生した場合に、呼び出し元の finally 句でエラーが発生してしまうことを考慮してもみ消す。
			}
		}
	}

	/**
	 * リソースを取得する。
	 * <p/>
	 * ファイルパスまたはクラスパス上のリソースを取得する。<br/>
	 * 引数に指定するURLのフォーマットは下記の通り。
	 * <pre>
	 *     &lt;スキーム名&gt;:&lt;リソースのパス&gt;
	 * </pre>
	 * URLの指定例を下記に示す。
	 * <code><pre>
	 * //ファイルパスの場合
	 * FileUtil.getResource("file:/var/log/log.properties");
	 *
	 * //クラスパスの場合
	 * FileUtil.getResource("classpath:nablarch/core/log/log.properties");
	 * </pre></code>
	 *
	 * @param url URL
	 * @return リソースのストリーム
	 * @throws IllegalArgumentException リソースを取得できなかった場合
	 * @throws java.io.FileNotFoundException リソースファイルが見つからなかった場合
	 */
	public static InputStream getResource(String url) throws IllegalArgumentException {
		URL resourceURL = getResourceURL(url);
		try {
			return resourceURL.openStream();
		} catch (Throwable e) {
			throw new IllegalArgumentException("resource open failed. url = [" + url + "].", e);
		}
	}

	/**
	 * URLを取得する。
	 * <p/>
	 * ファイルパスまたはクラスパス上のURLを取得する。<br/>
	 * 引数に指定するURLのフォーマットは下記の通り。
	 * <pre>
	 *     {@literal <スキーム名>:<リソースのパス>}
	 * </pre>
	 * URLの指定例を下記に示す。
	 * <code><pre>
	 * //ファイルパスの場合
	 * FileUtil.getResourceURL("file:/var/log/log.properties");
	 *
	 * //クラスパスの場合
	 * FileUtil.getResourceURL("classpath:nablarch/core/log/log.properties");
	 * </pre></code>
	 *
	 * @param url URL文字列
	 * @return リソースのURL
	 * @throws IllegalArgumentException URLが{@code null}または不正だった場合
	 */
	public static URL getResourceURL(String url) {
		if (url == null) {
			throw new IllegalArgumentException(
					"the parameter 'url' is required.");
		}
		if (url.startsWith("classpath:")) {
			return getClasspathResourceURL(url.substring("classpath:".length()));
		}
		try {
			return new URL(url);
		} catch (MalformedURLException e) {
			throw new IllegalArgumentException(String.format("illegal url was specified. path=[%s]", url), e);
		}
	}

	/**
	 * クラスパス上のリソースを取得する。
	 * <p/>
	 * 以下に例を示す。
	 * <code><pre>
	 * FileUtil.getClasspathResource("nablarch/core/log/log.properties");
	 * </pre></code>
	 *
	 * @param path クラスパス
	 * @return リソースのストリーム
	 * @throws IllegalArgumentException クラスパス及びクラスパスから取得するURLが{@code null}または、リソースが見つからない場合
	 */
	public static InputStream getClasspathResource(String path) throws IllegalArgumentException {
		if (path == null) {
			throw new IllegalArgumentException(
					"the parameter 'path' is required.");
		}
		URL url = getClasspathResourceURL(path);

		if (url == null) {
			throw new IllegalArgumentException(
					"the resource path[" + path + "] could not be found.");
		}

		InputStream inStream;
		try {
			inStream = url.openStream();
		} catch (Throwable e) {
			throw new IllegalArgumentException("It failed to get the resource["
					+ url + "].", e);
		}
		return inStream;
	}

	/**
	 * クラスパス上のURLを取得する。
	 * <p/>
	 * 以下に例を示す。
	 * <code><pre>
	 * FileUtil.getClasspathResource("nablarch/core/log/log.properties");
	 * </pre></code>
	 *
	 * @param path リソースのパス
	 * @return リソースのURL
	 * @throws IllegalArgumentException クラスパスが{@code null}だった場合
	 */
	public static URL getClasspathResourceURL(String path) {
		if (path == null) {
			throw new IllegalArgumentException(
					"the parameter 'path' is required.");
		}
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		return loader.getResource(path);
	}

	/**
	 * ディレクトリ配下のファイルおよびディレクトリを検索し、名前で昇順ソートした結果の配列を返す。
	 * <p/>
	 * ファイル名にはワイルドカード("*")を指定できる。<br/>
	 * ディレクトリは、絶対パスまたは相対パスで指定する。<br/>
	 * ディレクトリが{@code null}だった場合、引数のファイル名を元に構築したFileオブジェクトを持つ要素が１つの配列が返される。<br/>
	 *
	 * @param dir  ディレクトリ(null指定の場合、指定なし)
	 * @param name ファイル名
	 * @return 検索結果の配列
	 * @throws NullPointerException ファイル名が{@code null}だった場合
	 */
	public static File[] listFiles(String dir, final String name) {
		if (dir == null) {
			return new File[] {
					new File(name) };
		}
		File dirFile = new File(dir);
		FilenameFilter filter;
		filter = new FilenameFilter() {
			private Pattern pattern = Pattern.compile(name.replace(
					"\\", "\\\\").replace("*", ".*").replace("/", "\\/"));

			public boolean accept(File dir, String name) {

				return pattern.matcher(name).matches();
			}
		};

		File[] unsortedFiles = dirFile.listFiles(filter);
		if (unsortedFiles == null) {
			return null;
		}
		List<File> files = Arrays.asList(unsortedFiles);

		// File#listFiles() は "There is no guarantee that the name strings in the resulting array will appear in any
		// specific order"
		// であるため、念のために自前でソートを行う。

		Comparator<File> comparator = new Comparator<File>() {

			public int compare(File f1, File f2) {
				return f1.getName().compareTo(f2.getName());
			}
		};

		Collections.sort(files, comparator);
		return files.toArray(new File[files.size()]);
	}

	/**
	 * ファイルを削除する。
	 *
	 * @param file 削除するファイル
	 * @return ファイルが削除に成功した場合は{@code true}、失敗した場合は{@code false}を返却する。ファイルが存在しない場合は{@code true}を返却する。
	 * @throws IllegalArgumentException 削除するファイルが{@code null}だった場合
	 */
	public static boolean deleteFile(File file) {
		if (file == null) {
			throw new IllegalArgumentException("file is null.");
		}
		if (!file.exists()) {
			return true;
		}
		if (!file.delete()) {
			return false;
		}
		return true;
	}

	/**
	 * ファイル名から拡張子を抽出する。
	 * <p/>
	 * 以下の仕様に当てはまる場合は、空文字列を返す。
	 * <ol>
	 *     <li>ファイル名の先頭がドット</li>
	 *     <li>ファイル名の末尾がドット</li>
	 *     <li>拡張子にドットがない</li>
	 *     <li>拡張子が英数字以外</li>
	 * </ol>
	 *
	 * @param fileName ファイル名
	 * @return 拡張子
	 * @throws IllegalArgumentException ファイル名が{@code null}だった場合
	 */
	public static String extractSuffix(String fileName) {
		if (fileName == null) {
			throw new IllegalArgumentException("argument must not be null.");
		}

		int start = fileName.lastIndexOf(".");

		if (start == -1) { // ドットが無い
			return "";
		}

		if (start == 0) { // ファイル名先頭がドット
			return "";
		}

		// 拡張子
		String ext = fileName.substring(start);
		if (ext.length() == 1) { // ファイル名末尾がドット
			return "";
		}

		// ドットを省いた拡張子部分
		String extWithOutDot = ext.substring(1);
		// 非ASCII文字の場合、拡張子とはみなさない。
		if (!ALNUM_CHAR_PATTERN.matcher(extWithOutDot).matches()) {
			return "";
		}

		return ext;
	}

	// CHANGE validationへの依存を切るため、自前で英数字判定する。
	private static Pattern ALNUM_CHAR_PATTERN = Pattern.compile("[0-9a-zA-Z]*");

	/**
	 * ファイルを移動する。
	 * <p/>
	 * 移動先に同名のファイルが存在していた場合、上書きする。
	 *
	 * @param src  移動元ファイル
	 * @param dest 移動先ファイル
	 * @throws IllegalArgumentException 移動元ファイルまたは移動先ファイルが{@code null}の場合
	 * @throws RuntimeException コピー元のファイルが削除できなかった場合
	 */
	public static void move(File src, File dest) {
		if (src == null) {
			throw new IllegalArgumentException("src must not be null.");
		}
		if (dest == null) {
			throw new IllegalArgumentException("dest must not be null.");
		}

		if (src.renameTo(dest)) {
			return;
		}
		// コピー後、オリジナルを削除
		copy(src, dest);
		if (!deleteFile(src)) {
			throw new RuntimeException(
					"Failed to delete original file "
							+ "[" + src.getAbsolutePath() + "]"
							+ ", after copying to [" + dest.getAbsolutePath() + "]");
		}
	}

	/**
	 * ファイルをコピーする。
	 * <p/>
	 * コピー先に同名のファイルが存在していた場合、上書きする。
	 *
	 * @param src  コピー元ファイル
	 * @param dest コピー先ファイル
	 * @throws IllegalArgumentException コピー元ファイルまたはコピー先ファイルが{@code null}の場合
	 * @throws RuntimeException コピーに失敗した場合
	 */
	public static void copy(File src, File dest) {
		if (src == null) {
			throw new IllegalArgumentException("src must not be null.");
		}
		if (dest == null) {
			throw new IllegalArgumentException("dest must not be null.");
		}
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new BufferedInputStream(new FileInputStream(src));
			out = new BufferedOutputStream(new FileOutputStream(dest));
			copy(in, out);
		} catch (IOException e) {
			throw new RuntimeException(
					"Failed to copy file."
							+ " src=[" + src.getAbsolutePath() + "]"
							+ " to=[" + dest.getAbsolutePath() + "]",
					e);
		} finally {
			closeQuietly(in, out);
		}
	}

	/**
	 * ストリームのコピーを行う。
	 *
	 * @param src  コピー元入力ストリーム
	 * @param dest コピー先出力ストリーム
	 * @throws IOException 入出力例外
	 */
	private static void copy(InputStream src, OutputStream dest) throws IOException {
		int b;
		while ((b = src.read()) != -1) {
			dest.write(b);
		}
	}
}
