package com.commodity.entity.dao;

import com.commodity.entity.DaoInterface;
import com.commodity.entity.dto.MReadMaster;
import com.commodity.entity.dto.MReadMasterExample;
import com.commodity.entity.dto.MReadMasterKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MReadMasterMapper extends DaoInterface {
    long countByExample(MReadMasterExample example);

    int deleteByExample(MReadMasterExample example);

    int deleteByPrimaryKey(MReadMasterKey key);

    int insert(MReadMaster record);

    int insertSelective(MReadMaster record);

    List<MReadMaster> selectByExample(MReadMasterExample example);

    MReadMaster selectByPrimaryKey(MReadMasterKey key);

    int updateByExampleSelective(@Param("record") MReadMaster record, @Param("example") MReadMasterExample example);

    int updateByExample(@Param("record") MReadMaster record, @Param("example") MReadMasterExample example);

    int updateByPrimaryKeySelective(MReadMaster record);

    int updateByPrimaryKey(MReadMaster record);
}