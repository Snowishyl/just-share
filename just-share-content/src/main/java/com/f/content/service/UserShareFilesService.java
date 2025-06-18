package com.f.content.service;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.f.content.domain.entity.UserShareFiles;
import com.f.content.mapper.UserShareFilesMapper;
@Service
public class UserShareFilesService{

    @Autowired
    private UserShareFilesMapper userShareFilesMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return userShareFilesMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(UserShareFiles record) {
        return userShareFilesMapper.insert(record);
    }

    
    public int insertSelective(UserShareFiles record) {
        return userShareFilesMapper.insertSelective(record);
    }

    
    public UserShareFiles selectByPrimaryKey(Integer id) {
        return userShareFilesMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(UserShareFiles record) {
        return userShareFilesMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(UserShareFiles record) {
        return userShareFilesMapper.updateByPrimaryKey(record);
    }

}
