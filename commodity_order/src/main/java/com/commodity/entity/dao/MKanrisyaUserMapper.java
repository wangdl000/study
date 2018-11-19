package com.commodity.entity.dao;

import com.commodity.entity.DaoInterface;
import com.commodity.entity.dto.MKanrisyaUser;
import com.commodity.entity.dto.MKanrisyaUserExample;
import com.commodity.entity.dto.MKanrisyaUserKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MKanrisyaUserMapper extends DaoInterface {
    long countByExample(MKanrisyaUserExample example);

    int deleteByExample(MKanrisyaUserExample example);

    int deleteByPrimaryKey(MKanrisyaUserKey key);

    int insert(MKanrisyaUser record);

    int insertSelective(MKanrisyaUser record);

    List<MKanrisyaUser> selectByExample(MKanrisyaUserExample example);

    MKanrisyaUser selectByPrimaryKey(MKanrisyaUserKey key);

    int updateByExampleSelective(@Param("record") MKanrisyaUser record, @Param("example") MKanrisyaUserExample example);

    int updateByExample(@Param("record") MKanrisyaUser record, @Param("example") MKanrisyaUserExample example);

    int updateByPrimaryKeySelective(MKanrisyaUser record);

    int updateByPrimaryKey(MKanrisyaUser record);
}