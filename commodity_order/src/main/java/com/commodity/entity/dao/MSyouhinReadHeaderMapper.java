package com.commodity.entity.dao;

import com.commodity.entity.DaoInterface;
import com.commodity.entity.dto.MSyouhinReadHeader;
import com.commodity.entity.dto.MSyouhinReadHeaderExample;
import com.commodity.entity.dto.MSyouhinReadHeaderKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MSyouhinReadHeaderMapper extends DaoInterface {
    long countByExample(MSyouhinReadHeaderExample example);

    int deleteByExample(MSyouhinReadHeaderExample example);

    int deleteByPrimaryKey(MSyouhinReadHeaderKey key);

    int insert(MSyouhinReadHeader record);

    int insertSelective(MSyouhinReadHeader record);

    List<MSyouhinReadHeader> selectByExample(MSyouhinReadHeaderExample example);

    MSyouhinReadHeader selectByPrimaryKey(MSyouhinReadHeaderKey key);

    int updateByExampleSelective(@Param("record") MSyouhinReadHeader record, @Param("example") MSyouhinReadHeaderExample example);

    int updateByExample(@Param("record") MSyouhinReadHeader record, @Param("example") MSyouhinReadHeaderExample example);

    int updateByPrimaryKeySelective(MSyouhinReadHeader record);

    int updateByPrimaryKey(MSyouhinReadHeader record);
}