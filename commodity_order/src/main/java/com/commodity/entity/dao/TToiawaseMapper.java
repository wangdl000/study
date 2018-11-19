package com.commodity.entity.dao;

import com.commodity.entity.DaoInterface;
import com.commodity.entity.dto.TToiawase;
import com.commodity.entity.dto.TToiawaseExample;
import com.commodity.entity.dto.TToiawaseKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TToiawaseMapper extends DaoInterface {
    long countByExample(TToiawaseExample example);

    int deleteByExample(TToiawaseExample example);

    int deleteByPrimaryKey(TToiawaseKey key);

    int insert(TToiawase record);

    int insertSelective(TToiawase record);

    List<TToiawase> selectByExample(TToiawaseExample example);

    TToiawase selectByPrimaryKey(TToiawaseKey key);

    int updateByExampleSelective(@Param("record") TToiawase record, @Param("example") TToiawaseExample example);

    int updateByExample(@Param("record") TToiawase record, @Param("example") TToiawaseExample example);

    int updateByPrimaryKeySelective(TToiawase record);

    int updateByPrimaryKey(TToiawase record);
}