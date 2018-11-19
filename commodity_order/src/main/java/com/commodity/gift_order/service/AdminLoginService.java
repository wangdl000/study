package com.commodity.gift_order.service;

import com.commodity.gift_order.exception.BusinessException;
import com.commodity.gift_order.exception.GelSystemException;
import com.commodity.gift_order.service.dto.AdminLoginInputDto;
import com.commodity.gift_order.service.dto.AdminLoginOutputDto;

public interface AdminLoginService {
	/**
	 * 管理者ログイン情報取得
	 *
	 * @param input AdminLoginService入力Dto
	 * @return 管理者ログイン情報
	 */
	public AdminLoginOutputDto execute(AdminLoginInputDto input) throws BusinessException, GelSystemException;
}
