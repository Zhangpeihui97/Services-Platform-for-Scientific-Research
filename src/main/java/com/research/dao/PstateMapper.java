package com.research.dao;

import com.research.model.Vo.Pstate;
import com.research.model.Vo.PstateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface PstateMapper {
    int countByExample(PstateExample example);

    int deleteByExample(PstateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Pstate record);

    int insertSelective(Pstate record);

    List<Pstate> selectByExample(PstateExample example);

    Pstate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Pstate record, @Param("example") PstateExample example);

    int updateByExample(@Param("record") Pstate record, @Param("example") PstateExample example);

    int updateByPrimaryKeySelective(Pstate record);

    int updateByPrimaryKey(Pstate record);
}