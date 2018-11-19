package com.commodity.entity.dao;

import com.commodity.entity.DaoInterface;
import com.commodity.entity.dto.TWebJuchuMeisai;
import com.commodity.entity.dto.TWebJuchuMeisaiExample;
import com.commodity.entity.dto.TWebJuchuMeisaiKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TWebJuchuMeisaiMapper extends DaoInterface {
    long countByExample(TWebJuchuMeisaiExample example);

    int deleteByExample(TWebJuchuMeisaiExample example);

    int deleteByPrimaryKey(TWebJuchuMeisaiKey key);

    int insert(TWebJuchuMeisai record);

    int insertSelective(TWebJuchuMeisai record);

    List<TWebJuchuMeisai> selectByExample(TWebJuchuMeisaiExample example);

    TWebJuchuMeisai selectByPrimaryKey(TWebJuchuMeisaiKey key);

    int updateByExampleSelective(@Param("record") TWebJuchuMeisai record, @Param("example") TWebJuchuMeisaiExample example);

    int updateByExample(@Param("record") TWebJuchuMeisai record, @Param("example") TWebJuchuMeisaiExample example);

    int updateByPrimaryKeySelective(TWebJuchuMeisai record);

    int updateByPrimaryKey(TWebJuchuMeisai record);
}