package com.commodity.gift_order.service.dto;

import java.util.Date;

/**
 * <B>CatalogSearchInputDto</B><BR>
 * <P>CatalogSearchService入力Dto</P><BR>
 * @date  2010.12.09
 * @author DTT kong-fl
 */
public class CatalogSearchInputDto extends BaseInputDto {

	/** 企画コード */
	private String kikakuCd;
	/** カタログ名称 */
	private String catalogName;
	/** 有効期限From */
	private Date catalogYuukouFrom;
	/** 有効期限To */
	private Date catalogYuukouTo;
	/** インデックス（開始件数） */
	private Integer startIndex;
	/** 並び順 */
	private String sortItem;
	/** 表示件数 */
	private Integer limitNum;

	@Override
	public String toString() {
		return "CatalogSearchInputDto [kikakuCd=" + kikakuCd + ", catalogName=" + catalogName + ", catalogYuukouFrom="
				+ catalogYuukouFrom + ", catalogYuukouTo=" + catalogYuukouTo + ", startIndex=" + startIndex
				+ ", sortItem=" + sortItem + ", limitNum=" + limitNum + "]";
	}

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
	 * @return the catalogName
	 */
	public String getCatalogName() {
		return catalogName;
	}

	/**
	 * @param catalogName the catalogName to set
	 */
	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	/**
	 * @return the catalogYuukouFrom
	 */
	public Date getCatalogYuukouFrom() {
		return catalogYuukouFrom;
	}

	/**
	 * @param catalogYuukouFrom the catalogYuukouFrom to set
	 */
	public void setCatalogYuukouFrom(Date catalogYuukouFrom) {
		this.catalogYuukouFrom = catalogYuukouFrom;
	}

	/**
	 * @return the catalogYuukouTo
	 */
	public Date getCatalogYuukouTo() {
		return catalogYuukouTo;
	}

	/**
	 * @param catalogYuukouTo the catalogYuukouTo to set
	 */
	public void setCatalogYuukouTo(Date catalogYuukouTo) {
		this.catalogYuukouTo = catalogYuukouTo;
	}

	/**
	 * @return the startIndex
	 */
	public Integer getStartIndex() {
		return startIndex;
	}

	/**
	 * @param startIndex the startIndex to set
	 */
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	/**
	 * @return the sortItem
	 */
	public String getSortItem() {
		return sortItem;
	}

	/**
	 * @param sortItem the sortItem to set
	 */
	public void setSortItem(String sortItem) {
		this.sortItem = sortItem;
	}

	/**
	 * @return the limitNum
	 */
	public Integer getLimitNum() {
		return limitNum;
	}

	/**
	 * @param limitNum the limitNum to set
	 */
	public void setLimitNum(Integer limitNum) {
		this.limitNum = limitNum;
	}
}
