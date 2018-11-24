package nablarch.core.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import nablarch.core.repository.ObjectLoader;
import nablarch.core.repository.SystemRepository;

/**
 * FilePathSettingTestのテストケース。
 * 
 * 観点：
 * 正常系はフォーマッタのテストで確認しているので、
 * ここでは不正なファイルパスが設定された場合の異常系のテストを網羅する。
 * また、リポジトリからFilePathSettingクラスが取得できることのテストを行う。
 * 
 * @author Masato Inoue
 */
public class FilePathSettingTest {

	@Rule
	public TemporaryFolder temporaryFolder = new TemporaryFolder();

	@Before
	public void setUp() {
		FilePathSetting.getInstance().getBasePathSettings().clear();
	}

	@After
	public void tearDown() throws Exception {
		SystemRepository.clear();
	}

	/**
	 * クラスパスからファイルが取得できることのテスト。
	 */
	@Test
	public void testGetClassPathResource() {
		FilePathSetting setting = FilePathSetting.getInstance();
		setting.addBasePathSetting("classPathBase", "classpath:nablarch/core/util/test");
		File fileOnclassPath = setting.getFileIfExists("classPathBase", "classpathFile.dat");
		assertThat(fileOnclassPath.exists(), is(true));
	}

	/**
	 * クラスパスの参照先がJARの内部パスであった場合は実行時例外を送出する。
	 */
	@Test
	public void testGetResouecesFromJarArchive() {
		FilePathSetting setting = FilePathSetting.getInstance();

		// クラスパスの参照先がJar内のリソースであった場合
		try {
			setting.addBasePathSetting("classPathBase", "classpath:org/junit/Test.class");
			fail();
		} catch (Exception e) {
			assertThat(e instanceof IllegalStateException, is(true));
			assertThat(e.getMessage(), is("invalid base path was specified. a base path can not be "
					+ "a JAR interior path.base path=[classpath:org/junit/Test.class], "
					+ "base path name=[classPathBase]."));
		}

		// クラスパスの参照先がJarアーカイブの内部ディレクトリであった場合
		try {
			setting.addBasePathSetting("classPathBase", "classpath:java/util/");
			fail();
		} catch (Exception e) {
			assertThat(e instanceof IllegalStateException, is(true));
			assertThat(e.getMessage(), is("invalid base path was specified. "
					+ "the assigned path couldn't be found or was inside in a JAR archive."
					+ "base path=[classpath:java/util/], base path name=[classPathBase]."));
		}

		// パスのプロトコル指定が無い場合
		try {
			setting.addBasePathSetting("classPathBase", "/java/util/");
			fail();

		} catch (Exception e) {
			assertThat(e instanceof IllegalArgumentException, is(true));
			assertThat(e.getMessage(), is("illegal url was specified. path=[/java/util/]"));
		}
	}

	/**
	 * リポジトリからFilePathSettingクラスが取得できることのテスト。
	 */
	@Test
	public void testGetInstanceFromRepository() throws Exception {
		// テスト用のリポジトリ構築
		// layoutFileExtensionに「repositoryEx」を設定
		SystemRepository.load(new ObjectLoader() {
			@Override
			public Map<String, Object> load() {
				FilePathSetting filePathSetting = new FilePathSetting();
				filePathSetting.setBasePathSettings(new HashMap<String, String>() {
					{
						put("input", "file:in");
						put("output", "file:out");
					}
				});
				filePathSetting.setFileExtensions(new HashMap<String, String>() {
					{
						put("format", "fmt");
						put("format2", "fmt2");
					}
				});

				Map<String, Object> result = new HashMap<String, Object>();
				result.put("filePathSetting", filePathSetting);
				return result;
			}
		});

		FilePathSetting setting = FilePathSetting.getInstance();

		// 拡張子の設定が有効になっていることの確認
		assertThat(setting.getFileExtensions()
				.get("format"), is("fmt"));
		assertThat(setting.getFileExtensions()
				.get("format"), is("fmt"));

		// ベースパスの設定が有効になっていることの確認 
		assertThat(setting.getBasePathUrl("input")
				.toExternalForm(), is("file:in"));
		assertThat(setting.getBasePathUrl("output")
				.toExternalForm(), is("file:out"));
	}

	/**
	 * 存在しないパスを設定した場合。
	 * @throws Exception
	 */
	@Test
	public void testNotExist() throws Exception {
		try {
			FilePathSetting.getInstance().getFile("nonExist", "test");
			fail();
		} catch (IllegalArgumentException e) {
			assertThat(true, is(true));
		}
	}

	/**
	 * getFileIfExistsメソッドの引数に、存在しないパスを設定した場合、新しくファイルが生成されず、nullが返却されることのテスト。
	 * @throws Exception
	 */
	@Test
	public void testNotCreateNew() throws Exception {
		FilePathSetting.getInstance().addBasePathSetting("input", "file:./");
		File fileIfExists = FilePathSetting.getInstance().getFileIfExists("input", "notExists.dat");
		assertThat(fileIfExists, nullValue());

		// ファイルが生成されない
		File file = new File("./", "notExists.dat");
		assertThat(file.exists(), is(false));
	}

