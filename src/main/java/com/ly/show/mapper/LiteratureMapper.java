package com.ly.show.mapper;

import com.ly.show.model.Literature;
import com.ly.show.model.LiteratureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LiteratureMapper {
    long countByExample(LiteratureExample example);

    int deleteByExample(LiteratureExample example);

    int deleteByPrimaryKey(Integer index);

    int insert(Literature record);

    int insertSelective(Literature record);

    List<Literature> selectByExample(LiteratureExample example);

    Literature selectByPrimaryKey(Integer index);

    int updateByExampleSelective(@Param("record") Literature record, @Param("example") LiteratureExample example);

    int updateByExample(@Param("record") Literature record, @Param("example") LiteratureExample example);

    int updateByPrimaryKeySelective(Literature record);

    int updateByPrimaryKey(Literature record);
}