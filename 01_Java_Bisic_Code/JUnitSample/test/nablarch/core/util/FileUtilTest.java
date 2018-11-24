package nablarch.core.util;

import static java.util.Arrays.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

/**
 * FileUtilのテストケース。
 *
 * @author asano
 */
public class FileUtilTest {

	// 一時ディレクトリのルートディレクトリ
	@Rule
	public TemporaryFolder tempDir = new TemporaryFolder();

	@Test
	public void testCloseQuietly1() {
		final BooleanValueHolder closed = new BooleanValueHolder();
		closed.value = false;
		// InputStreamを利用する場合
		InputStream mock = new InputStream() {
			@Override
			public int read() {
				return 0;
			}

			@Override
			public void close() throws IOException {
				closed.value = true;
				throw new IOException();
			}
		};

		FileUtil.closeQuietly(mock);
		assertThat(closed.value, is(true));
	}

	@Test
	public void testCloseQuietly2() {
		final BooleanValueHolder closed = new BooleanValueHolder();
		closed.value = false;
		// OutputStreamを利用する場合
		OutputStream mock = new OutputStream() {
			@Override
			public void close() throws IOException {
				closed.value = true;
				throw new IOException();
			}

			@Override
			public void write(int b) {
			}
		};

		FileUtil.closeQuietly(mock);
		assertThat(closed.value, is(true));
	}

	@Test
	public void testCloseQuietly3() {
		final BooleanValueHolder closed = new BooleanValueHolder();
		closed.value = false;
		// Readerを利用する場合
		Reader mock = new Reader() {
			@Override
			public int read(char[] cbuf, int off, int len) {
				return 0;
			}

			@Override
			public void close() throws IOException {
				closed.value = true;
				throw new IOException();
			}
		};

		FileUtil.closeQuietly(mock);
		assertThat(closed.value, is(true));
	}

	@Test
	public void testCloseQuietly4() {
		final BooleanValueHolder closed = new BooleanValueHolder();
		closed.value = false;
		// Writerを利用する場合
		Writer mock = new Writer() {
			@Override
			public void close() throws IOException {
				closed.value = true;
				throw new IOException();
			}

			@Override
			public void flush() {
			}

			@Override
			public void write(char[] cbuf, int off, int len) {
			}
		};

		FileUtil.closeQuietly(mock);
		assertThat(closed.value, is(true));
	}

	@Test
	public void testCloseQuietly5() {
		FileUtil.closeQuietly((Closeable[]) null);
		FileUtil.closeQuietly((Closeable) null);
	}

	private static final class BooleanValueHolder {
		public boolean value;
	}

	@Test
	public void testListFiles() throws Throwable {

		File tmp = File.createTempFile("tmp", ".txt");
		tmp.delete();
		File baseTmpDir = tmp.getParentFile();
		File tmpDir = new File(baseTmpDir.getAbsolutePath() + File.separator + "FileUtilTest");
		tmpDir.mkdir();
		File file1 = new File(tmpDir, "test1.txt");
		File file2 = new File(tmpDir, "test2.txt");
		File file3 = new File(tmpDir, "test3.log");
		file1.createNewFile();
		file2.createNewFile();
		file3.createNewFile();
		File[] files = FileUtil.listFiles(tmpDir.getAbsolutePath(), "test1.txt");
		file1.deleteOnExit();
		file2.deleteOnExit();
		file3.deleteOnExit();

		assertThat(files.length, is(1));
		assertThat(files[0], is(file1));

		file1.delete();
		file2.delete();
		file3.delete();

	}

	@Test
	public void testCloseQuietly6() {
		// Writerを利用する場合
		Writer mock = new Writer() {
			@Override
			public void close() {
				throw new RuntimeException();
			}

			@Override
			public void flush() {
			}

			@Override
			public void write(char[] cbuf, int off, int len) {
			}
		};

		// 例外が発生しないこと
		FileUtil.closeQuietly(mock);
	}

