package com.commodity.gift_order.service.dto;

/**
 * <B>CodeSearchInputDto</B><BR>
 * <P>CodeSearchService入力Dto</P><BR>
 * @date  2010/12/08
 * @author  DTT zhao-wj
 */
public class CodeSearchInputDto extends BaseInputDto {
	/** 識別コード */
	private String sikibetsuCd;

	/**
	 * @return the sikibetsuCd
	 */
	public String getSikibetsuCd() {
		return sikibetsuCd;
	}

	/**
	 * @param sikibetsuCd the sikibetsuCd to set
	 */
	public void setSikibetsuCd(String sikibetsuCd) {
		this.sikibetsuCd = sikibetsuCd;
	}

	@Override
	public String toString() {
		return "CodeSearchInputDto [sikibetsuCd=" + sikibetsuCd + "]";
	}
}
