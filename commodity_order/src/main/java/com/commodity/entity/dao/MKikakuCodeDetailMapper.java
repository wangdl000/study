package com.commodity.entity.dao;

import com.commodity.entity.DaoInterface;
import com.commodity.entity.dto.MKikakuCodeDetail;
import com.commodity.entity.dto.MKikakuCodeDetailExample;
import com.commodity.entity.dto.MKikakuCodeDetailKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MKikakuCodeDetailMapper extends DaoInterface {
    long countByExample(MKikakuCodeDetailExample example);

    int deleteByExample(MKikakuCodeDetailExample example);

    int deleteByPrimaryKey(MKikakuCodeDetailKey key);

    int insert(MKikakuCodeDetail record);

    int insertSelective(MKikakuCodeDetail record);

    List<MKikakuCodeDetail> selectByExample(MKikakuCodeDetailExample example);

    MKikakuCodeDetail selectByPrimaryKey(MKikakuCodeDetailKey key);

    int updateByExampleSelective(@Param("record") MKikakuCodeDetail record, @Param("example") MKikakuCodeDetailExample example);

    int updateByExample(@Param("record") MKikakuCodeDetail record, @Param("example") MKikakuCodeDetailExample example);

    int updateByPrimaryKeySelective(MKikakuCodeDetail record);

    int updateByPrimaryKey(MKikakuCodeDetail record);
}