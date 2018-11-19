package com.commodity.gift_order.service.dto;

import com.commodity.gift_order.bean.session.AdminLoginSessionBean;

/**
 * <B>AdminLoginOutputDto</B><BR>
 * <P>
 * AdminLoginService出力Dto
 * </P>
 * <BR>
 *
 * @date 2018/08/26
 * @author ou
 */
public class AdminLoginOutputDto extends BaseOutputDto {

	/** AdminLoginSessionBeanのオブジェクト */
	private AdminLoginSessionBean loginBean;

	@Override
	public String toString() {
		return "AdminLoginOutputDto [loginBean=" + loginBean + "]";
	}

	/**
	 * AdminLoginSessionBeanのオブジェクトを取得する。
	 *
	 * @return the loginBean
	 */
	public AdminLoginSessionBean getLoginBean() {
		return loginBean;
	}

	/**
	 * AdminLoginSessionBeanのオブジェクトを設定する。
	 *
	 * @param loginBean the loginBean to set
	 */
	public void setLoginBean(AdminLoginSessionBean loginBean) {
		this.loginBean = loginBean;
	}

}
