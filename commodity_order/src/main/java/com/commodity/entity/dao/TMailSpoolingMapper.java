package com.commodity.entity.dao;

import com.commodity.entity.DaoInterface;
import com.commodity.entity.dto.TMailSpooling;
import com.commodity.entity.dto.TMailSpoolingExample;
import com.commodity.entity.dto.TMailSpoolingKey;
import com.commodity.entity.dto.TMailSpoolingWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMailSpoolingMapper extends DaoInterface {
    long countByExample(TMailSpoolingExample example);

    int deleteByExample(TMailSpoolingExample example);

    int deleteByPrimaryKey(TMailSpoolingKey key);

    int insert(TMailSpoolingWithBLOBs record);

    int insertSelective(TMailSpoolingWithBLOBs record);

    List<TMailSpoolingWithBLOBs> selectByExampleWithBLOBs(TMailSpoolingExample example);

    List<TMailSpooling> selectByExample(TMailSpoolingExample example);

    TMailSpoolingWithBLOBs selectByPrimaryKey(TMailSpoolingKey key);

    int updateByExampleSelective(@Param("record") TMailSpoolingWithBLOBs record, @Param("example") TMailSpoolingExample example);

    int updateByExampleWithBLOBs(@Param("record") TMailSpoolingWithBLOBs record, @Param("example") TMailSpoolingExample example);

    int updateByExample(@Param("record") TMailSpooling record, @Param("example") TMailSpoolingExample example);

    int updateByPrimaryKeySelective(TMailSpoolingWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TMailSpoolingWithBLOBs record);

    int updateByPrimaryKey(TMailSpooling record);
}