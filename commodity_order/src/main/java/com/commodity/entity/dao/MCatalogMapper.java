package com.commodity.entity.dao;

import com.commodity.entity.DaoInterface;
import com.commodity.entity.dto.MCatalog;
import com.commodity.entity.dto.MCatalogExample;
import com.commodity.entity.dto.MCatalogKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MCatalogMapper extends DaoInterface {
    long countByExample(MCatalogExample example);

    int deleteByExample(MCatalogExample example);

    int deleteByPrimaryKey(MCatalogKey key);

    int insert(MCatalog record);

    int insertSelective(MCatalog record);

    List<MCatalog> selectByExample(MCatalogExample example);

    MCatalog selectByPrimaryKey(MCatalogKey key);

    int updateByExampleSelective(@Param("record") MCatalog record, @Param("example") MCatalogExample example);

    int updateByExample(@Param("record") MCatalog record, @Param("example") MCatalogExample example);

    int updateByPrimaryKeySelective(MCatalog record);

    int updateByPrimaryKey(MCatalog record);
}