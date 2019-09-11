package com.research.dao;

import com.research.model.Vo.PaperOrganizationExample;
import com.research.model.Vo.PaperOrganizationKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface PaperOrganizationMapper {
    int countByExample(PaperOrganizationExample example);

    int deleteByExample(PaperOrganizationExample example);

    int deleteByPrimaryKey(PaperOrganizationKey key);

    int insert(PaperOrganizationKey record);

    int insertSelective(PaperOrganizationKey record);

    List<PaperOrganizationKey> selectByExample(PaperOrganizationExample example);

    int updateByExampleSelective(@Param("record") PaperOrganizationKey record, @Param("example") PaperOrganizationExample example);

    int updateByExample(@Param("record") PaperOrganizationKey record, @Param("example") PaperOrganizationExample example);
}