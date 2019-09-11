package com.research.dao;

import com.research.model.Vo.SciStatistics;
import com.research.model.Vo.SciStatisticsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public interface SciStatisticsMapper {
    int countByExample(SciStatisticsExample example);

    int deleteByExample(SciStatisticsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SciStatistics record);

    int insertSelective(SciStatistics record);

    List<SciStatistics> selectByExample(SciStatisticsExample example);

    SciStatistics selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SciStatistics record, @Param("example") SciStatisticsExample example);

    int updateByExample(@Param("record") SciStatistics record, @Param("example") SciStatisticsExample example);

    int updateByPrimaryKeySelective(SciStatistics record);

    int updateByPrimaryKey(SciStatistics record);
}