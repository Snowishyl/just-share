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
public class UserShareAt {
    private Long id;

    private Long commentId;

    /**
    * 文章id
    */
    private Long contentId;

    /**
    * 主动at人的id
    */
    private Long userAtId;

    /**
    * 被at的人的id
    */
    private Long userAtedId;

    private Date createTime;

    private Date updateTime;

    /**
    * 被at的人是否查看消息
    */
    private Boolean ifCheck;

}