	@Test
	public void testCloseQuietly7() {
		final boolean[] closed = { false, false };
		Closeable c0 = null;

		Closeable c1 = new Closeable() {
			@Override
			public void close() {
				closed[0] = true;
			}
		};

		Closeable c2 = new Closeable() {
			@Override
			public void close() {
				closed[1] = true;
			}
		};

		FileUtil.closeQuietly(c0, c1, c2);
		assertThat(closed[0], is(true));
		assertThat(closed[1], is(true));
	}

	@Test
	public void testListFilesWildcard() throws Throwable {

		File tmp = File.createTempFile("tmp", ".txt");
		tmp.delete();
		File baseTmpDir = tmp.getParentFile();
		File tmpDir = new File(baseTmpDir.getAbsolutePath() + File.separator + "FileUtilTest");
		tmpDir.mkdir();
		File file1 = new File(tmpDir, "test1.txt");
		File file2 = new File(tmpDir, "test2.txt");
		File file3 = new File(tmpDir, "test3.log");
		File file4 = new File(tmpDir, "test4.txt");
		file1.createNewFile();
		file2.createNewFile();
		file3.createNewFile();
		file4.createNewFile();
		File[] files = FileUtil.listFiles(tmpDir.getAbsolutePath(), "*.txt");
		file1.deleteOnExit();
		file2.deleteOnExit();
		file3.deleteOnExit();

		Arrays.sort(files);
		assertThat(files.length, is(3));
		assertThat(files[0], is(file1));
		assertThat(files[1], is(file2));
		assertThat(files[2], is(file4));

		file1.delete();
		file2.delete();
		file3.delete();
	}

	@Test
	public void testListFilesDirIsNull() throws Throwable {

		File tmp = File.createTempFile("tmp", ".txt");
		tmp.delete();
		File baseTmpDir = tmp.getParentFile();
		File tmpDir = new File(baseTmpDir.getAbsolutePath() + File.separator + "FileUtilTest");
		tmpDir.mkdir();
		File file1 = new File(tmpDir, "test1.txt");
		File file2 = new File(tmpDir, "test2.txt");
		File file3 = new File(tmpDir, "test3.log");
		file1.createNewFile();
		file2.createNewFile();
		file3.createNewFile();
		File[] files = FileUtil.listFiles(null, file1.getAbsolutePath());
		file1.deleteOnExit();
		file2.deleteOnExit();
		file3.deleteOnExit();

		assertThat(files.length, is(1));
		assertThat(files[0], is(file1));

		file1.delete();
		file2.delete();
		file3.delete();
	}

	/**
	 * {@link FileUtil#getResource(String)}のテスト。
	 * <br>
	 * リソースが見つかる場合。
	 *
	 * @throws Exception テスト中に例外が発生した場合
	 */
	@Test
	public void testGetResourceForFoundResource() throws Exception {

		InputStream in = FileUtil.getResource("file:./src/test/resources/nablarch/core/util/test.txt");
		String contents;
		try {
			contents = getContents(in);
		} finally {
			FileUtil.closeQuietly(in);
		}

		assertThat(contents.indexOf("This"), not(is(-1)));
		assertThat(contents.indexOf("file"), not(is(-1)));
		assertThat(contents.indexOf("is"), not(is(-1)));
		assertThat(contents.indexOf("using"), not(is(-1)));
		assertThat(contents.indexOf("FileUtilTest"), not(is(-1)));

		in = FileUtil.getResource("classpath:nablarch/core/util/test.txt");
		try {
			contents = getContents(in);
		} finally {
			FileUtil.closeQuietly(in);
		}

		assertThat(contents.indexOf("This"), not(is(-1)));
		assertThat(contents.indexOf("file"), not(is(-1)));
		assertThat(contents.indexOf("is"), not(is(-1)));
		assertThat(contents.indexOf("using"), not(is(-1)));
		assertThat(contents.indexOf("FileUtilTest"), not(is(-1)));
	}

