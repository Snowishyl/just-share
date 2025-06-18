package com.f.localmsgstarter.mapper;

import org.springframework.util.StringUtils;

import java.util.Map;

public class LocalMessageSqlProvider {
    public String buildSelectPendingMessages(Map<String, Object> params) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM local_msg WHERE status = 0 AND next_retry_time <= NOW() ");

        String topic = (String) params.get("topic");
        if (StringUtils.hasText(topic)) {
            sql.append("AND topic = #{topic} ");
        }
        String tag = (String) params.get("tag");
        if (StringUtils.hasText(tag)) {
            sql.append("AND tag = #{tag} ");
        }

        sql.append("LIMIT #{limit}");

        return sql.toString();
    }
}
