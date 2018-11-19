package com.commodity.gift_order.service.dto;

public class OrderLoginInputDto extends BaseInputDto {

	String id1;

	String id2;

	String id3;

	String password;

	String catalogId;

	public String getId1() {
		return id1;
	}

	public void setId1(String id1) {
		this.id1 = id1;
	}

	public String getId2() {
		return id2;
	}

	public void setId2(String id2) {
		this.id2 = id2;
	}

	public String getId3() {
		return id3;
	}

	public void setId3(String id3) {
		this.id3 = id3;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}

	@Override
	public String toString() {
		return "OrderLoginInputDto [id1=" + id1 + ", id2=" + id2 + ", id3="
				+ id3 + ", password=" + password + ", catalogId=" + catalogId
				+ "]";
	}

}
