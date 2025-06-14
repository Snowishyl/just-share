package com.f.justsharecommon.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author feiwoscun
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Long id;

    private String nickname;

    private Byte role;

    private Byte gender;

    private Date createTime;

    private Integer updateTime;

    private Integer avatorAddr;

    private Integer age;

    private Integer tel;
    private String account;
    private String password;
}