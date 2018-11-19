package com.commodity.gift_order.controller.model;

import java.util.Map;

import javax.validation.constraints.NotNull;

/**
 * <B>AdminLoginModel</B><BR>
 * <P>
 * AdminLoginAction入力モデル
 * </P>
 * <BR>
 *
 * @date 2018.08.15
 * @author ou
 */
public class AdminLoginModel {

	/** 管理者ユーザID */
	@NotNull(message = "{exception.webadmin.business.msgId101}")
	private String kanriUserId;
	/** 管理者パスワード */
	@NotNull(message = "{exception.webadmin.business.msgId101}")
	private String kanriUserPassword;
	/** 企画コード(コース) */
	private String kikakuCd;
	/** 企画マップ */
	Map<String, String> kikakuMap;

	/**
	 * @return the kanriUserId
	 */
	public String getKanriUserId() {
		return kanriUserId;
	}

	/**
	 * @param kanriUserId the kanriUserId to set
	 */
	public void setKanriUserId(String kanriUserId) {
		this.kanriUserId = kanriUserId;
	}

	/**
	 * @return the kanriUserPassword
	 */
	public String getKanriUserPassword() {
		return kanriUserPassword;
	}

	/**
	 * @param kanriUserPassword the kanriUserPassword to set
	 */
	public void setKanriUserPassword(String kanriUserPassword) {
		this.kanriUserPassword = kanriUserPassword;
	}

	/**
	 * @return the kikakuCd
	 */
	public String getKikakuCd() {
		return kikakuCd;
	}

	/**
	 * @param kikakuCd the kikakuCd to set
	 */
	public void setKikakuCd(String kikakuCd) {
		this.kikakuCd = kikakuCd;
	}

	/**
	 * @return the kikakuMap
	 */
	public Map<String, String> getKikakuMap() {
		return kikakuMap;
	}

	/**
	 * @param kikakuMap the kikakuMap to set
	 */
	public void setKikakuMap(Map<String, String> kikakuMap) {
		this.kikakuMap = kikakuMap;
	}

}
