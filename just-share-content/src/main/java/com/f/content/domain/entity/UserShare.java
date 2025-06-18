package com.f.content.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserShare {
    private Long id;

    private Long contentId;

    private String content;

    private Byte publishRule;

    private Long userid;

    private Date createTime;

    private Date updateTime;

    private boolean closeAble;
}