package nablarch.core.util;

import java.math.BigDecimal;

import nablarch.core.exception.IllegalConfigurationException;
import nablarch.core.repository.SystemRepository;

/**
 * 数値に関するユーティリティクラス。
 *
 * @author siosio
 */
public final class NumberUtil {

	/** BigDecimalのscale */
	private static final int MAX_SCALE = 9999;

	/**
	 * コンストラクタ。
	 */
	private NumberUtil() {
	}

	/**
	 * {@link BigDecimal#scale()} が許容する範囲内かをチェックする。
	 * <p>
	 * 許容する範囲は、{@link #getMaxScale()}より取得する。
	 *
	 * @param value チェック対象
	 */
	public static void verifyBigDecimalScale(final BigDecimal value) {
		final int maxScale = getMaxScale();
		final int scale = value.scale();
		if (scale < -maxScale || scale > maxScale) {
			throw new IllegalArgumentException(
					String.format("Illegal scale(%d): needs to be between(-%d, %d)", scale, maxScale, maxScale));
		}
	}

	/**
	 * 許容するscaleを返す。
	 * <p>
	 * システムリポジトリから「nablarch.max_scale」が取得出来る場合はその値を、
	 * 取得できない場合はデフォルトの{@link #MAX_SCALE}を返す。
	 *
	 * @return 許容するscale
	 */
	private static int getMaxScale() {
		final Object maxScale = SystemRepository.get("nablarch.max_scale");
		if (maxScale == null) {
			return MAX_SCALE;
		} else {
			try {
				final int value = Integer.valueOf(maxScale.toString());
				if (value <= 0) {
					throw new IllegalConfigurationException(
							"Must set Greater than 0 to nablarch.max_scale of SystemRepository."
									+ " configuration value:" + maxScale);
				}
				return value;
			} catch (NumberFormatException e) {
				throw new IllegalConfigurationException(
						"Must set numeric value to nablarch.max_scale of SystemRepository."
								+ " configuration value:" + maxScale,
						e);
			}
		}
	}
}
