package nablarch.core.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import nablarch.core.exception.IllegalConfigurationException;
import nablarch.core.repository.ObjectLoader;
import nablarch.core.repository.SystemRepository;

/**
 * {@link NumberUtil}のテスト。
 */
@RunWith(Enclosed.class)
public class NumberUtilTest {

	public static class VerifyBigDecimalScale {

		@Before
		public void setUp() throws Exception {
			SystemRepository.clear();
		}

		@Rule
		public ExpectedException expectedException = ExpectedException.none();

		@Test
		public void scaleが許容範囲の下限の場合例外は送出されないこと() {
			final BigDecimal decimal = new BigDecimal("1e9999");
			NumberUtil.verifyBigDecimalScale(decimal);
		}

		@Test
		public void 小数有りでscaleが許容範囲の下限の場合は例外は送出されないこと() {
			final BigDecimal decimal = new BigDecimal("0.1e10000");
			NumberUtil.verifyBigDecimalScale(decimal);
		}

		@Test
		public void scaleが許容範囲の上限の場合例外は送出されないこと() {
			final BigDecimal decimal = new BigDecimal("1e-9999");
			NumberUtil.verifyBigDecimalScale(decimal);
		}

		@Test
		public void 小数有りでscaleが許容範囲の上限の場合は例外が送出されないこと() {
			final BigDecimal decimal = new BigDecimal("1.1e-9998");
			NumberUtil.verifyBigDecimalScale(decimal);
		}

		@Test
		public void scaleが許容範囲の下限以下の場合例外が送出されること() {
			final BigDecimal decimal = new BigDecimal("1e10000");

			expectedException.expect(IllegalArgumentException.class);
			expectedException.expectMessage("Illegal scale(-10000): needs to be between(-9999, 9999)");
			NumberUtil.verifyBigDecimalScale(decimal);
		}

		@Test
		public void 小数有りでscaleが許容範囲の下限以下の場合は例外が送出されること() {
			final BigDecimal decimal = new BigDecimal("0.1e10001");

			expectedException.expect(IllegalArgumentException.class);
			expectedException.expectMessage("Illegal scale(-10000): needs to be between(-9999, 9999)");
			NumberUtil.verifyBigDecimalScale(decimal);
		}

		@Test
		public void scaleが許容範囲の上限以上の場合は例外が送出されること() {
			final BigDecimal decimal = new BigDecimal("1e-10000");
			expectedException.expect(IllegalArgumentException.class);
			expectedException.expectMessage("Illegal scale(10000): needs to be between(-9999, 9999)");
			NumberUtil.verifyBigDecimalScale(decimal);
		}

		@Test
		public void 小数有りでscaleが許容範囲の上限以上の場合は例外が送出されないこと() {
			final BigDecimal decimal = new BigDecimal("1.1e-10000");
			expectedException.expect(IllegalArgumentException.class);
			expectedException.expectMessage("Illegal scale(10001): needs to be between(-9999, 9999)");
			NumberUtil.verifyBigDecimalScale(decimal);
		}

		@Test
		public void 指数表現ではない値の場合は例外が送出されないこと() throws Exception {
			NumberUtil.verifyBigDecimalScale(new BigDecimal("1.11111111111111111111"));
			NumberUtil.verifyBigDecimalScale(BigDecimal.valueOf(Long.MAX_VALUE));
		}

		@Test
		public void scaleの許容範囲を設定で変更出来ること() throws Exception {
			SystemRepository.load(new ObjectLoader() {
				@Override
				public Map<String, Object> load() {
					final Map<String, Object> result = new HashMap<String, Object>();
					result.put("nablarch.max_scale", 10);
					return result;
				}
			});

			// scale->11
			final BigDecimal decimal = new BigDecimal("1e-11");
			expectedException.expect(IllegalArgumentException.class);
			expectedException.expectMessage("Illegal scale(11): needs to be between(-10, 10)");
			NumberUtil.verifyBigDecimalScale(decimal);
		}

		@Test
		public void scaleの許容範囲に不正な値を設定した場合デフォルトが使用されること() throws Exception {
			SystemRepository.load(new ObjectLoader() {
				@Override
				public Map<String, Object> load() {
					final Map<String, Object> result = new HashMap<String, Object>();
					result.put("nablarch.max_scale", "10あ");
					return result;
				}
			});

			expectedException.expect(IllegalConfigurationException.class);
			expectedException.expectMessage(
					"Must set numeric value to nablarch.max_scale of SystemRepository. configuration value:10あ");
			NumberUtil.verifyBigDecimalScale(new BigDecimal("1e-100000"));
		}

		@Test
		public void scaleの許容範囲に0以下を設定した場合例外が送出されること() throws Exception {
			SystemRepository.load(new ObjectLoader() {
				@Override
				public Map<String, Object> load() {
					final Map<String, Object> result = new HashMap<String, Object>();
					result.put("nablarch.max_scale", 0);
					return result;
				}
			});

			expectedException.expect(IllegalConfigurationException.class);
			expectedException.expectMessage(
					"Must set Greater than 0 to nablarch.max_scale of SystemRepository. configuration value:0");
			NumberUtil.verifyBigDecimalScale(new BigDecimal("0"));
		}
	}
}