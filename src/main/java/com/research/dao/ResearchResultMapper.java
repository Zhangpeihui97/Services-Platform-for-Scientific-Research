package com.research.dao;

import com.research.model.Vo.ResearchResult;
import com.research.model.Vo.ResearchResultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface ResearchResultMapper {
    int countByExample(ResearchResultExample example);

    int deleteByExample(ResearchResultExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ResearchResult record);

    int insertSelective(ResearchResult record);

    List<ResearchResult> selectByExample(ResearchResultExample example);

    ResearchResult selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ResearchResult record, @Param("example") ResearchResultExample example);

    int updateByExample(@Param("record") ResearchResult record, @Param("example") ResearchResultExample example);

    int updateByPrimaryKeySelective(ResearchResult record);

    int updateByPrimaryKey(ResearchResult record);
}