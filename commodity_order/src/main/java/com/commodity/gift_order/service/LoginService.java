package com.commodity.gift_order.service;

import com.commodity.entity.dto.MWebLogin;
import com.commodity.gift_order.exception.BusinessException;
import com.commodity.gift_order.exception.GelSystemException;
import com.commodity.gift_order.service.dto.OrderLoginInputDto;

public interface LoginService {

	public MWebLogin Login(OrderLoginInputDto inDto) throws BusinessException, GelSystemException;

}