	/**
	 * ベースパスにディレクトリではないパスを設定した場合。
	 * @throws Exception
	 */
	@Test
	public void testBasePathSetDirectory() throws Exception {
		File file = new File("addBasePath.txt");
		file.createNewFile();
		file.deleteOnExit();
		try {
			FilePathSetting.getInstance().addBasePathSetting("input", "file:addBasePath.txt");
			fail();
		} catch (IllegalStateException e) {
			assertThat(e.getMessage(), containsString("invalid base path was specified. "));
			assertThat(e.getMessage(), containsString("base path was not directory. "));
			assertThat(e.getMessage(), containsString("base path=[file:addBasePath.txt], "));
			assertThat(e.getMessage(), containsString("base path name=[input]."));
		}
	}

	/**
	 * ベースパスのディレクトリ名に不正なパスを設定した場合。
	 * @throws Exception
	 */
	@Test
	public void testBasePathSetIllegalPath() throws Exception {

		// Windows環境でない場合は終了する
		if (!getOsName().contains("windows")) {
			return;
		}

		String illegalDirPath = "file:???";

		try {
			FilePathSetting.getInstance().addBasePathSetting("input", illegalDirPath);
			fail();
		} catch (IllegalStateException e) {
			assertThat(e.getMessage(), containsString("couldn't create the base directory. "));
			assertThat(e.getMessage(), containsString("base path=[file:???], "));
			assertThat(e.getMessage(), containsString("base path name=[input]."));
		}
	}

	/**
	 * ファイルの生成に失敗する場合のテスト。
	 * @throws Exception
	 */
	@Test
	public void testCreateNewFileError() throws Exception {

		// Windows環境でない場合は終了する
		if (!getOsName().contains("windows")) {
			return;
		}

		FilePathSetting.getInstance().addBasePathSetting("input", "file:./");

		String illegalPath = "???";

		try {
			FilePathSetting.getInstance().getFile("input", illegalPath);
			fail();
		} catch (RuntimeException e) {
			assertThat(true, is(true)); // IOException
		}
	}

	/**
	 * OS名を取得する。
	 * @return OS名
	 */
	private String getOsName() {
		return System.getProperty("os.name").toLowerCase();
	}

	/**
	 * BasePathに存在しないクラスパス（classpath:）を指定した場合に、IllegalStateExceptionがスローされるテスト。
	 */
	@Test
	public void testBasePathNotFound() throws Exception {

		/*
		 * 存在しないクラスパスのパターン。
		 */
		try {
			FilePathSetting.getInstance()
					.addBasePathSetting("classPathBase",
							"classpath:nablarch/core/util/notExist");
			fail();
		} catch (IllegalStateException e) {
			assertThat(e.getMessage(), containsString("invalid base path was specified. "));
			assertThat(e.getMessage(), containsString("assigned path couldn't be found "));
			assertThat(e.getMessage(), containsString("base path=[classpath:nablarch/core/util/notExist], "));
			assertThat(e.getMessage(), containsString("base path name=[classPathBase]."));
		}
	}

	/**
	 * {@link FilePathSetting#getFileWithoutCreate(String, String)}のテスト。
	 *
	 * 以下のケースを実施する。
	 * <ul>
	 *     <li>ディレクトリは存在するがファイルが存在しない場合でもFileブジェクとが取得できること。/li>
	 * </ul>
	 */
	@Test
	public void testGetFileWithoutCreate() {
		FilePathSetting filePathSetting = FilePathSetting.getInstance();

		// 存在しないディレクトリの場合でもFileオブジェクトが返却されること
		File dir = new File(".");
		assertThat("ディレクトリが存在していることを事前チェック", dir.exists(), is(true));
		filePathSetting.addBasePathSetting("dir", dir.toURI().toString());
		File notFound = filePathSetting.getFileWithoutCreate("dir", "notFound.txt");
		assertThat(notFound.exists(), is(false));
		assertThat(notFound.getName(), is("notFound.txt"));

	}

	@Test
	public void testGetBaseDirectory() throws IOException {
		File testDir = temporaryFolder.getRoot();
		File file = new File(testDir, "file.txt");
		file.delete();
		file.mkdir();

		FilePathSetting filePathSetting = FilePathSetting.getInstance();
		filePathSetting.addBasePathSetting("file", file.toURI().toString());
		filePathSetting.addBasePathSetting("dir", "file:" + testDir.getAbsolutePath());
		file.delete();
		file.createNewFile();

		File dir = filePathSetting.getBaseDirectory("dir");
		assertThat(dir.getName(), is(testDir.getName()));

		try {
			filePathSetting.getBaseDirectory("file");
			fail();
		} catch (Exception e) {
			assertThat(e instanceof IllegalArgumentException, is(true));
		}
	}

	@Test
	public void testAddFileExtensions() {
		FilePathSetting filePathSetting = FilePathSetting.getInstance();
		filePathSetting.addFileExtensions("hoge", "fuga");

		assertThat(filePathSetting.getFileExtensions()
				.get("hoge"), is("fuga"));
	}

	@Test
	public void testGetBasePathSettings() {
		FilePathSetting filePathSetting = FilePathSetting.getInstance();
		assertThat(filePathSetting.getBasePathSettings()
				.size(), is(0));

		filePathSetting.addBasePathSetting("hoge", "file:.");
		assertThat(filePathSetting.getBasePathSettings()
				.size(), is(1));
	}

	@Test
	public void testGetFileNameJoinExtension() {
		FilePathSetting filePathSetting = FilePathSetting.getInstance();

		filePathSetting.addBasePathSetting("root", "file:.");
		assertThat(filePathSetting.getFileNameJoinExtension("root", "filename"), is("filename"));

		filePathSetting.addFileExtensions("root", "hoge");
		assertThat(filePathSetting.getFileNameJoinExtension("root", "filename"), is("filename.hoge"));
	}
}
