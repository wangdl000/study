package com.commodity.gift_order.service.dto;

/**
 * <B>CatalogMeisaiSearchInputDto</B><BR>
 * <P>CatalogMeisaiSearchService入力Dto</P><BR>
 * @date  2010/12/09
 * @author  DTT gao-jp
 */
public class CatalogMeisaiSearchInputDto extends BaseInputDto {

	/** カタログID */
	private String catalogId;

	@Override
	public String toString() {
		return "CatalogMeisaiSearchInputDto [catalogId=" + catalogId + "]";
	}

	/**
	 * カタログIDを取得する。
	 *
	 * @return catalogId
	 */
	public String getCatalogId() {
		return catalogId;
	}

	/**
	 * カタログIDを設定する。
	 *
	 * @param catalogId
	 *            セットする catalogId
	 */
	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}



}
