package com.research.dao;

import com.research.model.Vo.SocStatistic;
import com.research.model.Vo.SocStatisticExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface SocStatisticMapper {
    int countByExample(SocStatisticExample example);

    int deleteByExample(SocStatisticExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SocStatistic record);

    int insertSelective(SocStatistic record);

    List<SocStatistic> selectByExample(SocStatisticExample example);

    SocStatistic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SocStatistic record, @Param("example") SocStatisticExample example);

    int updateByExample(@Param("record") SocStatistic record, @Param("example") SocStatisticExample example);

    int updateByPrimaryKeySelective(SocStatistic record);

    int updateByPrimaryKey(SocStatistic record);
}