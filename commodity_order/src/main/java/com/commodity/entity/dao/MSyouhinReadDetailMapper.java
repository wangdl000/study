package com.commodity.entity.dao;

import com.commodity.entity.DaoInterface;
import com.commodity.entity.dto.MSyouhinReadDetail;
import com.commodity.entity.dto.MSyouhinReadDetailExample;
import com.commodity.entity.dto.MSyouhinReadDetailKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MSyouhinReadDetailMapper extends DaoInterface {
    long countByExample(MSyouhinReadDetailExample example);

    int deleteByExample(MSyouhinReadDetailExample example);

    int deleteByPrimaryKey(MSyouhinReadDetailKey key);

    int insert(MSyouhinReadDetail record);

    int insertSelective(MSyouhinReadDetail record);

    List<MSyouhinReadDetail> selectByExample(MSyouhinReadDetailExample example);

    MSyouhinReadDetail selectByPrimaryKey(MSyouhinReadDetailKey key);

    int updateByExampleSelective(@Param("record") MSyouhinReadDetail record, @Param("example") MSyouhinReadDetailExample example);

    int updateByExample(@Param("record") MSyouhinReadDetail record, @Param("example") MSyouhinReadDetailExample example);

    int updateByPrimaryKeySelective(MSyouhinReadDetail record);

    int updateByPrimaryKey(MSyouhinReadDetail record);
}