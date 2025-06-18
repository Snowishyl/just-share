package com.f.content.service;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.f.content.mapper.UserShareMapper;
import com.f.content.domain.entity.UserShare;

@Service
public interface UserShareService {


    int insert(UserShare record);

    int insertSelective(UserShare record);
}
