package com.f.localmsgstarter.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.f.localmsgstarter.domain.LocalMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LocalMessageMapper extends BaseMapper<LocalMessage> {
    @SelectProvider(type = LocalMessageSqlProvider.class, method = "buildSelectPendingMessages")
    List<LocalMessage> selectPendingMessages(@Param("limit") int limit,
                                             @Param("topic") String topic,
                                             @Param("tag") String tag);

}
