package com.commodity.entity.dao;

import com.commodity.entity.DaoInterface;
import com.commodity.entity.dto.MWebSyouhin;
import com.commodity.entity.dto.MWebSyouhinExample;
import com.commodity.entity.dto.MWebSyouhinKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MWebSyouhinMapper extends DaoInterface {
    long countByExample(MWebSyouhinExample example);

    int deleteByExample(MWebSyouhinExample example);

    int deleteByPrimaryKey(MWebSyouhinKey key);

    int insert(MWebSyouhin record);

    int insertSelective(MWebSyouhin record);

    List<MWebSyouhin> selectByExample(MWebSyouhinExample example);

    MWebSyouhin selectByPrimaryKey(MWebSyouhinKey key);

    int updateByExampleSelective(@Param("record") MWebSyouhin record, @Param("example") MWebSyouhinExample example);

    int updateByExample(@Param("record") MWebSyouhin record, @Param("example") MWebSyouhinExample example);

    int updateByPrimaryKeySelective(MWebSyouhin record);

    int updateByPrimaryKey(MWebSyouhin record);
}