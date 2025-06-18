package com.f.content.mapper;

import com.f.content.domain.entity.UserShareAt;

public interface UserShareAtMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserShareAt record);

    int insertSelective(UserShareAt record);

    UserShareAt selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserShareAt record);

    int updateByPrimaryKey(UserShareAt record);
}