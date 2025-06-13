package com.f.justshareuser.controller;

import com.f.justsharecommon.api.CommonResult;
import com.f.justshareuser.entity.User;
import com.f.justshareuser.jwt.JwtUtil;
import com.f.justshareuser.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: feiwoscun
 * @Date: 2025/6/13
 * @Description: 用户相关
 */
@RestController("")
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    /**
     *
     * @param user 用户
     * @return token
     */
    @PostMapping("/login")
    public CommonResult login(@RequestBody User user) {
        try {
            Map<String, String> login = userService.login(user);
            return CommonResult.success(login);
        }catch (Exception e){
            e.printStackTrace();
            log.info(e.getMessage());
            return CommonResult.failed();
        }
    }
    @GetMapping("/test")
    public String test(User user) {
        return "test";
    }
}
