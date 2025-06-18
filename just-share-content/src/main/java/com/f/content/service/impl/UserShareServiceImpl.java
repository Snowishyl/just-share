package com.f.content.service.impl;

import com.f.content.domain.entity.UserShare;
import com.f.content.mapper.UserShareMapper;
import com.f.content.service.UserShareService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @Author: feiwoscun
 * @Date: 2025/6/18
 * @Description:
 */
@Component
@RequiredArgsConstructor
public class UserShareServiceImpl implements UserShareService {

    private final UserShareMapper userShareMapper;

    @Override
    public int insert(UserShare record) {
        return userShareMapper.insert(record);
    }

    @Override
    public int insertSelective(UserShare record) {
        return userShareMapper.insertSelective(record);
    }
}
