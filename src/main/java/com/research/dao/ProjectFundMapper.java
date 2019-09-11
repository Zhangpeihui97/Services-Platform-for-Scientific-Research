package com.research.dao;

import com.research.model.Vo.ProjectFund;
import com.research.model.Vo.ProjectFundExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface ProjectFundMapper {
    int countByExample(ProjectFundExample example);

    int deleteByExample(ProjectFundExample example);

    int insert(ProjectFund record);

    int insertSelective(ProjectFund record);

    List<ProjectFund> selectByExample(ProjectFundExample example);

    int updateByExampleSelective(@Param("record") ProjectFund record, @Param("example") ProjectFundExample example);

    int updateByExample(@Param("record") ProjectFund record, @Param("example") ProjectFundExample example);
}