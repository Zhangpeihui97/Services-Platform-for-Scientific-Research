package com.research.dao;

import com.research.model.Vo.ProjectInspection;
import com.research.model.Vo.ProjectInspectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface ProjectInspectionMapper {
    int countByExample(ProjectInspectionExample example);

    int deleteByExample(ProjectInspectionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProjectInspection record);

    int insertSelective(ProjectInspection record);

    List<ProjectInspection> selectByExample(ProjectInspectionExample example);

    ProjectInspection selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProjectInspection record, @Param("example") ProjectInspectionExample example);

    int updateByExample(@Param("record") ProjectInspection record, @Param("example") ProjectInspectionExample example);

    int updateByPrimaryKeySelective(ProjectInspection record);

    int updateByPrimaryKey(ProjectInspection record);
}