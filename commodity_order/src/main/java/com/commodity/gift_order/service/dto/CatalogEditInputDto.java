package com.commodity.gift_order.service.dto;

import java.util.Date;
import java.util.List;

/**
 * <B>CatalogEditInputDto</B><BR>
 * <P>CatalogEditService入力Dto</P><BR>
 * @date  2010.12.09
 * @author  DTT wang-pf
 */
public class CatalogEditInputDto extends BaseInputDto {
	/** 企画コード */
	private String kikakuCd;
	/** カタログID */
	private String catalogId;
	/** カテゴリIDリスト */
	private List<String> genreList;
	/** おすすめ・限定リスト */
	private List<String> limitedList;
	/** 更新年月日 */
	private Date koushinBi;

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
	 * @return the catalogId
	 */
	public String getCatalogId() {
		return catalogId;
	}
	/**
	 * @param catalogId the catalogId to set
	 */
	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}
	/**
	 * @return the genreList
	 */
	public List<String> getGenreList() {
		return genreList;
	}
	/**
	 * @param genreList the genreList to set
	 */
	public void setGenreList(List<String> genreList) {
		this.genreList = genreList;
	}
	/**
	 * @return the limitedList
	 */
	public List<String> getLimitedList() {
		return limitedList;
	}
	/**
	 * @param limitedList the limitedList to set
	 */
	public void setLimitedList(List<String> limitedList) {
		this.limitedList = limitedList;
	}
	/**
	 * @return the koushinBi
	 */
	public Date getKoushinBi() {
		return koushinBi;
	}
	/**
	 * @param koushinBi the koushinBi to set
	 */
	public void setKoushinBi(Date koushinBi) {
		this.koushinBi = koushinBi;
	}
	@Override
	public String toString() {
		return "CatalogEditInputDto [kikakuCd=" + kikakuCd + ", catalogId=" + catalogId + ", genreList=" + genreList
				+ ", limitedList=" + limitedList + ", koushinBi=" + koushinBi + "]";
	}
}
