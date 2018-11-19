package com.commodity.entity.custom.dao;

import java.util.List;

import com.commodity.entity.custom.dto.BaseDict;

public interface DictMapper {

	public List<BaseDict> findDictByCode(String code);

}
