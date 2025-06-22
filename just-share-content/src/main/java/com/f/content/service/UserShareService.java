package com.f.content.service;

import org.springframework.stereotype.Service;

import com.f.justsharecommon.entity.UserShare;

@Service
public interface UserShareService {


    int insert(UserShare record);

    int insertSelective(UserShare record);
}
