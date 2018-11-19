package com.commodity.gift_order.service.dto;

public class CatalogInputDto extends BaseInputDto {

	String kikakuCd;

	String catalogId;

	/**
	 * @return kikakuCd
	 */
	public String getKikakuCd() {
		return kikakuCd;
	}

	/**
	 * @param kikakuCd
	 *            セットする kikakuCd
	 */
	public void setKikakuCd(String kikakuCd) {
		this.kikakuCd = kikakuCd;
	}

	public String getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}

	/*
	 * (非 Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CatalogInputDto [kikakuCd=" + kikakuCd + ", catalogId="
				+ catalogId + "]";
	}

}
