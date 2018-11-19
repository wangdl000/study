package com.commodity.entity.dao;

import com.commodity.entity.DaoInterface;
import com.commodity.entity.dto.MKikakuCode;
import com.commodity.entity.dto.MKikakuCodeExample;
import com.commodity.entity.dto.MKikakuCodeKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MKikakuCodeMapper extends DaoInterface {
    long countByExample(MKikakuCodeExample example);

    int deleteByExample(MKikakuCodeExample example);

    int deleteByPrimaryKey(MKikakuCodeKey key);

    int insert(MKikakuCode record);

    int insertSelective(MKikakuCode record);

    List<MKikakuCode> selectByExample(MKikakuCodeExample example);

    MKikakuCode selectByPrimaryKey(MKikakuCodeKey key);

    int updateByExampleSelective(@Param("record") MKikakuCode record, @Param("example") MKikakuCodeExample example);

    int updateByExample(@Param("record") MKikakuCode record, @Param("example") MKikakuCodeExample example);

    int updateByPrimaryKeySelective(MKikakuCode record);

    int updateByPrimaryKey(MKikakuCode record);
}