package com.research.dao;

import com.research.model.Vo.Identification;
import com.research.model.Vo.IdentificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface IdentificationMapper {
    int countByExample(IdentificationExample example);

    int deleteByExample(IdentificationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Identification record);

    int insertSelective(Identification record);

    List<Identification> selectByExample(IdentificationExample example);

    Identification selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Identification record, @Param("example") IdentificationExample example);

    int updateByExample(@Param("record") Identification record, @Param("example") IdentificationExample example);

    int updateByPrimaryKeySelective(Identification record);

    int updateByPrimaryKey(Identification record);
}