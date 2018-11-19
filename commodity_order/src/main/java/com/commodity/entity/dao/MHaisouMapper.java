package com.commodity.entity.dao;

import com.commodity.entity.DaoInterface;
import com.commodity.entity.dto.MHaisou;
import com.commodity.entity.dto.MHaisouExample;
import com.commodity.entity.dto.MHaisouKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MHaisouMapper extends DaoInterface {
    long countByExample(MHaisouExample example);

    int deleteByExample(MHaisouExample example);

    int deleteByPrimaryKey(MHaisouKey key);

    int insert(MHaisou record);

    int insertSelective(MHaisou record);

    List<MHaisou> selectByExample(MHaisouExample example);

    MHaisou selectByPrimaryKey(MHaisouKey key);

    int updateByExampleSelective(@Param("record") MHaisou record, @Param("example") MHaisouExample example);

    int updateByExample(@Param("record") MHaisou record, @Param("example") MHaisouExample example);

    int updateByPrimaryKeySelective(MHaisou record);

    int updateByPrimaryKey(MHaisou record);
}