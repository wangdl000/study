package com.commodity.entity.dao;

import com.commodity.entity.DaoInterface;
import com.commodity.entity.dto.MCatalogSyouhin;
import com.commodity.entity.dto.MCatalogSyouhinExample;
import com.commodity.entity.dto.MCatalogSyouhinKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MCatalogSyouhinMapper extends DaoInterface {
    long countByExample(MCatalogSyouhinExample example);

    int deleteByExample(MCatalogSyouhinExample example);

    int deleteByPrimaryKey(MCatalogSyouhinKey key);

    int insert(MCatalogSyouhin record);

    int insertSelective(MCatalogSyouhin record);

    List<MCatalogSyouhin> selectByExample(MCatalogSyouhinExample example);

    MCatalogSyouhin selectByPrimaryKey(MCatalogSyouhinKey key);

    int updateByExampleSelective(@Param("record") MCatalogSyouhin record, @Param("example") MCatalogSyouhinExample example);

    int updateByExample(@Param("record") MCatalogSyouhin record, @Param("example") MCatalogSyouhinExample example);

    int updateByPrimaryKeySelective(MCatalogSyouhin record);

    int updateByPrimaryKey(MCatalogSyouhin record);
}