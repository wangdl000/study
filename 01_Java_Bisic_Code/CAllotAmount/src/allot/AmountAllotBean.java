/**
 *
 */
package allot;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 部門按分金額管理BEANクラス
 * @author wangd
 *
 */
public class AmountAllotBean implements Serializable {

	// serializableインターフェース
	private static final long serialVersionUID = 1L;

	/** 部門 */
	private String department;
	/** 按分基準 */
	private Integer portion;
	/** 按分金額 */
	private BigDecimal allotAmount;

	/**
	 * @return department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department セットする department
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return portion
	 */
	public Integer getPortion() {
		return portion;
	}

	/**
	 * @param portion セットする portion
	 */
	public void setPortion(Integer portion) {
		this.portion = portion;
	}

	/**
	 * @return allotAmount
	 */
	public BigDecimal getAllotAmount() {
		return allotAmount;
	}

	/**
	 * @param allotAmount セットする allotAmount
	 */
	public void setAllotAmount(BigDecimal allotAmount) {
		this.allotAmount = allotAmount;
	}

}
