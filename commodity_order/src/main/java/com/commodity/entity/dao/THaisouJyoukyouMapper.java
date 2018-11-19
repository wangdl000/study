package com.commodity.entity.dao;

import com.commodity.entity.DaoInterface;
import com.commodity.entity.dto.THaisouJyoukyou;
import com.commodity.entity.dto.THaisouJyoukyouExample;
import com.commodity.entity.dto.THaisouJyoukyouKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface THaisouJyoukyouMapper extends DaoInterface {
    long countByExample(THaisouJyoukyouExample example);

    int deleteByExample(THaisouJyoukyouExample example);

    int deleteByPrimaryKey(THaisouJyoukyouKey key);

    int insert(THaisouJyoukyou record);

    int insertSelective(THaisouJyoukyou record);

    List<THaisouJyoukyou> selectByExample(THaisouJyoukyouExample example);

    THaisouJyoukyou selectByPrimaryKey(THaisouJyoukyouKey key);

    int updateByExampleSelective(@Param("record") THaisouJyoukyou record, @Param("example") THaisouJyoukyouExample example);

    int updateByExample(@Param("record") THaisouJyoukyou record, @Param("example") THaisouJyoukyouExample example);

    int updateByPrimaryKeySelective(THaisouJyoukyou record);

    int updateByPrimaryKey(THaisouJyoukyou record);
}