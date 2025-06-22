package com.f.justsharemq.service.impl;

import com.f.justsharecommon.entity.UserShare;
import com.f.justsharemq.mapper.UserShareMapper;
import com.f.justsharemq.service.UserShareService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


/**
 * (UserShare)表服务实现类
 *
 * @author makejava
 * @since 2025-06-22 14:58:57
 */
@Service("userShareService")
public class UserShareServiceImpl implements UserShareService {
    @Resource
    private UserShareMapper userShareMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserShare queryById(long id) {
        return this.userShareMapper.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param userShare 实例对象
     * @return 实例对象
     */
    @Override
    public UserShare insert(UserShare userShare) {
        this.userShareMapper.insert(userShare);
        return userShare;
    }

    /**
     * 修改数据
     *
     * @param userShare 实例对象
     * @return 实例对象
     */
    @Override
    public UserShare update(UserShare userShare) {
        this.userShareMapper.update(userShare);
        return this.queryById(userShare.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(long id) {
        return this.userShareMapper.deleteById(id) > 0;
    }
}
