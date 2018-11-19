package com.commodity.gift_order.bean.session;

public class LoginSessionBean extends BaseSessionBean implements LoginSessionBeanInterface {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	// ログインID
	private String id;

	// 企画コード
	private String kikakuCd;

	// カタログ
	private String catalogId;

	// 問合せ番号
	private String toiawaseNo;

	// 表示用問合せ番号
	private String viewToiawaseNo;

	// TODO 買えない条件をDBのまま入れるか、購入済みフラグで入れる。

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKikakuCd() {
		return kikakuCd;
	}

	public void setKikakuCd(String kikakuCd) {
		this.kikakuCd = kikakuCd;
	}

	public String getToiawaseNo() {
		return toiawaseNo;
	}

	public void setToiawaseNo(String toiawaseNo) {
		this.toiawaseNo = toiawaseNo;
	}

	public String getViewToiawaseNo() {
		return viewToiawaseNo;
	}

	public void setViewToiawaseNo(String viewToiawaseNo) {
		this.viewToiawaseNo = viewToiawaseNo;
	}

	public String getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}

	@Override
	public String toString() {
		return "LoginSessionBean [id=" + id + ", kikakuCd=" + kikakuCd + ", catalogId=" + catalogId + ", toiawaseNo="
				+ toiawaseNo + ", viewToiawaseNo=" + viewToiawaseNo + "]";
	}

	public String getUserId() {
		return this.toiawaseNo;
	}

	public String getLoginInfoStr() {
		return this.toString();
	}

}
