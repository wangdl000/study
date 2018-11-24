package nablarch.core.util.map;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import nablarch.core.util.map.LRUMap.RemoveListener;

/**
 * {@link LRUMap}のテストクラス。
 *
 * @author T.Kawasaki
 */
public class LRUMapTest {

	/** テスト対象 */
	private LRUMap<Integer, String> target = new LRUMap<Integer, String>(3);

	/** データ投入 */
	@Before
	public void setUp() {
		target.put(1, "one");
		target.put(2, "two");
		target.put(3, "three");
	}

	/** 等価なMapとの比較が成功すること。 */
	@Test
	public void testEquals() {
		Map<Integer, String> expected = new HashMap<Integer, String>() {
			{
				put(1, "one");
				put(2, "two");
				put(3, "three");
			}
		};
		assertThat(target, is(expected));
		assertThat(target.equals(expected), is(true));
	}

	/** 最大容量を超えた場合にエントリが削除されること */
	@Test
	public void testRemoveEntry() {
		assertThat(target.size(), is(3));

		target.put(4, "four");
		Map<Integer, String> expected = new HashMap<Integer, String>() {
			{
				put(2, "two");
				put(3, "three");
				put(4, "four");
			}
		};
		assertThat(target, is(expected));
		assertThat(target.size(), is(3));
	}

	/** 最大容量を超えた場合に、最も参照されていないエントリが削除されること */
	@Test
	public void testRemoveLeastRecentlyUsedEntry() {
		assertThat(target.size(), is(3));

		target.get(1); // 1を参照
		target.put(4, "four");
		Map<Integer, String> expected = new HashMap<Integer, String>() {
			{
				put(1, "one");
				put(3, "three");
				put(4, "four");
			}
		};
		assertThat(target, is(expected));
	}

	/** 最小容量のテスト */
	@Test
	public void testMinimumSize() {
		LRUMap<Integer, String> target = new LRUMap<Integer, String>(1);// OK
		target.put(1, "one");
		Map<Integer, String> expected = new HashMap<Integer, String>() {
			{
				put(1, "one");
			}
		};
		assertThat(target, is(expected));
		assertThat(target.size(), is(1));

		target.put(2, "two");
		expected = new HashMap<Integer, String>() {
			{
				put(2, "two");
			}
		};
		assertThat(target, is(expected));
		assertThat(target.size(), is(1));
	}

	@Test
	public void testListener() {
		MockListener mock = new MockListener();
		target = new LRUMap<Integer, String>(1, mock);
		target.put(1, "one");
		assertThat(mock.called, is(false));

		target.put(2, "two");
		assertThat(target.size(), is(1));
		assertThat(mock.called, is(true));
		assertThat(mock.key, is(1));
		assertThat(mock.value, is("one"));
	}

	private static class MockListener implements RemoveListener<Integer, String> {

		boolean called = false;
		Integer key = null;
		String value = null;

		@Override
		public void onRemoveEldest(Integer key, String value) {
			called = true;
			this.key = key;
			this.value = value;
		}
	}

	/** 最大容量が0のとき例外が発生すること。 */
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidSizeZero() {
		new LRUMap(0);
	}

	/** 最大容量が負数のとき例外が発生すること。 */
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidSizeMinus() {
		new LRUMap(-1);
	}

	/** 初期容量が負数のとき例外が発生すること。 */
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidInitialCapacity() {
		new LRUMap(-1, 10);
	}

	/** 負荷係数が0以下のとき例外が発生すること。*/
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidLoadFactor() {
		new LRUMap(1, 0f, 10);
	}

}
