/*
 * 取り込み元
 *    ライブラリ名：     S2Util
 *    クラス名：         org.seasar.util.io.TraversalUtil
 *    ソースリポジトリ： https://github.com/seasarorg/s2util/blob/master/s2util/src/main/java/org/seasar/util/io/TraversalUtil.java
 *
 * 上記ファイルを取り込み、修正を加えた。
 *
 * Copyright 2016 TIS Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nablarch.core.util;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarFile;

import nablarch.core.util.ClassTraversal.ClassHandler;

/**
 * ファイルシステム上やJarファイル中に展開されているリソースの集まりを扱うユーティリティクラス。
 * <p>
 * 次のプロトコルをサポートしています。
 * </p>
 * <ul>
 * <li>file</li>
 * <li>jar</li>
 * </ul>
 *
 * @author koichik
 */
public final class ResourcesUtil {

	/** 隠蔽コンストラクタ */
	private ResourcesUtil() {
	}

	/** 空の{@link Resources}の配列です。 */
	protected static final Resources[] EMPTY_ARRAY = new Resources[0];

	/** プロトコル毎の{@link ResourcesFactory}を持つ */
	private static final Map<String, ResourcesFactory> RESOURCES_TYPE_FACTORIES = new HashMap<String, ResourcesFactory>();

	static {
		addResourcesFactory("file", new ResourcesFactory() {
			@Override
			public Resources create(final URL url, final String rootPackage, final String rootDir) {
				return new FileSystemResources(getBaseDir(url, rootDir), rootPackage, rootDir);
			}
		});

		addResourcesFactory("jar", new ResourcesFactory() {
			@Override
			public Resources create(final URL url, final String rootPackage,
					final String rootDir) {
				return new JarFileResources(url, rootPackage, rootDir);
			}
		});

		addResourcesFactory("zip", new ResourcesFactory() {
			public Resources create(final URL url, final String rootPackage, final String rootDir) {
				try {
					final String urlString = url.getPath();
					final int pos = urlString.lastIndexOf('!');
					final String zipFilePath = urlString.substring(0, pos);
					final File zipFile = new File(URLDecoder.decode(zipFilePath, "UTF8"));
					JarFile jarFile = new JarFile(new File(zipFile.getCanonicalPath()));
					return new ResourcesUtil.JarFileResources(jarFile, rootPackage, rootDir);
				} catch (IOException e) {
					throw new IllegalArgumentException(e);
				}
			}
		});
	}

	/**
	 * {@link ResourcesFactory}を追加する。
	 *
	 * @param protocol URLのプロトコル
	 * @param factory プロトコルに対応する{@link Resources}のファクトリ
	 */
	public static void addResourcesFactory(final String protocol, final ResourcesFactory factory) {
		RESOURCES_TYPE_FACTORIES.put(protocol, factory);
	}

