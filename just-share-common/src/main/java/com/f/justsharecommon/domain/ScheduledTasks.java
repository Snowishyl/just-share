package com.f.justsharecommon.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

/**
 * @Author: feiwoscun
 * @Date: 2025/6/13
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduledTasks {
    /**
     * 是否延时发布，1true，0false
     */
    private boolean closeAble;
    /**
     * 发布时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    public boolean getCloseAble() {
        return this.closeAble;
    }
}
