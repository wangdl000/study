package com.commodity.gift_order.service.dto;

/**
 * <B>AdminLoginInputDto</B><BR>
 * <P>
 * AdminLoginService入力Dto
 * </P>
 * <BR>
 *
 * @date 2018/08/26
 * @author ou
 */
public class AdminLoginInputDto extends BaseInputDto {

	/** 管理者ユーザID */
	private String kanriUserId;
	/** 管理者パスワード */
	private String kanriUserPassword;
	/** 企画コード(コース) */
	private String kikakuCd;

	@Override
	public String toString() {
		return "AdminLoginInputDto [kanriUserId=" + kanriUserId + ", kanriUserPassword=" + kanriUserPassword
				+ ", kikakuCd=" + kikakuCd + "]";
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
	 * 管理者パスワードを取得する。
	 *
	 * @return the kanriUserPassword
	 */
	public String getKanriUserPassword() {
		return kanriUserPassword;
	}

	/**
	 * 管理者パスワードを設定する。
	 *
	 * @param kanriUserPassword the kanriUserPassword to set
	 */
	public void setKanriUserPassword(String kanriUserPassword) {
		this.kanriUserPassword = kanriUserPassword;
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

}