	/**
	 * 指定のルートパッケージを基点とするリソースの集まりを扱う{@link Resources}の配列を返す。
	 *
	 * @param rootPackage ルートパッケージ
	 * @return 指定のルートパッケージを基点とするリソースの集まりを扱う{@link Resources}の配列
	 */
	public static Resources[] getResourcesTypes(final String rootPackage) {
		if (StringUtil.isNullOrEmpty(rootPackage)) {
			return EMPTY_ARRAY;
		}

		final String baseName = toDirectoryName(rootPackage);
		final List<Resources> list = new ArrayList<Resources>();

		final ClassLoader loader = Thread.currentThread()
				.getContextClassLoader();
		try {
			for (Enumeration<URL> urls = loader.getResources(baseName); urls.hasMoreElements();) {
				final URL url = urls.nextElement();
				final Resources resourcesType = getResourcesType(url, rootPackage, baseName);
				if (resourcesType != null) {
					list.add(resourcesType);
				}
			}
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
		if (list.isEmpty()) {
			return EMPTY_ARRAY;
		}
		return list.toArray(new Resources[list.size()]);
	}

	/**
	 * URLを扱う{@link Resources}を作成する。
	 * <p>
	 * URLのプロトコルが未知の場合は{@code null}を返す。
	 * </p>
	 *
	 * @param url リソースのURL
	 * @param rootPackage ルートパッケージ
	 * @param rootDir ルートディレクトリ
	 * @return URLを扱う{@link Resources}
	 */
	public static Resources getResourcesType(final URL url, final String rootPackage, final String rootDir) {
		final ResourcesFactory factory = RESOURCES_TYPE_FACTORIES.get(url.getProtocol());
		if (factory != null) {
			return factory.create(url, rootPackage, rootDir);
		}
		return null;
	}

	/**
	 * パッケージ名をディレクトリ名に変換する。
	 *
	 * @param packageName パッケージ名
	 * @return ディレクトリ名
	 */
	public static String toDirectoryName(final String packageName) {
		return packageName.replace('.', '/') + '/';
	}

	/**
	 * ファイルを表すURLからルートパッケージの上位となるベースディレクトリを求めて返す。
	 *
	 * @param url ファイルを表すURL
	 * @param baseName ベース名
	 * @return ルートパッケージの上位となるベースディレクトリ
	 */
	public static File getBaseDir(final URL url, final String baseName) {
		File file = toFile(url);
		final String[] paths = baseName.split("\\/");
		for (String path : paths) {
			file = file.getParentFile();
		}
		return file;
	}

	/**
	 * {@link URL}を、{@link JarFile}に変換する。
	 *
	 * @param url URL
	 * @return Jarファイルオブジェクト
	 */
	public static JarFile toJarFile(URL url) {
		try {
			final URLConnection conn = url.openConnection();
			if (conn instanceof JarURLConnection) {
				return ((JarURLConnection) conn).getJarFile();
			} else {
				throw new IllegalArgumentException(
						"url must be JarURLConnection class. specified url class=[" + url.getClass().getName() + ']');
			}
		} catch (IOException e) {
			throw new IllegalArgumentException(url.toString(), e);
		}
	}

	/**
	 * {@link URL}をファイルパスに変換する。
	 * @param url URL URL
	 * @return File ファイルパス
	 */
	public static File toFile(final URL url) {
		try {
			final String path = URLDecoder.decode(url.getPath(), "UTF-8");
			return new File(path).getAbsoluteFile();
		} catch (IOException e) {
			throw new IllegalArgumentException(url.toString(), e);
		}
	}

	/**
	 * {@link Resources}のインスタンスを作成するファクトリインタフェース。
	 */
	public interface ResourcesFactory {

		/**
		 * {@link Resources}のインスタンスを作成する。
		 *
		 * @param url リソースを表すURL
		 * @param rootPackage ルートパッケージ
		 * @param rootDir ルートディレクトリ
		 * @return URLで表されたリソースを扱う{@link Resources}
		 */
		Resources create(URL url, String rootPackage, String rootDir);
	}

	/**
	 * リソースの集まりを表すインタフェース。
	 */
	public interface Resources {

		/**
		 * このインスタンスが扱うリソースの中に存在するクラスを探して
		 * {@link ClassHandler#process(String, String) ハンドラ}をコールバックする。
		 * <p>
		 * インスタンス構築時にルートパッケージが指定されている場合は、 ルートパッケージ以下のクラスのみが対象となる。
		 * </p>
		 *
		 * @param handler ハンドラ
		 */
		void forEach(ClassHandler handler);

		/**
		 * リソースの後処理を行います。
		 */
		void close();

	}

	/**
	 * ファイルシステム上のリソース扱うクラス。
	 */
	public static class FileSystemResources implements Resources {

		/** ベースディレクトリ */
		private final File baseDir;

		/** ルートパッケージ */
		private final String rootPackage;

		/** ルートディレクトリ */
		private final String rootDir;

		/**
		 * インスタンスを構築する。
		 *
		 * @param baseDir ベースディレクトリ
		 * @param rootPackage ルートパッケージ
		 * @param rootDir ルートディレクトリ
		 */
		public FileSystemResources(final File baseDir, final String rootPackage, final String rootDir) {
			this.baseDir = baseDir;
			this.rootPackage = rootPackage;
			this.rootDir = rootDir;
		}

		@Override
		public void forEach(final ClassHandler handler) {
			ClassTraversal.forEach(baseDir, rootPackage, handler);
		}

		/**
		 * リソースのクローズ処理。
		 * <p/>
		 * この実装では何もしない
		 */
		@Override
		public void close() {
		}
	}

	/**
	 * Jarファイル中のリソースの集まりを扱うクラス。
	 */
	public static class JarFileResources implements Resources {

		/** Jarファイル */
		private final JarFile jarFile;

		/** ルートパッケージ */
		private final String rootPackage;

		/** ルートディレクトリ */
		private final String rootDir;

		/**
		 * インスタンスを構築する。
		 *
		 * @param jarFile Jarファイル
		 * @param rootPackage ルートパッケージ
		 * @param rootDir ルートディレクトリ
		 */
		public JarFileResources(final JarFile jarFile, final String rootPackage, final String rootDir) {
			this.jarFile = jarFile;
			this.rootPackage = rootPackage;
			this.rootDir = rootDir;
		}

		/**
		 * インスタンスを構築する。
		 *
		 * @param url Jarファイルを表すURL
		 * @param rootPackage ルートパッケージ
		 * @param rootDir ルートディレクトリ
		 */
		public JarFileResources(final URL url, final String rootPackage, final String rootDir) {
			this(toJarFile(url), rootPackage, rootDir);
		}

		@Override
		public void forEach(final ClassHandler handler) {
			ClassTraversal.forEach(jarFile, new ClassHandler() {

				@Override
				public void process(final String packageName, final String className) {
					if (rootPackage == null || (packageName != null && packageName.startsWith(rootPackage))) {
						handler.process(packageName, className);
					}
				}
			});
		}

		@Override
		public void close() {
			try {
				jarFile.close();
			} catch (IOException e) {
				throw new IllegalStateException(e);
			}
		}

	}
}
