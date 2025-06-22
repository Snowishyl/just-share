package com.f.justsharemq.service;

import com.f.justsharecommon.entity.UserShare;

/**
 * (UserShare)表服务接口
 *
 * @author makejava
 * @since 2025-06-22 14:58:57
 */
public interface UserShareService {

    /**
     * 通过ID查询单条数据
     *
     * @param  id 主键
     * @return 实例对象
     */
    UserShare queryById( long id);

    /**
     * 新增数据
     *
     * @param userShare 实例对象
     * @return 实例对象
     */
    UserShare insert(UserShare userShare);

    /**
     * 修改数据
     *
     * @param userShare 实例对象
     * @return 实例对象
     */
    UserShare update(UserShare userShare);

    /**
     * 通过主键删除数据
     *
     * @param  id 主键
     * @return 是否成功
     */
    boolean deleteById( long id);

}
