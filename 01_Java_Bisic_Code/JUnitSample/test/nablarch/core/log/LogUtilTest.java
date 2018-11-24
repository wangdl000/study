package nablarch.core.log;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

import org.junit.Test;

import nablarch.core.ThreadContext;

public class LogUtilTest extends LogTestSupport {

	/**
	 * 実行時IDが正しく生成されること。
	 */
	@Test
	public void testGenerateExecutionId() {

		// 一斉にテストした場合に他のテストの影響を受けるため一旦リセット
		for (int i = 0; i <= 10000; i++) {
			String id = LogUtil.generateExecutionId();
			if ("9999".equals(id.substring(id.length() - 4, id.length()))) {
				break;
			}
		}

		ThreadContext.setRequestId("R123456");
		System.setProperty("nablarch.bootProcess", "APP001");

		// APP001 20110729170315390 0001
		// 0----5 6--------------22 23-26 = 27

		for (int i = 1; i <= 10000; i++) {
			String id = LogUtil.generateExecutionId();
			assertThat(id.length(), is(27));
			if (i == 1) {
				assertThat(id.substring(0, 6), is("APP001"));
				assertThat(id.substring(23), is("0001"));
			} else if (i == 9999) {
				assertThat(id.substring(0, 6), is("APP001"));
				assertThat(id.substring(23), is("9999"));
			} else if (i == 10000) {
				assertThat(id.substring(0, 6), is("APP001"));
				assertThat(id.substring(23), is("0001"));
			}
		}
	}

	/**
	 * フォーマットのプレースホルダに基づき、ログ出力項目を正しく生成できること。
	 */
	@Test
	public void testCreatedLogItems() {

		Map<String, LogItem<String>> logItems = new HashMap<String, LogItem<String>>() {
			{
				put("$test$", new LogItem<String>() {
					public String get(String context) {
						return context;
					}
				});
			}
		};

		Pattern pattern = LogUtil.createReplacementsPattern(new HashSet<String>() {
			{
				add("$test$");
				add("$notFound$");
			}
		});

		LogItem<String>[] formattedLogItems = LogUtil.createFormattedLogItems(logItems, "begin $test$ $notFound$ end",
				pattern);

		String context = "bbb";
		assertThat(formattedLogItems.length, is(5));
		int index = 0;
		assertThat(formattedLogItems[index++].get(context), is("begin "));
		assertThat(formattedLogItems[index++].get(context), is("bbb"));
		assertThat(formattedLogItems[index++].get(context), is(" "));
		assertThat(formattedLogItems[index++].get(context), is("$notFound$"));
		assertThat(formattedLogItems[index++].get(context), is(" end"));
	}

