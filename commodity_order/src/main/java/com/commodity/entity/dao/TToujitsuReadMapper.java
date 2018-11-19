package com.commodity.entity.dao;

import com.commodity.entity.DaoInterface;
import com.commodity.entity.dto.TToujitsuRead;
import com.commodity.entity.dto.TToujitsuReadExample;
import com.commodity.entity.dto.TToujitsuReadKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TToujitsuReadMapper extends DaoInterface {
    long countByExample(TToujitsuReadExample example);

    int deleteByExample(TToujitsuReadExample example);

    int deleteByPrimaryKey(TToujitsuReadKey key);

    int insert(TToujitsuRead record);

    int insertSelective(TToujitsuRead record);

    List<TToujitsuRead> selectByExample(TToujitsuReadExample example);

    TToujitsuRead selectByPrimaryKey(TToujitsuReadKey key);

    int updateByExampleSelective(@Param("record") TToujitsuRead record, @Param("example") TToujitsuReadExample example);

    int updateByExample(@Param("record") TToujitsuRead record, @Param("example") TToujitsuReadExample example);

    int updateByPrimaryKeySelective(TToujitsuRead record);

    int updateByPrimaryKey(TToujitsuRead record);
}