package com.commodity.gift_order.service.dto;

import java.util.Date;

/**
 * <B>CatalogListInputDto</B><BR>
 * <P>CatalogListService入力Dto</P><BR>
 * @date  2010.12.08
 * @author  DTT wang-pf
 */
public class CatalogListInputDto extends BaseInputDto {

	/** 企画コード */
	private String kikakuCd;
	/** カタログ有効期限判定用の基準日 */
	private Date kijunBi;
	/** コースコード */
	private String courseCd;

	/**
	 * @return the kikakuCd
	 */
	public String getKikakuCd() {
		return kikakuCd;
	}
	/**
	 * @param kikakuCd the kikakuCd to set
	 */
	public void setKikakuCd(String kikakuCd) {
		this.kikakuCd = kikakuCd;
	}
	/**
	 * @return the kijunBi
	 */
	public Date getKijunBi() {
		return kijunBi;
	}
	/**
	 * @param kijunBi the kijunBi to set
	 */
	public void setKijunBi(Date kijunBi) {
		this.kijunBi = kijunBi;
	}

	/**
	 * @return the courseCd
	 */
	public String getCourseCd() {
		return courseCd;
	}
	/**
	 * @param courseCd the courseCd to set
	 */
	public void setCourseCd(String courseCd) {
		this.courseCd = courseCd;
	}
	@Override
	public String toString() {
		return "CatalogListInputDto [kikakuCd=" + kikakuCd + ", kijunBi=" + kijunBi + ", courseCd=" + courseCd + "]";
	}
}
