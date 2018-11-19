package com.commodity.entity.dao;

import com.commodity.entity.DaoInterface;
import com.commodity.entity.dto.MMsg;
import com.commodity.entity.dto.MMsgExample;
import com.commodity.entity.dto.MMsgKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MMsgMapper extends DaoInterface {
    long countByExample(MMsgExample example);

    int deleteByExample(MMsgExample example);

    int deleteByPrimaryKey(MMsgKey key);

    int insert(MMsg record);

    int insertSelective(MMsg record);

    List<MMsg> selectByExample(MMsgExample example);

    MMsg selectByPrimaryKey(MMsgKey key);

    int updateByExampleSelective(@Param("record") MMsg record, @Param("example") MMsgExample example);

    int updateByExample(@Param("record") MMsg record, @Param("example") MMsgExample example);

    int updateByPrimaryKeySelective(MMsg record);

    int updateByPrimaryKey(MMsg record);
}