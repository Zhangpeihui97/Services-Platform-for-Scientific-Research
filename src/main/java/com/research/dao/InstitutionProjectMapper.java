package com.research.dao;

import com.research.model.Vo.InstitutionProjectExample;
import com.research.model.Vo.InstitutionProjectKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface InstitutionProjectMapper {
    int countByExample(InstitutionProjectExample example);

    int deleteByExample(InstitutionProjectExample example);

    int deleteByPrimaryKey(InstitutionProjectKey key);

    int insert(InstitutionProjectKey record);

    int insertSelective(InstitutionProjectKey record);

    List<InstitutionProjectKey> selectByExample(InstitutionProjectExample example);

    int updateByExampleSelective(@Param("record") InstitutionProjectKey record, @Param("example") InstitutionProjectExample example);

    int updateByExample(@Param("record") InstitutionProjectKey record, @Param("example") InstitutionProjectExample example);
}