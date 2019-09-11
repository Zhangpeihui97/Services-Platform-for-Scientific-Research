package com.research.dao;

import com.research.model.Vo.ProjectOrganizationExample;
import com.research.model.Vo.ProjectOrganizationKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface ProjectOrganizationMapper {
    int countByExample(ProjectOrganizationExample example);

    int deleteByExample(ProjectOrganizationExample example);

    int deleteByPrimaryKey(ProjectOrganizationKey key);

    int insert(ProjectOrganizationKey record);

    int insertSelective(ProjectOrganizationKey record);

    List<ProjectOrganizationKey> selectByExample(ProjectOrganizationExample example);

    int updateByExampleSelective(@Param("record") ProjectOrganizationKey record, @Param("example") ProjectOrganizationExample example);

    int updateByExample(@Param("record") ProjectOrganizationKey record, @Param("example") ProjectOrganizationExample example);
}