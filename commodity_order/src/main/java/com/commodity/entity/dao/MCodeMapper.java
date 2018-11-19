package com.commodity.entity.dao;

import com.commodity.entity.DaoInterface;
import com.commodity.entity.dto.MCode;
import com.commodity.entity.dto.MCodeExample;
import com.commodity.entity.dto.MCodeKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MCodeMapper extends DaoInterface {
    long countByExample(MCodeExample example);

    int deleteByExample(MCodeExample example);

    int deleteByPrimaryKey(MCodeKey key);

    int insert(MCode record);

    int insertSelective(MCode record);

    List<MCode> selectByExample(MCodeExample example);

    MCode selectByPrimaryKey(MCodeKey key);

    int updateByExampleSelective(@Param("record") MCode record, @Param("example") MCodeExample example);

    int updateByExample(@Param("record") MCode record, @Param("example") MCodeExample example);

    int updateByPrimaryKeySelective(MCode record);

    int updateByPrimaryKey(MCode record);
}