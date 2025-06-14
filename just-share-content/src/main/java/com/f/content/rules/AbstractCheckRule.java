package com.f.content.rules;

import com.f.justsharecommon.domain.Content;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author: feiwoscun
 * @Date: 2025/6/13
 * @Description:
 */
@Component
@CheckOrder(1)
public abstract class AbstractCheckRule implements ContentCheckRule {

    @Override
    public boolean doCheck(List<MultipartFile> files, Content content) {
        return true;
    }
}
