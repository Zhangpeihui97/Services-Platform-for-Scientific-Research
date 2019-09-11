package com.research.dao;

import com.research.model.Vo.ProjectIncome;
import com.research.model.Vo.ProjectIncomeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface ProjectIncomeMapper {
    int countByExample(ProjectIncomeExample example);

    int deleteByExample(ProjectIncomeExample example);

    int insert(ProjectIncome record);

    int insertSelective(ProjectIncome record);

    List<ProjectIncome> selectByExample(ProjectIncomeExample example);

    int updateByExampleSelective(@Param("record") ProjectIncome record, @Param("example") ProjectIncomeExample example);

    int updateByExample(@Param("record") ProjectIncome record, @Param("example") ProjectIncomeExample example);
}