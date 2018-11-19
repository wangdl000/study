package com.commodity.entity.dao;

import com.commodity.entity.DaoInterface;
import com.commodity.entity.dto.VWebKikaku;
import com.commodity.entity.dto.VWebKikakuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VWebKikakuMapper extends DaoInterface {
    long countByExample(VWebKikakuExample example);

    int deleteByExample(VWebKikakuExample example);

    int insert(VWebKikaku record);

    int insertSelective(VWebKikaku record);

    List<VWebKikaku> selectByExample(VWebKikakuExample example);

    int updateByExampleSelective(@Param("record") VWebKikaku record, @Param("example") VWebKikakuExample example);

    int updateByExample(@Param("record") VWebKikaku record, @Param("example") VWebKikakuExample example);
}