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
public class UserShareFiles {
    private Integer id;

    private Long contentId;

    private String path;

    private Byte fileType;

    private Date createTime;

    private Date updateTime;
}