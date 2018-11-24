package nablarch.core.util.map;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

public class CaseInsensitiveMapTest {

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorParamNull() {
		new CaseInsensitiveMap<String>(null);
	}

	@Test
	public void testGetAndPutWorksProperly() {
		Map<String, String> map = new CaseInsensitiveMap<String>(new HashMap<String, String>()) {
			{
				put("key1", "val1");
				put("KEY2", "val2");
				put("KeY3", "val3");
				put(null, "nullKey");
			}
		};

		assertThat(map.get("key1"), is("val1"));
		assertThat(map.get("KEY1"), is("val1"));
		assertThat(map.get("keY1"), is("val1"));

		assertThat(map.get("key2"), is("val2"));
		assertThat(map.get("KEY2"), is("val2"));
		assertThat(map.get("keY2"), is("val2"));

		assertThat(map.put("KEY3", "val3_updated"), is("val3"));
		assertThat(map.size(), is(4));
		assertThat(map.get("key3"), is("val3_updated"));

		assertThat(map.get(null), is("nullKey"));
	}

	@Test
	public void testPutAll() {
		Map<String, String> map = new CaseInsensitiveMap<String>() {
			{
				put("key1", "val1");
				put("KEY2", "val2");
				put("KeY3", "val3");
			}
		};

		map.putAll(map);
		assertThat(map, is(map));

		Map<String, String> map2 = new CaseInsensitiveMap<String>() {
			{
				put("key5", "val5");
				put("KEY6", "val6");
				put("KEY1", "val1");
			}
		};

		map.putAll(map2);
		assertThat(map.size(), is(5));
		assertThat(map.get("key5"), is("val5"));
		assertThat(map.get("key1"), is("val1"));
	}

	@Test
	public void testContainsValue() {
		Map<String, String> map = new CaseInsensitiveMap<String>() {
			{
				put("key", "value");
			}
		};

		assertThat(map.containsValue("value"), is(true));
		assertThat(map.containsValue("VALUE"), is(false));
	}

	@Test
	public void testGetDelegateMapOfType() {
		CaseInsensitiveMap<String> map = new CaseInsensitiveMap<String>() {
			{
				put("key", "value");
			}
		};
		assertThat(map.getDelegateMapOfType(LinkedHashMap.class), is(nullValue()));
		assertThat((CaseInsensitiveMap<String>) map.getDelegateMapOfType(CaseInsensitiveMap.class), is(map));
		assertThat(map.getDelegateMapOfType(ConcurrentHashMap.class), is(new ConcurrentHashMap(map)));
	}

	@Test
	public void testEquals() {
		Map<String, String> map1 = new CaseInsensitiveMap<String>() {
			{
				put("key", "value");
			}
		};
		Map<String, String> map2 = new CaseInsensitiveMap<String>() {
			{
				put("key", "value");
			}
		};

		assertThat(map1.hashCode(), is(map2.hashCode()));
	}

	@Test
	public void testToString() {
		Map<String, String> map = new CaseInsensitiveMap<String>() {
			{
				put("key1", "val1");
				put("KEY2", "val2");
				put("KeY3", "val3");
			}
		};

		assertThat(map.toString()
				.startsWith("{"), is(true));
		assertThat(map.toString(), containsString("key1=val1"));
		assertThat(map.toString(), containsString("key2=val2"));
		assertThat(map.toString(), containsString("key3=val3"));
		assertThat(map.toString()
				.endsWith("}"), is(true));

		Map<String, String> map2 = new CaseInsensitiveMap<String>() {
			{
				put("key1", "val1");
				put("key2", "val2");
				put("key3", "val3");
			}
		};

		assertThat(map2, is(map));
	}
}