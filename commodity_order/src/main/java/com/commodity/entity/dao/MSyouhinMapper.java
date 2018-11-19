package com.commodity.entity.dao;

import com.commodity.entity.DaoInterface;
import com.commodity.entity.dto.MSyouhin;
import com.commodity.entity.dto.MSyouhinExample;
import com.commodity.entity.dto.MSyouhinKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MSyouhinMapper extends DaoInterface {
    long countByExample(MSyouhinExample example);

    int deleteByExample(MSyouhinExample example);

    int deleteByPrimaryKey(MSyouhinKey key);

    int insert(MSyouhin record);

    int insertSelective(MSyouhin record);

    List<MSyouhin> selectByExample(MSyouhinExample example);

    MSyouhin selectByPrimaryKey(MSyouhinKey key);

    int updateByExampleSelective(@Param("record") MSyouhin record, @Param("example") MSyouhinExample example);

    int updateByExample(@Param("record") MSyouhin record, @Param("example") MSyouhinExample example);

    int updateByPrimaryKeySelective(MSyouhin record);

    int updateByPrimaryKey(MSyouhin record);
}