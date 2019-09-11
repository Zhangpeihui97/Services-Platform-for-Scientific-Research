package com.research.dao;

import com.research.model.Vo.Ameeting;
import com.research.model.Vo.AmeetingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface AmeetingMapper {
    int countByExample(AmeetingExample example);

    int deleteByExample(AmeetingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Ameeting record);

    int insertSelective(Ameeting record);

    List<Ameeting> selectByExample(AmeetingExample example);

    Ameeting selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Ameeting record, @Param("example") AmeetingExample example);

    int updateByExample(@Param("record") Ameeting record, @Param("example") AmeetingExample example);

    int updateByPrimaryKeySelective(Ameeting record);

    int updateByPrimaryKey(Ameeting record);
}