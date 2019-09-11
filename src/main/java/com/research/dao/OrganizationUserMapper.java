package com.research.dao;

import com.research.model.Vo.OrganizationUser;
import com.research.model.Vo.OrganizationUserExample;
import com.research.model.Vo.OrganizationUserKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface OrganizationUserMapper {
    int countByExample(OrganizationUserExample example);

    int deleteByExample(OrganizationUserExample example);

    int deleteByPrimaryKey(OrganizationUserKey key);

    int insert(OrganizationUser record);

    int insertSelective(OrganizationUser record);

    List<OrganizationUser> selectByExample(OrganizationUserExample example);

    OrganizationUser selectByPrimaryKey(OrganizationUserKey key);

    int updateByExampleSelective(@Param("record") OrganizationUser record, @Param("example") OrganizationUserExample example);

    int updateByExample(@Param("record") OrganizationUser record, @Param("example") OrganizationUserExample example);

    int updateByPrimaryKeySelective(OrganizationUser record);

    int updateByPrimaryKey(OrganizationUser record);
}