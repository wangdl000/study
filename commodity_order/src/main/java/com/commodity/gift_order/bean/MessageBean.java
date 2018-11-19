package com.commodity.gift_order.bean;

import java.util.Date;

public class MessageBean extends BaseBean {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	// GEL-DOCカタログID
	private String catalogId;

	// GEL-DOCお知らせ番号
	private Long msgNo;

	// GEL-DOCお知らせ掲載区分
	private String msgKeisaiKbn;

	// GEL-DOC掲載期間開始日
	private Date keisaiFrom;

	// GEL-DOC掲載期間終了日
	private Date keisaiTo;

	// GEL-DOCお知らせヘッダ
	private String msgHeader;

	// GEL-DOCお知らせ内容
	private String msgNaiyou;

	public String getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}

	public Long getMsgNo() {
		return msgNo;
	}

	public void setMsgNo(Long msgNo) {
		this.msgNo = msgNo;
	}

	public String getMsgKeisaiKbn() {
		return msgKeisaiKbn;
	}

	public void setMsgKeisaiKbn(String msgKeisaiKbn) {
		this.msgKeisaiKbn = msgKeisaiKbn;
	}

	public Date getKeisaiFrom() {
		return keisaiFrom;
	}

	public void setKeisaiFrom(Date keisaiFrom) {
		this.keisaiFrom = keisaiFrom;
	}

	public Date getKeisaiTo() {
		return keisaiTo;
	}

	public void setKeisaiTo(Date keisaiTo) {
		this.keisaiTo = keisaiTo;
	}

	public String getMsgHeader() {
		return msgHeader;
	}

	public void setMsgHeader(String msgHeader) {
		this.msgHeader = msgHeader;
	}

	public String getMsgNaiyou() {
		return msgNaiyou;
	}

	public void setMsgNaiyou(String msgNaiyou) {
		this.msgNaiyou = msgNaiyou;
	}

	@Override
	public String toString() {
		return "MessageBean [catalogId=" + catalogId + ", msgNo=" + msgNo
				+ ", msgKeisaiKbn=" + msgKeisaiKbn + ", keisaiFrom="
				+ keisaiFrom + ", keisaiTo=" + keisaiTo + ", msgHeader="
				+ msgHeader + ", msgNaiyou=" + msgNaiyou + "]";
	}



}
