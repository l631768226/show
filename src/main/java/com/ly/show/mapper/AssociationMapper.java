package com.ly.show.mapper;

import com.ly.show.model.Association;
import com.ly.show.model.AssociationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AssociationMapper {
    long countByExample(AssociationExample example);

    int deleteByExample(AssociationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Association record);

    int insertSelective(Association record);

    List<Association> selectByExample(AssociationExample example);

    Association selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Association record, @Param("example") AssociationExample example);

    int updateByExample(@Param("record") Association record, @Param("example") AssociationExample example);

    int updateByPrimaryKeySelective(Association record);

    int updateByPrimaryKey(Association record);
}