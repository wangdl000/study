package com.commodity.entity.dao;

import com.commodity.entity.DaoInterface;
import com.commodity.entity.dto.MCatalogGenre;
import com.commodity.entity.dto.MCatalogGenreExample;
import com.commodity.entity.dto.MCatalogGenreKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MCatalogGenreMapper extends DaoInterface {
    long countByExample(MCatalogGenreExample example);

    int deleteByExample(MCatalogGenreExample example);

    int deleteByPrimaryKey(MCatalogGenreKey key);

    int insert(MCatalogGenre record);

    int insertSelective(MCatalogGenre record);

    List<MCatalogGenre> selectByExample(MCatalogGenreExample example);

    MCatalogGenre selectByPrimaryKey(MCatalogGenreKey key);

    int updateByExampleSelective(@Param("record") MCatalogGenre record, @Param("example") MCatalogGenreExample example);

    int updateByExample(@Param("record") MCatalogGenre record, @Param("example") MCatalogGenreExample example);

    int updateByPrimaryKeySelective(MCatalogGenre record);

    int updateByPrimaryKey(MCatalogGenre record);
}