	/**
	 * {@link FileUtil#getResource(String)}のテスト。
	 * <br>
	 * リソースが見つからない場合。
	 */
	@Test
	public void testGetResourceForNotFoundResource() {
		try {
			FileUtil.getResource(null);
			fail("must be thrown the IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// success
			e.printStackTrace();
			assertThat(e.getMessage(), containsString("the parameter 'url' is required"));
		}
		try {
			FileUtil.getResource("file:./not/found/resource/path.txt");
			fail("must be thrown the IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// success
			e.printStackTrace();
			assertThat(e.getMessage(), containsString("resource open failed"));
			assertThat(e.getMessage(), containsString("file:./not/found/resource/path.txt"));
		}
		try {
			FileUtil.getResource("classpath:not/found/resource/path.txt");
			fail("must be thrown the IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// success
			e.printStackTrace();

			assertThat(e.getMessage(), containsString("resource open failed"));
			assertThat(e.getMessage(), containsString("classpath:not/found/resource/path.txt"));
		}
	}

	/**
	 * {@link FileUtil#getClasspathResource(String)}のテスト。
	 * <br>
	 * リソースが見つかる場合。
	 *
	 * @throws Exception テスト中に例外が発生した場合
	 */
	@Test
	public void testGetClasspathResourceForFoundResource() throws Exception {

		InputStream in = FileUtil.getClasspathResource("nablarch/core/util/test.txt");
		String contents;
		try {
			contents = getContents(in);
		} finally {
			FileUtil.closeQuietly(in);
		}

		assertThat(contents.indexOf("This"), not(is(-1)));
		assertThat(contents.indexOf("file"), not(is(-1)));
		assertThat(contents.indexOf("is"), not(is(-1)));
		assertThat(contents.indexOf("using"), not(is(-1)));
		assertThat(contents.indexOf("FileUtilTest"), not(is(-1)));
	}

	/**
	 * {@link FileUtil#getClasspathResource(String)}のテスト。
	 * <br>
	 * リソースが見つからない場合。
	 */
	@Test
	public void testGetClasspathResourceForNotFoundResource() {
		try {
			FileUtil.getClasspathResource(null);
			fail("must be thrown the IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// success
			e.printStackTrace();
		}
		try {
			FileUtil.getClasspathResource("not/found/resource/path.txt");
			fail("must be thrown the IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// success
			e.printStackTrace();
		}
	}

	private String getContents(InputStream is) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = br.readLine()) != null) {
			sb.append(line);
			sb.append("\n");
		}
		return sb.toString();
	}

	@Test
	public void testDeleteFile() throws IOException {
		File file = tempDir.newFile("a.txt");

		// 念のためファイルが存在するかチェックする
		if (!(file.exists()))
			throw new RuntimeException();

		assertThat(FileUtil.deleteFile(file), is(true));

		assertThat(file.exists(), is(false));
	}

	@Test
	public void testDeleteFileNull() throws IOException {

		try {
			FileUtil.deleteFile(null);
			fail();
		} catch (IllegalArgumentException e) {
			assertThat(true, is(true));
		}
	}

	@Test
	public void testDeleteFileNonExists() throws IOException {
		File file = new File(tempDir.getRoot(), "a.txt");

		// 念のためファイルが存在しないことをチェックする
		if ((file.exists()))
			throw new RuntimeException();

		assertThat(FileUtil.deleteFile(file), is(true));
	}

	/** 拡張子の抽出ができること。 */
	@Test
	public void testExtractSuffix() {
		assertThat(FileUtil.extractSuffix("foo.txt"), is(".txt"));
		assertThat(FileUtil.extractSuffix("foo.tar.gz"), is(".gz")); // ２つ以上の場合は最後尾を取得
		assertThat(FileUtil.extractSuffix(".emacs"), is("")); // 先頭ドットは拡張子とみなさない
		assertThat(FileUtil.extractSuffix("foo."), is("")); // 末尾ドットは拡張子とみなさない
		assertThat(FileUtil.extractSuffix("."), is("")); // ドットのみ
		assertThat(FileUtil.extractSuffix(".emacs.orig.bak"), is(".bak")); // 先頭ドットでも後ろの拡張子は取得
		assertThat(FileUtil.extractSuffix("GTAG"), is("")); // 拡張子なし
		assertThat(FileUtil.extractSuffix(""), is("")); // 空文字
		assertThat(FileUtil.extractSuffix("ほげ.ほげ"), is("")); // 拡張子が非ASCIIの場合は拡張子が空文字列
	}

	/** 引数がnullのとき、例外が発生すること。 */
	@Test(expected = IllegalArgumentException.class)
	public void testExtractSuffixNull() {
		FileUtil.extractSuffix(null);
	}

	/**
	 * ファイルの移動ができること。
	 *
	 * @throws IOException 予期しない例外
	 */
	@Test
	public void testMove() throws IOException {

		// 移動元ファイルの準備
		File src = tempDir.newFile("from.txt");
		FileWriter writer = new FileWriter(src);
		try {
			writer.append("Hello, Nablarch.\nGood Bye.");
			writer.close();
		} finally {
			writer.close();
		}

		// 移動先ファイルの準備
		File dest = new File(tempDir.newFile("to.txt").getPath());
		if (dest.exists()) {
			assertThat("ファイル削除に失敗", dest.delete(), is(true));
		}

		// 実行
		FileUtil.move(src, dest);
		// ファイルが移動されていること
		assertThat(dest.exists(), is(true));
		List<String> moved = readAll(dest);
		assertThat(moved, is(asList("Hello, Nablarch.", "Good Bye.")));
		// 移動元ファイルが存在しないこと
		assertThat(src.exists(), is(false));
	}

	/**
	 * ファイルのコピーができること。
	 *
	 * @throws IOException 予期しない例外
	 */
	@Test
	public void testCopy() throws IOException {
		// 移動元ファイルの準備
		File src = tempDir.newFile("from.txt");
		FileWriter writer = new FileWriter(src);
		try {
			writer.append("Hello, Nablarch.\nGood Bye.\n\uD83C\uDF7A\uD83C\uDF7A\uD83C\uDF7A");
			writer.close();
		} finally {
			writer.close();
		}

		// 移動先ファイルの準備
		File dest = new File(tempDir.newFile("to.txt").getPath());
		if (dest.exists()) {
			assertThat("ファイル削除に失敗", dest.delete(), is(true));
		}
		// 実行
		FileUtil.copy(src, dest);
		// ファイルがコピーされていること
		assertThat(dest.exists(), is(true));
		List<String> copied = readAll(dest);
		assertThat(copied, is(asList("Hello, Nablarch.", "Good Bye.", "\uD83C\uDF7A\uD83C\uDF7A\uD83C\uDF7A")));
		// コピー元ファイルが存在していること
		assertThat(src.exists(), is(true));
	}

	/**
	 * ファイルコピーが失敗した場合、例外が発生すること
	 *
	 * @throws IOException 予期しない例外
	 */
	@Test
	public void testCopyFail() throws IOException {
		File src = new File("not_exists"); // will throw FileNotFoundException
		File dest = new File("dummy");
		try {
			FileUtil.copy(src, dest);
			fail();
		} catch (RuntimeException e) {
			assertThat(e.getCause(), is(instanceOf(IOException.class)));
			assertThat(e.getMessage(), containsString("Failed to copy file"));
		}
	}

	/** 引数がnullのとき、例外が発生すること */
	@Test(expected = IllegalArgumentException.class)
	public void testMove1stArgNull() {
		FileUtil.move(null, new File("dummy"));
	}

	/** 引数がnullのとき、例外が発生すること */
	@Test(expected = IllegalArgumentException.class)
	public void testMove2ndArgNull() {
		FileUtil.move(new File("dummy"), null);
	}

	/** 引数がnullのとき、例外が発生すること */
	@Test(expected = IllegalArgumentException.class)
	public void testCopy1stArgNull() {
		FileUtil.copy(null, new File("dummy"));
	}

	/** 引数がnullのとき、例外が発生すること */
	@Test(expected = IllegalArgumentException.class)
	public void testCopy2ndArgNull() {
		FileUtil.copy(new File("dummy"), null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidResourceURL() {
		FileUtil.getResourceURL("invalid");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetClasspathResourceURLParamNull() {
		FileUtil.getClasspathResourceURL(null);
	}

	private List<String> readAll(File in) throws IOException {

		BufferedReader reader = null;
		List<String> result = new ArrayList<String>();
		try {
			reader = new BufferedReader(new FileReader(in));
			String line;
			while ((line = reader.readLine()) != null) {
				result.add(line);
			}
			return result;
		} finally {
			if (reader != null)
				reader.close();
		}
	}
}
