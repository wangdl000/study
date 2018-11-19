package com.commodity.gift_order.bean;

import java.util.Date;

public class MsgListBean extends BaseBean {

	/**
	 *
	 */
	private static final long serialVersionUID = -5013137550435831354L;

	/** カタログID */
	String catalogId;

	/** カタログ名称 */
	String catalogName;

	/** お知らせ番号 */
	Integer msgNo;

	/** お知らせ掲載区分 */
	String msgKeisaiKbn;
	
	/** お知らせ掲載区分名称 */
	String msgKeisaiName;

	/** 掲載期間開始日 */
	Date keisaiFrom;

	/** 掲載期間終了日 */
	Date keisaiTo;

	/** お知らせヘッダ（タイトル） */
	String msgHeader;

	/** お知らせ内容 */
	String msgNaiyou;

	/** 更新年月日 */
	Date koushinBi;

	/**
	 * @return catalogId
	 */
	public String getCatalogId() {
		return catalogId;
	}

	/**
	 * @param catalogId
	 *            セットする catalogId
	 */
	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}

	/**
	 * @return catalogName
	 */
	public String getCatalogName() {
		return catalogName;
	}

	/**
	 * @param catalogName
	 *            セットする catalogName
	 */
	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	/**
	 * @return msgNo
	 */
	public Integer getMsgNo() {
		return msgNo;
	}

	/**
	 * @param msgNo
	 *            セットする msgNo
	 */
	public void setMsgNo(Integer msgNo) {
		this.msgNo = msgNo;
	}

	/**
	 * @return msgKeisaiKbn
	 */
	public String getMsgKeisaiKbn() {
		return msgKeisaiKbn;
	}

	/**
	 * @param msgKeisaiKbn セットする msgKeisaiKbn
	 */
	public void setMsgKeisaiKbn(String msgKeisaiKbn) {
		this.msgKeisaiKbn = msgKeisaiKbn;
	}

	/**
	 * @return msgKeisaiName
	 */
	public String getMsgKeisaiName() {
		return msgKeisaiName;
	}

	/**
	 * @param msgKeisaiName
	 *            セットする msgKeisaiName
	 */
	public void setMsgKeisaiName(String msgKeisaiName) {
		this.msgKeisaiName = msgKeisaiName;
	}

	/**
	 * @return keisaiFrom
	 */
	public Date getKeisaiFrom() {
		return keisaiFrom;
	}

	/**
	 * @param keisaiFrom
	 *            セットする keisaiFrom
	 */
	public void setKeisaiFrom(Date keisaiFrom) {
		this.keisaiFrom = keisaiFrom;
	}

	/**
	 * @return keisaiTo
	 */
	public Date getKeisaiTo() {
		return keisaiTo;
	}

	/**
	 * @param keisaiTo
	 *            セットする keisaiTo
	 */
	public void setKeisaiTo(Date keisaiTo) {
		this.keisaiTo = keisaiTo;
	}

	/**
	 * @return msgHeader
	 */
	public String getMsgHeader() {
		return msgHeader;
	}

	/**
	 * @param msgHeader
	 *            セットする msgHeader
	 */
	public void setMsgHeader(String msgHeader) {
		this.msgHeader = msgHeader;
	}

	/**
	 * @return msgNaiyou
	 */
	public String getMsgNaiyou() {
		return msgNaiyou;
	}

	/**
	 * @param msgNaiyou
	 *            セットする msgNaiyou
	 */
	public void setMsgNaiyou(String msgNaiyou) {
		this.msgNaiyou = msgNaiyou;
	}

	/**
	 * @return koushinBi
	 */
	public Date getKoushinBi() {
		return koushinBi;
	}

	/**
	 * @param koushinBi
	 *            セットする koushinBi
	 */
	public void setKoushinBi(Date koushinBi) {
		this.koushinBi = koushinBi;
	}

	/* (非 Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MsgListBean [catalogId=" + catalogId + ", catalogName="
				+ catalogName + ", msgNo=" + msgNo + ", msgKeisaiKbn="
				+ msgKeisaiKbn + ", msgKeisaiName=" + msgKeisaiName
				+ ", keisaiFrom=" + keisaiFrom + ", keisaiTo=" + keisaiTo
				+ ", msgHeader=" + msgHeader + ", msgNaiyou=" + msgNaiyou
				+ ", koushinBi=" + koushinBi + "]";
	}

}
