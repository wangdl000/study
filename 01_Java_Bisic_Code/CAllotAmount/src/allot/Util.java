/**
 *
 */
package allot;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

/**
 * 共通処理クラス
 * @author wangdl
 *
 */
public class Util {

	/**
	 * ソート規則設定処理を行う。<br>
	 * 按分基準<br>
	 * 部門
	 */
	public static final Comparator<AmountAllotBean> PORTION_COMPARATOR = new Comparator<AmountAllotBean>() {

		@Override
		public int compare(AmountAllotBean o1, AmountAllotBean o2) {
			int result = 0;
			if (o1.getPortion().compareTo(o2.getPortion()) == 0) {
				result = o1.getDepartment().compareTo(o2.getDepartment());
			} else {
				result = o1.getPortion().compareTo(o2.getPortion());
			}
			return result;
		}
	};
	/**
	 * ソート規則設定処理を行う。<br>
	 * 部門
	 */
	public static final Comparator<AmountAllotBean> DEPARTMENT_COMPARATOR = new Comparator<AmountAllotBean>() {

		@Override
		public int compare(AmountAllotBean o1, AmountAllotBean o2) {
			return o1.getDepartment().compareTo(o2.getDepartment());
		}
	};

	/**
	 * 按分基準の合計値を取得する。
	 * @param amountList 部門按分金額リスト
	 * @return 按分基準合計値
	 */
	public static int getTotalPortion(List<AmountAllotBean> amountList) {
		int totalPotion = 0;
		for (AmountAllotBean amountAllotBean : amountList) {
			totalPotion += amountAllotBean.getPortion();
		}
		return totalPotion;
	}

	/**
	 * 按分基準が最大の部門を取得する。
	 * @param amountList 部門按分金額リスト（ソート後）
	 * @return 部門
	 */
	public static String getMatissa(List<AmountAllotBean> amountList) {
		String department = "";
		int size = amountList.size();
		int maxPortion = amountList.get(size - 1).getPortion();
		int portion = 0;
		for (int i = 0; i < size; i++) {
			portion = amountList.get(i).getPortion();
			if (portion == maxPortion) {
				department = amountList.get(i).getDepartment();
				break;
			}
		}
		return department;
	}

	/**
	 * 按分基準が最大の部門の以外の部門の按分金額の合計値を取得する。
	 * @param amountList 部門按分金額リスト
	 * @param maxDepartment 按分基準が最大の部門
	 * @return 金額合計値
	 */
	public static BigDecimal getTotalAmountExceptMaxDepartment(List<AmountAllotBean> amountList, String maxDepartment) {
		BigDecimal amount = new BigDecimal(0);
		for (AmountAllotBean bean : amountList) {
			// 按分基準が最大の部門を除外する
			if (maxDepartment.equals(bean.getDepartment())) {
				continue;
			}
			amount = amount.add(bean.getAllotAmount());

		}
		return amount;
	}

}
