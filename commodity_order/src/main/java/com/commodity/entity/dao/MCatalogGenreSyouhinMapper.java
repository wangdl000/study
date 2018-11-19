package com.commodity.entity.dao;

import com.commodity.entity.DaoInterface;
import com.commodity.entity.dto.MCatalogGenreSyouhin;
import com.commodity.entity.dto.MCatalogGenreSyouhinExample;
import com.commodity.entity.dto.MCatalogGenreSyouhinKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MCatalogGenreSyouhinMapper extends DaoInterface {
    long countByExample(MCatalogGenreSyouhinExample example);

    int deleteByExample(MCatalogGenreSyouhinExample example);

    int deleteByPrimaryKey(MCatalogGenreSyouhinKey key);

    int insert(MCatalogGenreSyouhin record);

    int insertSelective(MCatalogGenreSyouhin record);

    List<MCatalogGenreSyouhin> selectByExample(MCatalogGenreSyouhinExample example);

    MCatalogGenreSyouhin selectByPrimaryKey(MCatalogGenreSyouhinKey key);

    int updateByExampleSelective(@Param("record") MCatalogGenreSyouhin record, @Param("example") MCatalogGenreSyouhinExample example);

    int updateByExample(@Param("record") MCatalogGenreSyouhin record, @Param("example") MCatalogGenreSyouhinExample example);

    int updateByPrimaryKeySelective(MCatalogGenreSyouhin record);

    int updateByPrimaryKey(MCatalogGenreSyouhin record);
}