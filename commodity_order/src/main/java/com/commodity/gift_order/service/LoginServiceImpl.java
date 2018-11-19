package com.commodity.gift_order.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.commodity.entity.dao.MWebLoginMapper;
import com.commodity.entity.dto.MWebLogin;
import com.commodity.entity.dto.MWebLoginExample;
import com.commodity.gift_order.exception.BusinessException;
import com.commodity.gift_order.exception.GelSystemException;
import com.commodity.gift_order.service.dto.OrderLoginInputDto;

@Service
public class LoginServiceImpl implements LoginService {

	@Resource
	private MWebLoginMapper mWebLoginMapper;

	@Override
	public MWebLogin Login(OrderLoginInputDto inDto) throws BusinessException, GelSystemException {

		if (mWebLoginMapper == null) {
			throw new GelSystemException();
		}

//		String id = inDto.getId1() + inDto.getId2() + inDto.getId3();
		String id = inDto.getId1();

		// GEL-DOC条件作成
		MWebLoginExample example = new MWebLoginExample();
		example.createCriteria().andLoginIdEqualTo(id).andCatalogIdEqualTo(inDto.getCatalogId())
				.andPasswordEqualTo(inDto.getPassword());

		List<MWebLogin> list = mWebLoginMapper.selectByExample(example);

		if (list.size() != 1) {
			throw new BusinessException("IDまたはパスワードが正しくありません。");
		}

		MWebLogin webLogin = list.get(0);

		return webLogin;
	}

}