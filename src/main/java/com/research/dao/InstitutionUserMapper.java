package com.research.dao;

import com.research.model.Vo.InstitutionUser;
import com.research.model.Vo.InstitutionUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface InstitutionUserMapper {
    int countByExample(InstitutionUserExample example);

    int deleteByExample(InstitutionUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InstitutionUser record);

    int insertSelective(InstitutionUser record);

    List<InstitutionUser> selectByExample(InstitutionUserExample example);

    InstitutionUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InstitutionUser record, @Param("example") InstitutionUserExample example);

    int updateByExample(@Param("record") InstitutionUser record, @Param("example") InstitutionUserExample example);

    int updateByPrimaryKeySelective(InstitutionUser record);

    int updateByPrimaryKey(InstitutionUser record);
}