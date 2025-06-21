package com.f.content.mapper;

import com.f.content.domain.entity.UserShareFiles;

import java.util.List;

public interface UserShareFilesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserShareFiles record);

    int insertSelective(UserShareFiles record);

    UserShareFiles selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserShareFiles record);

    int updateByPrimaryKey(UserShareFiles record);

    Integer insertBatch(List<UserShareFiles> shareFiles);
}