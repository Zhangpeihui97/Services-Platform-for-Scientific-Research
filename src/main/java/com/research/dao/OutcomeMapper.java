package com.research.dao;

import com.research.model.Vo.Outcome;
import com.research.model.Vo.OutcomeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface OutcomeMapper {
    int countByExample(OutcomeExample example);

    int deleteByExample(OutcomeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Outcome record);

    int insertSelective(Outcome record);

    List<Outcome> selectByExample(OutcomeExample example);

    Outcome selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Outcome record, @Param("example") OutcomeExample example);

    int updateByExample(@Param("record") Outcome record, @Param("example") OutcomeExample example);

    int updateByPrimaryKeySelective(Outcome record);

    int updateByPrimaryKey(Outcome record);
}