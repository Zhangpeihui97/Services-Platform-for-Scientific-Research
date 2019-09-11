package com.research.dao;

import com.research.model.Vo.MeetingUser;
import com.research.model.Vo.MeetingUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface MeetingUserMapper {
    int countByExample(MeetingUserExample example);

    int deleteByExample(MeetingUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MeetingUser record);

    int insertSelective(MeetingUser record);

    List<MeetingUser> selectByExample(MeetingUserExample example);

    MeetingUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MeetingUser record, @Param("example") MeetingUserExample example);

    int updateByExample(@Param("record") MeetingUser record, @Param("example") MeetingUserExample example);

    int updateByPrimaryKeySelective(MeetingUser record);

    int updateByPrimaryKey(MeetingUser record);
}