package com.f.justsharemq.mapper;

import com.f.justsharecommon.entity.UserShare;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (UserShare)表数据库访问层
 *
 * @author makejava
 * @since 2025-06-22 14:58:57
 */
public interface UserShareMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param  id 主键
     * @return 实例对象
     */
    UserShare queryById( long id);

    /**
     * 查询指定行数据
     *
     * @param userShare 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
   // List<UserShare> queryAllByLimit(UserShare userShare, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param userShare 查询条件
     * @return 总行数
     */
    long count(UserShare userShare);

    /**
     * 新增数据
     *
     * @param userShare 实例对象
     * @return 影响行数
     */
    int insert(UserShare userShare);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserShare> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<UserShare> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserShare> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<UserShare> entities);

    /**
     * 修改数据
     *
     * @param userShare 实例对象
     * @return 影响行数
     */
    int update(UserShare userShare);

    /**
     * 通过主键删除数据
     *
     * @param  id 主键
     * @return 影响行数
     */
    int deleteById( long id);

    UserShare queryByContentId(long contentId);

}

