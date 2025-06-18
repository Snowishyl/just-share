package com.f.content.mapper;

import com.f.content.domain.entity.UserShare;
import org.springframework.stereotype.Repository;

@Repository
public interface UserShareMapper {
    int insert(UserShare record);

    int insertSelective(UserShare record);
}