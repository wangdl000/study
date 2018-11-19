package com.commodity.entity.dao;

import com.commodity.entity.DaoInterface;
import com.commodity.entity.dto.MKikaku;
import com.commodity.entity.dto.MKikakuExample;
import com.commodity.entity.dto.MKikakuKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MKikakuMapper extends DaoInterface {
    long countByExample(MKikakuExample example);

    int deleteByExample(MKikakuExample example);

    int deleteByPrimaryKey(MKikakuKey key);

    int insert(MKikaku record);

    int insertSelective(MKikaku record);

    List<MKikaku> selectByExample(MKikakuExample example);

    MKikaku selectByPrimaryKey(MKikakuKey key);

    int updateByExampleSelective(@Param("record") MKikaku record, @Param("example") MKikakuExample example);

    int updateByExample(@Param("record") MKikaku record, @Param("example") MKikakuExample example);

    int updateByPrimaryKeySelective(MKikaku record);

    int updateByPrimaryKey(MKikaku record);
}