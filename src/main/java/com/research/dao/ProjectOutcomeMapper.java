package com.research.dao;

import com.research.model.Vo.ProjectOutcome;
import com.research.model.Vo.ProjectOutcomeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface ProjectOutcomeMapper {
    int countByExample(ProjectOutcomeExample example);

    int deleteByExample(ProjectOutcomeExample example);

    int insert(ProjectOutcome record);

    int insertSelective(ProjectOutcome record);

    List<ProjectOutcome> selectByExample(ProjectOutcomeExample example);

    int updateByExampleSelective(@Param("record") ProjectOutcome record, @Param("example") ProjectOutcomeExample example);

    int updateByExample(@Param("record") ProjectOutcome record, @Param("example") ProjectOutcomeExample example);
}