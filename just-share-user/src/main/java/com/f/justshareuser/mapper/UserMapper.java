package com.f.justshareuser.mapper;

import com.f.justsharecommon.entity.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

    Integer selectAccount(String account);
}