package com.f.content.mapper;

import com.f.content.domain.entity.UserShareShield;

import java.util.List;

public interface UserShareShieldMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserShareShield record);
    Integer batchInsert(List<UserShareShield> userShareShields);
    int insertSelective(UserShareShield record);

    UserShareShield selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserShareShield record);

    int updateByPrimaryKey(UserShareShield record);
}