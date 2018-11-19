package com.commodity.gift_order.bean.session;

/**
 * <B>AdminLoginSessionBean</B><BR>
 * <P>
 * AdminLoginのセッションBean
 * </P>
 * <BR>
 *
 * @date 2010.12.08
 * @author DTT gao-jp
 */
public class AdminLoginSessionBean extends BaseSessionBean implements LoginSessionBeanInterface {

	/**
	 *
	 */
	private static final long serialVersionUID = -4882198679554417896L;
	// GEL-DOC管理者ユーザID
	private String kanriUserId;
	// GEL-DOCSVフラグ
	private String svFlg;
	// GEL-DOC管理者ユーザ名
	private String kanriUserNm;
	// GEL-DOC企画コード(コース)
	private String kikakuCd;

	@Override
	public String toString() {
		return "AdminLoginSessionBean [kanriUserId=" + kanriUserId + ", kanriUserNm=" + kanriUserNm + ", kikakuCd="
				+ kikakuCd + ", svFlg=" + svFlg + "]";
	}

	/**
	 * 管理者ユーザIDを取得する。
	 *
	 * @return the kanriUserId
	 */
	public String getKanriUserId() {
		return kanriUserId;
	}

	/**
	 * 管理者ユーザIDを設定する。
	 *
	 * @param kanriUserId the kanriUserId to set
	 */
	public void setKanriUserId(String kanriUserId) {
		this.kanriUserId = kanriUserId;
	}

	/**
	 * SVフラグを取得する。
	 *
	 * @return the svFlg
	 */
	public String getSvFlg() {
		return svFlg;
	}

	/**
	 * SVフラグを設定する。
	 *
	 * @param svFlg the svFlg to set
	 */
	public void setSvFlg(String svFlg) {
		this.svFlg = svFlg;
	}

	/**
	 * 管理者ユーザ名を取得する。
	 *
	 * @return the kanriUserNm
	 */
	public String getKanriUserNm() {
		return kanriUserNm;
	}

	/**
	 * 管理者ユーザ名を設定する。
	 *
	 * @param kanriUserNm the kanriUserNm to set
	 */
	public void setKanriUserNm(String kanriUserNm) {
		this.kanriUserNm = kanriUserNm;
	}

	/**
	 * 企画コード(コース)を取得する。
	 *
	 * @return the kikakuCd
	 */
	public String getKikakuCd() {
		return kikakuCd;
	}

	/**
	 * 企画コード(コース)を設定する。
	 *
	 * @param kikakuCd the kikakuCd to set
	 */
	public void setKikakuCd(String kikakuCd) {
		this.kikakuCd = kikakuCd;
	}

	public String getUserId() {
		return this.getKanriUserId();
	}

	public String getLoginInfoStr() {
		return this.toString();
	}

}
