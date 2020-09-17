package com.ly.show.mapper;

import com.ly.show.model.Submitinfo;
import com.ly.show.model.SubmitinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubmitinfoMapper {
    long countByExample(SubmitinfoExample example);

    int deleteByExample(SubmitinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Submitinfo record);

    int insertSelective(Submitinfo record);

    List<Submitinfo> selectByExample(SubmitinfoExample example);

    Submitinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Submitinfo record, @Param("example") SubmitinfoExample example);

    int updateByExample(@Param("record") Submitinfo record, @Param("example") SubmitinfoExample example);

    int updateByPrimaryKeySelective(Submitinfo record);

    int updateByPrimaryKey(Submitinfo record);
}