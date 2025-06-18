package com.f.content.service;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.f.content.mapper.UserShareAtMapper;
import com.f.content.domain.entity.UserShareAt;
@Service
public class UserShareAtService{

    @Autowired
    private UserShareAtMapper userShareAtMapper;

    
    public int deleteByPrimaryKey(Long id) {
        return userShareAtMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(UserShareAt record) {
        return userShareAtMapper.insert(record);
    }

    
    public int insertSelective(UserShareAt record) {
        return userShareAtMapper.insertSelective(record);
    }

    
    public UserShareAt selectByPrimaryKey(Long id) {
        return userShareAtMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(UserShareAt record) {
        return userShareAtMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(UserShareAt record) {
        return userShareAtMapper.updateByPrimaryKey(record);
    }

}
