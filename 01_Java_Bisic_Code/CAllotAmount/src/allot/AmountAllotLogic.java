/**
 *
 */
package allot;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 按分処理ロジッククラス
 * @author wangdl
 *
 */
public class AmountAllotLogic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// テストデータ：部門・金額リスト
		List<AmountAllotBean> amountList = getAmountListForTest();
		// テストデータ：元金額
		BigDecimal totalAmount = new BigDecimal(1000000);

		System.out.println("元金額：" + totalAmount);
		String strInput = null;
		AmountAllotBean inBean = null;
		for (int i = 0; i < amountList.size(); i++) {
			inBean = amountList.get(i);
			strInput = String.format("部門：[%s]\t按分基準：[%s]\t按分金額：[%s]", inBean.getDepartment(), inBean.getPortion(),
					inBean.getAllotAmount());
			System.out.println("按分処理前：" + (i + 1) + "行目のデータ：" + strInput);

			// コメントアウトされた行も試してみてください。
			// System.out.println("按分処理前：" + i + 1 + "行目のデータ：" + strInput);
		}

		// 按分処理クラス初期化
		AmountAllotLogic amountLogic = new AmountAllotLogic();
		// 按分処理を行う。
		amountLogic.allotAmount(amountList, totalAmount);

		for (int i = 0; i < amountList.size(); i++) {
			inBean = amountList.get(i);
			strInput = String.format("部門：[%s]\t按分基準：[%s]\t按分金額：[%s]", inBean.getDepartment(), inBean.getPortion(),
					inBean.getAllotAmount());
			System.out.println("按分処理後：" + (i + 1) + "行目のデータ：" + strInput);
		}

		// 按分後、ソート
		amountLogic.allotAmountSortByDepartment(amountList, totalAmount);
		for (int i = 0; i < amountList.size(); i++) {
			inBean = amountList.get(i);
			strInput = String.format("部門：[%s]\t按分基準：[%s]\t按分金額：[%s]", inBean.getDepartment(), inBean.getPortion(),
					inBean.getAllotAmount());
			System.out.println("按分後、部門よりソート：" + (i + 1) + "行目のデータ：" + strInput);
		}

	}

	/**
	 * テスト用入力データ
	 * @return 部門按分金額リスト
	 */
	private static List<AmountAllotBean> getAmountListForTest() {
		AmountAllotBean bean = null;
		List<AmountAllotBean> inputList = new ArrayList<AmountAllotBean>();
		// １行目
		bean = new AmountAllotBean();
		bean.setDepartment("BM_B");
		bean.setPortion(3);
		bean.setAllotAmount(null);
		inputList.add(bean);
		// ２行目
		bean = new AmountAllotBean();
		bean.setDepartment("BM_A");
		bean.setPortion(1);
		inputList.add(bean);
		// ３行目
		bean = new AmountAllotBean();
		bean.setDepartment("BM_E");
		bean.setPortion(4);
		inputList.add(bean);
		// ４行目
		bean = new AmountAllotBean();
		bean.setDepartment("BM_C");
		bean.setPortion(1);
		inputList.add(bean);
		// ５行目
		bean = new AmountAllotBean();
		bean.setDepartment("BM_D");
		bean.setPortion(4);
		inputList.add(bean);

		return inputList;
	}

	/**
	 * 按分処理を行い、ソートする。
	 * @param amountList 部門按分金額リスト
	 * @param totalAmount 元金額
	 */
	public void allotAmountSortByDepartment(List<AmountAllotBean> amountList, BigDecimal totalAmount) {
		// 按分処理クラス初期化
		AmountAllotLogic amountLogic = new AmountAllotLogic();
		// 按分処理を行う。
		amountLogic.allotAmount(amountList, totalAmount);

		// 部門より、リストをソートする
		Collections.sort(amountList, Util.DEPARTMENT_COMPARATOR);
	}

	/**
	 * 按分処理を行う。
	 * @param amountList 部門按分金額リスト
	 * @param totalAmount 元金額
	 */
	public void allotAmount(List<AmountAllotBean> amountList, BigDecimal totalAmount) {
		if (amountList == null || amountList.isEmpty() || totalAmount == null
				|| BigDecimal.ZERO.compareTo(totalAmount) >= 0) {
			return;
		}
		// 部門按分基準リストのソート処理を行う。
		Collections.sort(amountList, Util.PORTION_COMPARATOR);

		// 按分基準が最大の部門を取得する。
		String maxDepartment = Util.getMatissa(amountList);
		// 按分基準の合計値を取得する。
		int totalPortion = Util.getTotalPortion(amountList);

		BigDecimal bgPortion = null;
		BigDecimal allotAmount = null;
		BigDecimal bgTotalPortion = new BigDecimal(totalPortion);
		for (AmountAllotBean bean : amountList) {
			bgPortion = new BigDecimal(bean.getPortion());
			allotAmount = totalAmount.multiply(bgPortion);
			// 四捨五入（少数0桁）
			// allotAmount = allotAmount.divide(bgTotalPortion); エラーになるため、四捨五入処理で除算する
			allotAmount = allotAmount.divide(bgTotalPortion, 0, RoundingMode.HALF_UP);
			// 引数．部門按分金額リストに按分金額を格納する。
			bean.setAllotAmount(allotAmount);
		}
		// 按分基準が最大の部門の以外の部門の按分金額の合計値を取得する。
		BigDecimal allotAmountExpMax = Util.getTotalAmountExceptMaxDepartment(amountList, maxDepartment);
		// 減算で按分基準が最大の部門に対する按分金額を計算する。（端数処理）
		BigDecimal bgAllotAmountForMax = totalAmount.subtract(allotAmountExpMax);
		for (AmountAllotBean amountAllotBean : amountList) {
			if (maxDepartment.equals(amountAllotBean.getDepartment())) {
				amountAllotBean.setAllotAmount(bgAllotAmountForMax);
			}
		}
	}

}
