/**
 *
 */
package allot;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

/**
 * 按分処理ロジックテスト用クラス
 * @author wangdl
 *
 */
public class AmountAllotLogicTest {

	/**
	 * テスト用入力データ
	 * @return 部門按分金額リスト
	 */
	private static List<AmountAllotBean> getInputList1() {
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
	 * 想定データ１を作成する。
	 * @return 部門按分金額リスト
	 */
	private List<AmountAllotBean> getExpectedList1() {
		AmountAllotBean bean = null;
		List<AmountAllotBean> expectedList = new ArrayList<AmountAllotBean>();
		// １行目
		bean = new AmountAllotBean();
		bean.setDepartment("BM_A");
		bean.setPortion(1);
		bean.setAllotAmount(new BigDecimal("76923"));
		expectedList.add(bean);
		// ２行目
		bean = new AmountAllotBean();
		bean.setDepartment("BM_C");
		bean.setPortion(1);
		bean.setAllotAmount(new BigDecimal("76923"));
		expectedList.add(bean);
		// ３行目
		bean = new AmountAllotBean();
		bean.setDepartment("BM_B");
		bean.setPortion(3);
		bean.setAllotAmount(new BigDecimal("230769"));
		expectedList.add(bean);
		// ４行目
		bean = new AmountAllotBean();
		bean.setDepartment("BM_D");
		bean.setPortion(4);
		bean.setAllotAmount(new BigDecimal("307693"));
		expectedList.add(bean);
		// ５行目
		bean = new AmountAllotBean();
		bean.setDepartment("BM_E");
		bean.setPortion(4);
		bean.setAllotAmount(new BigDecimal("307692"));
		expectedList.add(bean);

		return expectedList;
	}

	/**
	 * 想定データ２を作成する。
	 * @return 部門按分金額リスト
	 */
	private List<AmountAllotBean> getExpectedList2() {
		AmountAllotBean bean = null;
		List<AmountAllotBean> expectedList = new ArrayList<AmountAllotBean>();
		// １行目
		bean = new AmountAllotBean();
		bean.setDepartment("BM_A");
		bean.setPortion(1);
		bean.setAllotAmount(new BigDecimal("76923"));
		expectedList.add(bean);
		// ２行目
		bean = new AmountAllotBean();
		bean.setDepartment("BM_B");
		bean.setPortion(3);
		bean.setAllotAmount(new BigDecimal("230769"));
		expectedList.add(bean);
		// ３行目
		bean = new AmountAllotBean();
		bean.setDepartment("BM_C");
		bean.setPortion(1);
		bean.setAllotAmount(new BigDecimal("76923"));
		expectedList.add(bean);
		// ４行目
		bean = new AmountAllotBean();
		bean.setDepartment("BM_D");
		bean.setPortion(4);
		bean.setAllotAmount(new BigDecimal("307693"));
		expectedList.add(bean);
		// ５行目
		bean = new AmountAllotBean();
		bean.setDepartment("BM_E");
		bean.setPortion(4);
		bean.setAllotAmount(new BigDecimal("307692"));
		expectedList.add(bean);

		return expectedList;
	}

	@SuppressWarnings("deprecation")
	@Test
	public void test_allotAmount_01() {
		// 入力データ取得
		List<AmountAllotBean> inputList = getInputList1();
		BigDecimal totalAmount = new BigDecimal(1000000);
		// 想定データ取得
		List<AmountAllotBean> expectedList1 = getExpectedList1();

		// 按分処理クラス初期化
		AmountAllotLogic amountLogic = new AmountAllotLogic();
		// 按分処理を行う。
		amountLogic.allotAmount(inputList, totalAmount);

		Assert.assertEquals(expectedList1.size(), inputList.size());
		for (int i = 0; i < expectedList1.size(); i++) {
			Assert.assertEquals(expectedList1.get(i).getDepartment(), inputList.get(i).getDepartment());
			Assert.assertEquals(expectedList1.get(i).getPortion(), inputList.get(i).getPortion());
			Assert.assertEquals(expectedList1.get(i).getAllotAmount(), inputList.get(i).getAllotAmount());
		}
	}

	@SuppressWarnings("deprecation")
	@Test
	public void test_allotAmount_02() {
		// 入力データ取得
		List<AmountAllotBean> inputList = getInputList1();
		BigDecimal totalAmount = new BigDecimal(0);
		// 想定データ取得
		List<AmountAllotBean> expectedList1 = inputList;

		// 按分処理クラス初期化
		AmountAllotLogic amountLogic = new AmountAllotLogic();
		// 按分処理を行い、ソートする。
		amountLogic.allotAmountSortByDepartment(inputList, totalAmount);

		Assert.assertEquals(expectedList1.size(), inputList.size());
		for (int i = 0; i < expectedList1.size(); i++) {
			Assert.assertEquals(expectedList1.get(i).getDepartment(), inputList.get(i).getDepartment());
			Assert.assertEquals(expectedList1.get(i).getPortion(), inputList.get(i).getPortion());
			Assert.assertEquals(expectedList1.get(i).getAllotAmount(), inputList.get(i).getAllotAmount());
		}


	}

	@SuppressWarnings("deprecation")
	@Test
	public void test_allotAmountSortByDepartment_01() {
		// 入力データ取得
		List<AmountAllotBean> inputList = getInputList1();
		BigDecimal totalAmount = new BigDecimal(1000000);
		// 想定データ取得
		List<AmountAllotBean> expectedList1 = getExpectedList2();

		// 按分処理クラス初期化
		AmountAllotLogic amountLogic = new AmountAllotLogic();
		// 按分処理を行い、ソートする。
		amountLogic.allotAmountSortByDepartment(inputList, totalAmount);

		Assert.assertEquals(expectedList1.size(), inputList.size());
		for (int i = 0; i < expectedList1.size(); i++) {
			Assert.assertEquals(expectedList1.get(i).getDepartment(), inputList.get(i).getDepartment());
			Assert.assertEquals(expectedList1.get(i).getPortion(), inputList.get(i).getPortion());
			Assert.assertEquals(expectedList1.get(i).getAllotAmount(), inputList.get(i).getAllotAmount());
		}
	}

}
