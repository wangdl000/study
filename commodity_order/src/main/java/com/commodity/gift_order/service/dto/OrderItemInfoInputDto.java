package com.commodity.gift_order.service.dto;

public class OrderItemInfoInputDto extends BaseInputDto {

	private String catalogId;

	private String hagakiSyouhinCd;

	private String hagakiSyouhinCdFormat;

	private String hagakiSyouhinCdSplit;

	public String getHagakiSyouhinCdFormat() {
		return hagakiSyouhinCdFormat;
	}

	public void setHagakiSyouhinCdFormat(String hagakiSyouhinCdFormat) {
		this.hagakiSyouhinCdFormat = hagakiSyouhinCdFormat;
	}

	public String getHagakiSyouhinCdSplit() {
		return hagakiSyouhinCdSplit;
	}

	public void setHagakiSyouhinCdSplit(String hagakiSyouhinCdSplit) {
		this.hagakiSyouhinCdSplit = hagakiSyouhinCdSplit;
	}

	public String getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}

	public String getHagakiSyouhinCd() {
		return hagakiSyouhinCd;
	}

	public void setHagakiSyouhinCd(String hagakiSyouhinCd) {
		this.hagakiSyouhinCd = hagakiSyouhinCd;
	}

	@Override
	public String toString() {
		return "OrderItemInfoInputDto [catalogId=" + catalogId
				+ ", hagakiSyouhinCd=" + hagakiSyouhinCd
				+ ", hagakiSyouhinCdFormat=" + hagakiSyouhinCdFormat
				+ ", hagakiSyouhinCdSplit=" + hagakiSyouhinCdSplit + "]";
	}

}
