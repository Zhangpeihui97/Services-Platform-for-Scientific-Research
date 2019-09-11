package com.research.dao;

import com.research.model.Vo.Closure;
import com.research.model.Vo.ClosureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface ClosureMapper {
    int countByExample(ClosureExample example);

    int deleteByExample(ClosureExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Closure record);

    int insertSelective(Closure record);

    List<Closure> selectByExample(ClosureExample example);

    Closure selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Closure record, @Param("example") ClosureExample example);

    int updateByExample(@Param("record") Closure record, @Param("example") ClosureExample example);

    int updateByPrimaryKeySelective(Closure record);

    int updateByPrimaryKey(Closure record);
}