package com.f.justsharecommon.domain;

import com.f.justsharecommon.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: feiwoscun
 * @Date: 2025/6/13
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Content {

    private String content;
    /**
     * 发布用户
     */
    private User user;
    /**
     * 发布规则，0私密发布，2屏蔽部分人，1公开等
     */
    private Byte publishRule;
    /**
     * 艾特，可以采用异步通知
     */
    private List<User> Ats;

    /**
     * 屏蔽用户列表
     */
    private List<User> userShields;
    /**
     * 定时发布
     */
    private ScheduledTasks taskInfo;
    /**
     * 文章id 唯一
     */
    private long  contentId;
}
