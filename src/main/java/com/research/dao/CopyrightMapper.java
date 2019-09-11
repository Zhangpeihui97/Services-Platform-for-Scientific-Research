package com.research.dao;

import com.research.model.Vo.Copyright;
import com.research.model.Vo.CopyrightExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface CopyrightMapper {
    int countByExample(CopyrightExample example);

    int deleteByExample(CopyrightExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Copyright record);

    int insertSelective(Copyright record);

    List<Copyright> selectByExample(CopyrightExample example);

    Copyright selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Copyright record, @Param("example") CopyrightExample example);

    int updateByExample(@Param("record") Copyright record, @Param("example") CopyrightExample example);

    int updateByPrimaryKeySelective(Copyright record);

    int updateByPrimaryKey(Copyright record);
}