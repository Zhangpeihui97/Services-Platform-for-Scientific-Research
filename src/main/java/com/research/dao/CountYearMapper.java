package com.research.dao;

import com.research.model.Vo.CountYear;
import com.research.model.Vo.CountYearExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.ws.soap.Addressing;

@Component
public interface CountYearMapper {
    int countByExample(CountYearExample example);

    int deleteByExample(CountYearExample example);

    int insert(CountYear record);

    int insertSelective(CountYear record);

    List<CountYear> selectByExample(CountYearExample example);

    int updateByExampleSelective(@Param("record") CountYear record, @Param("example") CountYearExample example);

    int updateByExample(@Param("record") CountYear record, @Param("example") CountYearExample example);
}