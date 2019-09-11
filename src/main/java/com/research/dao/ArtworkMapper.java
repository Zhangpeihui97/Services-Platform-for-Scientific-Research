package com.research.dao;

import com.research.model.Vo.Artwork;
import com.research.model.Vo.ArtworkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface ArtworkMapper {
    int countByExample(ArtworkExample example);

    int deleteByExample(ArtworkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Artwork record);

    int insertSelective(Artwork record);

    List<Artwork> selectByExample(ArtworkExample example);

    Artwork selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Artwork record, @Param("example") ArtworkExample example);

    int updateByExample(@Param("record") Artwork record, @Param("example") ArtworkExample example);

    int updateByPrimaryKeySelective(Artwork record);

    int updateByPrimaryKey(Artwork record);
}