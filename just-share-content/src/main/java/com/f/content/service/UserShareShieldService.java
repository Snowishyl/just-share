package com.f.content.service;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.f.content.mapper.UserShareShieldMapper;
import com.f.content.domain.entity.UserShareShield;
@Service
public class UserShareShieldService{

    @Autowired
    private UserShareShieldMapper userShareShieldMapper;

    
    public int deleteByPrimaryKey(Long id) {
        return userShareShieldMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(UserShareShield record) {
        return userShareShieldMapper.insert(record);
    }

    
    public int insertSelective(UserShareShield record) {
        return userShareShieldMapper.insertSelective(record);
    }

    
    public UserShareShield selectByPrimaryKey(Long id) {
        return userShareShieldMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(UserShareShield record) {
        return userShareShieldMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(UserShareShield record) {
        return userShareShieldMapper.updateByPrimaryKey(record);
    }

}