	/**
	 * マップを正しくダンプできること。
	 */
	@Test
	public void testDumpMap() {

		String dump = LogUtil.dumpMap(null, "@");
		assertThat(dump, is("null"));

		Map<String, Object> map = new HashMap<String, Object>();
		dump = LogUtil.dumpMap(map, "@");
		assertThat(dump, is("{}"));

		map.put(null, "aaa");
		map.put("", "bbb");
		map.put("test", "ccc");
		map.put("test_array", new String[] { "ddd1", "ddd2", null, "ddd3" });
		map.put("test_collection", new ArrayList<String>() {
			{
				add("eee1");
				add(null);
				add("eee2");
				add("eee3");
			}
		});
		map.put("test_null", null);
		dump = LogUtil.dumpMap(map, "@");

		int entrySize = 6;
		int entryCount = 0;

		dump = dump.replace("{", "")
				.replace("}", "");

		String[] splitDump = dump.split("@");

		assertThat(splitDump.length, is(entrySize));

		for (int i = 0; i < entrySize; i++) {
			String entry = splitDump[i];
			if (entry.startsWith("null = [aaa]")) {
				entryCount++;
			} else if (entry.startsWith(" = [bbb]")) {
				entryCount++;
			} else if (entry.startsWith("test = [ccc]")) {
				entryCount++;
			} else if (entry.startsWith("test_array = [ddd1, ddd2, null, ddd3]")) {
				entryCount++;
			} else if (entry.startsWith("test_collection = [eee1, null, eee2, eee3]")) {
				entryCount++;
			} else if (entry.startsWith("test_null = [null]")) {
				entryCount++;
			}
		}

		assertThat(dump, entryCount, is(entrySize));

		// with excludeKeyPattern

		Pattern excludes = Pattern.compile("^test_.*");
		dump = LogUtil.dumpMap(map, "@", excludes);

		entrySize = 3;
		entryCount = 0;

		dump = dump.replace("{", "")
				.replace("}", "");

		splitDump = dump.split("@");

		assertThat(splitDump.length, is(entrySize));

		for (int i = 0; i < entrySize; i++) {
			String entry = splitDump[i];
			if (entry.startsWith("null = [aaa]")) {
				entryCount++;
			} else if (entry.startsWith(" = [bbb]")) {
				entryCount++;
			} else if (entry.startsWith("test = [ccc]")) {
				entryCount++;
			} else if (entry.startsWith("test_array = [ddd1, ddd2, null, ddd3]")) {
				entryCount++;
			} else if (entry.startsWith("test_collection = [eee1, null, eee2, eee3]")) {
				entryCount++;
			} else if (entry.startsWith("test_null = [null]")) {
				entryCount++;
			}
		}

		assertThat(dump, entryCount, is(entrySize));

		// with excludeKeyPattern and empty

		excludes = Pattern.compile(".*");
		dump = LogUtil.dumpMap(map, "@", excludes);
		assertThat(dump, is("{}"));
	}

	/**
	 * ダンプ対象のMapに{@link java.math.BigDecimal}が含まれている場合も、指数表現にならずにダンプされること
	 *
	 * @throws Exception
	 */
	@Test
	public void testDumpMapWithBigDecimalValue() throws Exception {
		final Map<String, Object> input = new TreeMap<String, Object>();
		input.put("key1", new BigDecimal("0.0000000009"));
		input.put("key2", "あいうえお");
		final String result = LogUtil.dumpMap(input, " ",
				new LogUtil.BasicMapValueEditor());

		assertThat(result, is("{key1 = [0.0000000009], "
				+ "key2 = [あいうえお]}"));
	}

	/**
	 * マスキング対象の値が指定した文字でマスキングされること。
	 * <p>
	 * マスキング後の値は、5文字固定となること。
	 *
	 * @throws Exception
	 */
	@Test
	public void testDumpMapWithMaskingMap() throws Exception {
		final Map<String, String> input = new TreeMap<String, String>();
		input.put("key", "value");
		input.put("key2", "あいうえお");
		input.put("mask", "1234567890");
		input.put("mask_", "あ");
		final String result = LogUtil.dumpMap(input, " ",
				new LogUtil.MaskingMapValueEditor('*', new Pattern[] { Pattern.compile(".*mask.*") }));

		assertThat(result, is("{key = [value], "
				+ "key2 = [あいうえお], "
				+ "mask = [*****], "
				+ "mask_ = [*****]}"));
	}

	/**
	 * プリミティブの配列を持つMapをダンプできること
	 */
	@Test
	public void testDumpMapWithPrimitiveArray() throws Exception {
		final TreeMap<String, Object> input = new TreeMap<String, Object>();
		input.put("object", "12345");
		input.put("objectArray", new BigDecimal[] { BigDecimal.ONE, new BigDecimal("0.1") });
		input.put("int", 100);
		input.put("intArray", new int[] { 1, 2, 3 });
		input.put("long", 101L);
		input.put("longArray", new long[] { 4, 5, 6 });
		input.put("byte", 0x00);
		input.put("byteArray", new byte[] { 0x00, 0x01, 0x30 });

		final String actual = LogUtil.dumpMap(input, " ");
		assertThat(actual,
				is("{byte = [0],"
						+ " byteArray = [0, 1, 48],"
						+ " int = [100],"
						+ " intArray = [1, 2, 3],"
						+ " long = [101],"
						+ " longArray = [4, 5, 6],"
						+ " object = [12345],"
						+ " objectArray = [1, 0.1]}"));
	}
}
