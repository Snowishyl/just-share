package com.f.content.mapper;

import com.f.content.domain.entity.UserShareShield;

public interface UserShareShieldMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserShareShield record);

    int insertSelective(UserShareShield record);

    UserShareShield selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserShareShield record);

    int updateByPrimaryKey(UserShareShield record);
}