package com.research.dao;

import com.research.model.Vo.Patent;
import com.research.model.Vo.PatentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface PatentMapper {
    int countByExample(PatentExample example);

    int deleteByExample(PatentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Patent record);

    int insertSelective(Patent record);

    List<Patent> selectByExample(PatentExample example);

    Patent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Patent record, @Param("example") PatentExample example);

    int updateByExample(@Param("record") Patent record, @Param("example") PatentExample example);

    int updateByPrimaryKeySelective(Patent record);

    int updateByPrimaryKey(Patent record);
}