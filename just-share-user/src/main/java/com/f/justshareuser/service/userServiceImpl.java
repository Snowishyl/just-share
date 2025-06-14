package com.f.justshareuser.service;

import com.f.justsharecommon.util.RedisUtil;
import com.f.justsharecommon.entity.User;
import com.f.justshareuser.jwt.JwtUtil;
import com.f.justshareuser.mapper.UserMapper;
import io.jsonwebtoken.lang.Maps;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: feiwoscun
 * @Date: 2025/6/13
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class userServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final RedisUtil redisUtil;


    public Map<String, String> login(User record) {
        Integer exist = userMapper.selectAccount(record.getAccount());
        if (exist == null || exist == 0) {
            throw new IllegalArgumentException("该用户还没有注册~");
        }

        Byte role = record.getRole();
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", role);
        String token = JwtUtil.generateToken(record.getAccount(), claims);
        redisUtil.set(record.getAccount()+"token", token);

        return Maps.of("token", token).build();
    }


}
