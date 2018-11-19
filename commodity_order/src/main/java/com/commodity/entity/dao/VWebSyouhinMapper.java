package com.commodity.entity.dao;

import com.commodity.entity.DaoInterface;
import com.commodity.entity.dto.VWebSyouhin;
import com.commodity.entity.dto.VWebSyouhinExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VWebSyouhinMapper extends DaoInterface {
    long countByExample(VWebSyouhinExample example);

    int deleteByExample(VWebSyouhinExample example);

    int insert(VWebSyouhin record);

    int insertSelective(VWebSyouhin record);

    List<VWebSyouhin> selectByExample(VWebSyouhinExample example);

    int updateByExampleSelective(@Param("record") VWebSyouhin record, @Param("example") VWebSyouhinExample example);

    int updateByExample(@Param("record") VWebSyouhin record, @Param("example") VWebSyouhinExample example);
}