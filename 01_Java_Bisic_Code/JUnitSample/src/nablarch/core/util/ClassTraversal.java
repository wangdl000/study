/*
 * 取り込み元
 *    ライブラリ名：     S2Util
 *    クラス名：         org.seasar.util.io.ClassTraversalUtil
 *    ソースリポジトリ： https://github.com/seasarorg/s2util/blob/master/s2util/src/main/java/org/seasar/util/io/ClassTraversalUtil.java
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
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * クラスに対して処理を行うためのユーティリティクラス。
 *
 * @author koichik
 */
public final class ClassTraversal {

	/** クラスファイルの拡張子 */
	private static final String CLASS_EXTENSION = ".class";

	/** warファイルの拡張子 */
	private static final String WAR_FILE_EXTENSION = ".war";

	/** war内にクラスが置かれるディレクトリ */
	private static final String WEB_INF_CLASSES_PATH = "WEB-INF/classes/";

	/**
	 * 隠蔽コンストラクタ
	 */
	private ClassTraversal() {
	}

	/**
	 * ファイルシステム配下の指定されたルートパッケージ以下のクラスを処理する。
	 *
	 * @param rootDir ルートディレクトリ
	 * @param rootPackage ルートパッケージ
	 * @param handler クラスを処理するハンドラ
	 */
	public static void forEach(
			final File rootDir, final String rootPackage, final ClassHandler handler) {
		final File packageDir = getPackageDir(rootDir, rootPackage);
		if (packageDir.exists()) {
			traverseFileSystem(packageDir, rootPackage, handler);
		}
	}

	/**
	 * jarファイルに含まれるクラスを処理する。
	 * <p>
	 * 指定されたjarファイルの拡張子が{@code war}の場合は、 jarファイル内のエントリのうち、
	 * 接頭辞{@code WEB-INF/classes}で始まるパスを持つクラスが対象となる。
	 * クラスを処理するハンドラには、接頭辞を除くエントリ名が渡される。
	 * 例えばjarファイル内に{@code /WEB-INF/classes/ccc/ddd/Eee.class}というクラスファイルが存在すると、
	 * ハンドラにはパッケージ名{@code ccc.ddd}およびクラス名{@code Eee}が渡される。
	 * </p>
	 *
	 * @param jarFile Jarファイル
	 * @param handler クラスを処理するハンドラ
	 */
	public static void forEach(final JarFile jarFile, final ClassHandler handler) {
		if (jarFile.getName()
				.toLowerCase()
				.endsWith(WAR_FILE_EXTENSION)) {
			forEach(jarFile, WEB_INF_CLASSES_PATH, handler);
		} else {
			forEach(jarFile, "", handler);
		}
	}

	/**
	 * jarファイルに含まれるクラスを処理する。
	 * <p>
	 * jarファイル内のエントリのうち、接頭辞で始まるパスを持つクラスが処理対象となる。
	 * <p/>
	 * クラスを処理するハンドラには、接頭辞を除くエントリ名が渡される。
	 * 例えば接頭辞が {@code /aaa/bbb/}で、jarファイル内に {@code /aaa/bbb/ccc/ddd/Eee.class}というクラスファイルが存在すると、
	 * ハンドラには パッケージ名{@code ccc.ddd}およびクラス名{@code Eee}が渡される。
	 * </p>
	 *
	 * @param jarFile Jarファイル
	 * @param prefix トラバースするリソースの名前が含む接頭辞。スラッシュ('/')で終了していなければなりません。
	 * @param handler クラスを処理するハンドラ
	 */
	public static void forEach(final JarFile jarFile, final String prefix,
			final ClassHandler handler) {
		final int startPos = prefix.length();
		@SuppressWarnings("rawtypes")
		final Enumeration enumeration = jarFile.entries();
		while (enumeration.hasMoreElements()) {
			final JarEntry entry = (JarEntry) enumeration.nextElement();
			final String entryName = entry.getName()
					.replace('\\', '/');
			if (entryName.startsWith(prefix)
					&& entryName.endsWith(CLASS_EXTENSION)) {
				final String className = entryName.substring(startPos,
						entryName.length() - CLASS_EXTENSION.length())
						.replace('/', '.');
				final int pos = className.lastIndexOf('.');
				final String packageName = (pos == -1) ? null
						: className
								.substring(0, pos);
				final String shortClassName = (pos == -1) ? className
						: className.substring(pos + 1);
				handler.process(packageName, shortClassName);
			}
		}
	}

	/**
	 * ファイルシステム上のクラスファイルを処理する。
	 * <p/>
	 * サブパッケージが存在する場合には、再帰的に処理を繰り返す。
	 *
	 * @param dir ディレクトリ
	 * @param packageName パッケージ名
	 * @param handler クラスを処理するハンドラ
	 */
	private static void traverseFileSystem(final File dir, final String packageName, final ClassHandler handler) {

		final File[] files = dir.listFiles();
		for (final File file : files) {
			final String fileName = file.getName();
			if (file.isDirectory()) {
				traverseFileSystem(file, packageName == null ? fileName : packageName + '.' + fileName, handler);
			} else if (fileName.endsWith(".class")) {
				final String shortClassName = fileName.substring(0, fileName
						.length()
						- CLASS_EXTENSION.length());
				handler.process(packageName, shortClassName);
			}
		}
	}

	/**
	 * パッケージディレクトリを取得する。
	 *
	 * @param rootDir ルートディレクトリ
	 * @param rootPackage ルートパッケージ
	 * @return File ルートパッケージを示す{@link File}オブジェクト
	 */
	private static File getPackageDir(final File rootDir, final String rootPackage) {
		File packageDir = rootDir;
		if (rootPackage != null) {
			final String[] names = rootPackage.split("\\.");
			for (String name : names) {
				packageDir = new File(packageDir, name);
			}
		}
		return packageDir;
	}

	/**
	 * クラスを横断して処理するためのハンドラインタフェース。
	 *
	 * @author koichik
	 */
	public interface ClassHandler {

		/**
		 * クラスを処理します。
		 *
		 * @param packageName パッケージ名
		 * @param className クラス名
		 */
		void process(String packageName, String className);
	}
}
