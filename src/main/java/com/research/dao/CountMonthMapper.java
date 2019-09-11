package com.research.dao;

import com.research.model.Vo.CountMonth;
import com.research.model.Vo.CountMonthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface CountMonthMapper {
    int countByExample(CountMonthExample example);

    int deleteByExample(CountMonthExample example);

    int insert(CountMonth record);

    int insertSelective(CountMonth record);

    List<CountMonth> selectByExample(CountMonthExample example);

    int updateByExampleSelective(@Param("record") CountMonth record, @Param("example") CountMonthExample example);

    int updateByExample(@Param("record") CountMonth record, @Param("example") CountMonthExample example);
}