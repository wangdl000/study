package com.commodity.gift_order.service.dto;

public class CatalogGenreInputDto extends BaseInputDto {

	String catalogId;

	public String getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}

	@Override
	public String toString() {
		return "CatalogGenreInputDto [catalogId=" + catalogId + "]";
	}

}
