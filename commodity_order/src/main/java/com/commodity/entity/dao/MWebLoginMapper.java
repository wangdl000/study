package com.commodity.entity.dao;

import com.commodity.entity.DaoInterface;
import com.commodity.entity.dto.MWebLogin;
import com.commodity.entity.dto.MWebLoginExample;
import com.commodity.entity.dto.MWebLoginKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MWebLoginMapper extends DaoInterface {
    long countByExample(MWebLoginExample example);

    int deleteByExample(MWebLoginExample example);

    int deleteByPrimaryKey(MWebLoginKey key);

    int insert(MWebLogin record);

    int insertSelective(MWebLogin record);

    List<MWebLogin> selectByExample(MWebLoginExample example);

    MWebLogin selectByPrimaryKey(MWebLoginKey key);

    int updateByExampleSelective(@Param("record") MWebLogin record, @Param("example") MWebLoginExample example);

    int updateByExample(@Param("record") MWebLogin record, @Param("example") MWebLoginExample example);

    int updateByPrimaryKeySelective(MWebLogin record);

    int updateByPrimaryKey(MWebLogin record);
}