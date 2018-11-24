package nablarch.core.date;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import nablarch.core.repository.ObjectLoader;
import nablarch.core.repository.SystemRepository;
import nablarch.util.FixedBusinessDateProvider;

/**
 * {@link BusinessDateUtil}クラスのテストクラス
 * 
 * @author Miki Habu
 */
public class BusinessDateUtilTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	/**
	 * テスト実施前準備
	 * 
	 * @throws SQLException SQL例外
	 */
	@Before
	public void setUp() throws SQLException {
		SystemRepository.load(new ObjectLoader() {
			@Override
			public Map<String, Object> load() {
				FixedBusinessDateProvider dateProvider = new FixedBusinessDateProvider();
				dateProvider.setFixedDate(new HashMap<String, String>() {
					{
						put("00", "20110101");
						put("01", "20110201");
						put("02", "20110301");
					}
				});
				dateProvider.setDefaultSegment("00");
				HashMap<String, Object> result = new HashMap<String, Object>();
				result.put("businessDateProvider", dateProvider);
				return result;
			}
		});

	}

	/**
	 * {@link BusinessDateUtil#getDate()}のテスト
	 */
	@Test
	public void testGetDate() {
		String actual = BusinessDateUtil.getDate();
		Assert.assertThat(actual, is("20110101"));
	}

	/**
	 * {@link BusinessDateUtil#getDate(String)}のテスト
	 */
	@Test
	public void testGetDateBySegment() {
		String actual = BusinessDateUtil.getDate("01");
		Assert.assertThat(actual, is("20110201"));
	}

	/**
	 * {@link BusinessDateUtil#getDate(String)}のテスト<br>
	 * 例外発生
	 */
	@Test
	public void testGetDateSegmentNotFoundErr() {
		try {
			BusinessDateUtil.getDate("03");
			fail();
		} catch (IllegalStateException e) {
			Assert.assertThat(e.getMessage(), is("segment was not found. segment:03."));
		}

	}

	/**
	 * {@link BusinessDateUtil#getDate()}のテスト。
	 * <p/>
	 * リポジトリに値がない場合、例外を送出するかどうか。
	 * @throws Exception
	 */
	@Test
	public void testGetDateNotRegisteredRepositoryErr() throws Exception {
		SystemRepository.clear();
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("specified businessDateProvider is not registered in SystemRepository.");

		BusinessDateUtil.getDate();
	}

	/**
	 * {@link BusinessDateUtil#getAllDate()}のテスト
	 */
	@Test
	public void testGetAllDate() {
		// 想定値の作成
		Map<String, String> expected = new HashMap<String, String>();
		expected.put("00", "20110101");
		expected.put("01", "20110201");
		expected.put("02", "20110301");

		Map<String, String> actual = BusinessDateUtil.getAllDate();
		Assert.assertThat(actual, is(expected));
	}
}
