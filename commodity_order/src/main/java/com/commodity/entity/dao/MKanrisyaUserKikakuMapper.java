package com.commodity.entity.dao;

import com.commodity.entity.DaoInterface;
import com.commodity.entity.dto.MKanrisyaUserKikaku;
import com.commodity.entity.dto.MKanrisyaUserKikakuExample;
import com.commodity.entity.dto.MKanrisyaUserKikakuKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MKanrisyaUserKikakuMapper extends DaoInterface {
    long countByExample(MKanrisyaUserKikakuExample example);

    int deleteByExample(MKanrisyaUserKikakuExample example);

    int deleteByPrimaryKey(MKanrisyaUserKikakuKey key);

    int insert(MKanrisyaUserKikaku record);

    int insertSelective(MKanrisyaUserKikaku record);

    List<MKanrisyaUserKikaku> selectByExample(MKanrisyaUserKikakuExample example);

    MKanrisyaUserKikaku selectByPrimaryKey(MKanrisyaUserKikakuKey key);

    int updateByExampleSelective(@Param("record") MKanrisyaUserKikaku record, @Param("example") MKanrisyaUserKikakuExample example);

    int updateByExample(@Param("record") MKanrisyaUserKikaku record, @Param("example") MKanrisyaUserKikakuExample example);

    int updateByPrimaryKeySelective(MKanrisyaUserKikaku record);

    int updateByPrimaryKey(MKanrisyaUserKikaku record);
}