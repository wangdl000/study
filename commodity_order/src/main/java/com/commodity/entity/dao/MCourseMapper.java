package com.commodity.entity.dao;

import com.commodity.entity.DaoInterface;
import com.commodity.entity.dto.MCourse;
import com.commodity.entity.dto.MCourseExample;
import com.commodity.entity.dto.MCourseKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MCourseMapper extends DaoInterface {
    long countByExample(MCourseExample example);

    int deleteByExample(MCourseExample example);

    int deleteByPrimaryKey(MCourseKey key);

    int insert(MCourse record);

    int insertSelective(MCourse record);

    List<MCourse> selectByExample(MCourseExample example);

    MCourse selectByPrimaryKey(MCourseKey key);

    int updateByExampleSelective(@Param("record") MCourse record, @Param("example") MCourseExample example);

    int updateByExample(@Param("record") MCourse record, @Param("example") MCourseExample example);

    int updateByPrimaryKeySelective(MCourse record);

    int updateByPrimaryKey(MCourse record);
}