package com.commodity.entity.dao;

import com.commodity.entity.DaoInterface;
import com.commodity.entity.dto.MKikakuGenre;
import com.commodity.entity.dto.MKikakuGenreExample;
import com.commodity.entity.dto.MKikakuGenreKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MKikakuGenreMapper extends DaoInterface {
    long countByExample(MKikakuGenreExample example);

    int deleteByExample(MKikakuGenreExample example);

    int deleteByPrimaryKey(MKikakuGenreKey key);

    int insert(MKikakuGenre record);

    int insertSelective(MKikakuGenre record);

    List<MKikakuGenre> selectByExample(MKikakuGenreExample example);

    MKikakuGenre selectByPrimaryKey(MKikakuGenreKey key);

    int updateByExampleSelective(@Param("record") MKikakuGenre record, @Param("example") MKikakuGenreExample example);

    int updateByExample(@Param("record") MKikakuGenre record, @Param("example") MKikakuGenreExample example);

    int updateByPrimaryKeySelective(MKikakuGenre record);

    int updateByPrimaryKey(MKikakuGenre record);
}