package com.commodity.entity.dao;

import com.commodity.entity.DaoInterface;
import com.commodity.entity.dto.MReadJyogai;
import com.commodity.entity.dto.MReadJyogaiExample;
import com.commodity.entity.dto.MReadJyogaiKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MReadJyogaiMapper extends DaoInterface {
    long countByExample(MReadJyogaiExample example);

    int deleteByExample(MReadJyogaiExample example);

    int deleteByPrimaryKey(MReadJyogaiKey key);

    int insert(MReadJyogai record);

    int insertSelective(MReadJyogai record);

    List<MReadJyogai> selectByExample(MReadJyogaiExample example);

    MReadJyogai selectByPrimaryKey(MReadJyogaiKey key);

    int updateByExampleSelective(@Param("record") MReadJyogai record, @Param("example") MReadJyogaiExample example);

    int updateByExample(@Param("record") MReadJyogai record, @Param("example") MReadJyogaiExample example);

    int updateByPrimaryKeySelective(MReadJyogai record);

    int updateByPrimaryKey(MReadJyogai record);
}