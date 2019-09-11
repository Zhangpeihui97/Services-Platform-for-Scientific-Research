package com.research.dao;

import com.research.model.Vo.ProjectCarryOver;
import com.research.model.Vo.ProjectCarryOverExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface ProjectCarryOverMapper {
    int countByExample(ProjectCarryOverExample example);

    int deleteByExample(ProjectCarryOverExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProjectCarryOver record);

    int insertSelective(ProjectCarryOver record);

    List<ProjectCarryOver> selectByExample(ProjectCarryOverExample example);

    ProjectCarryOver selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProjectCarryOver record, @Param("example") ProjectCarryOverExample example);

    int updateByExample(@Param("record") ProjectCarryOver record, @Param("example") ProjectCarryOverExample example);

    int updateByPrimaryKeySelective(ProjectCarryOver record);

    int updateByPrimaryKey(ProjectCarryOver record);
}