package com.commodity.entity.dao;

import com.commodity.entity.DaoInterface;
import com.commodity.entity.dto.TWebJuchu;
import com.commodity.entity.dto.TWebJuchuExample;
import com.commodity.entity.dto.TWebJuchuKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TWebJuchuMapper extends DaoInterface {
    long countByExample(TWebJuchuExample example);

    int deleteByExample(TWebJuchuExample example);

    int deleteByPrimaryKey(TWebJuchuKey key);

    int insert(TWebJuchu record);

    int insertSelective(TWebJuchu record);

    List<TWebJuchu> selectByExample(TWebJuchuExample example);

    TWebJuchu selectByPrimaryKey(TWebJuchuKey key);

    int updateByExampleSelective(@Param("record") TWebJuchu record, @Param("example") TWebJuchuExample example);

    int updateByExample(@Param("record") TWebJuchu record, @Param("example") TWebJuchuExample example);

    int updateByPrimaryKeySelective(TWebJuchu record);

    int updateByPrimaryKey(TWebJuchu record);
}