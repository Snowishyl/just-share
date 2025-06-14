package com.f.content.domain;

import com.f.justsharecommon.domain.Content;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author: feiwoscun
 * @Date: 2025/6/14
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPublishContent {
    private Content content;
    private List<MultipartFile> files;
}
