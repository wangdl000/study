package com.commodity.entity.dao;

import com.commodity.entity.DaoInterface;
import com.commodity.entity.dto.MWebKikaku;
import com.commodity.entity.dto.MWebKikakuExample;
import com.commodity.entity.dto.MWebKikakuKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MWebKikakuMapper extends DaoInterface {
    long countByExample(MWebKikakuExample example);

    int deleteByExample(MWebKikakuExample example);

    int deleteByPrimaryKey(MWebKikakuKey key);

    int insert(MWebKikaku record);

    int insertSelective(MWebKikaku record);

    List<MWebKikaku> selectByExample(MWebKikakuExample example);

    MWebKikaku selectByPrimaryKey(MWebKikakuKey key);

    int updateByExampleSelective(@Param("record") MWebKikaku record, @Param("example") MWebKikakuExample example);

    int updateByExample(@Param("record") MWebKikaku record, @Param("example") MWebKikakuExample example);

    int updateByPrimaryKeySelective(MWebKikaku record);

    int updateByPrimaryKey(MWebKikaku record);
}