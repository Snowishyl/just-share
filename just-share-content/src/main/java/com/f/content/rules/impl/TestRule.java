package com.f.content.rules.impl;

import com.f.content.rules.AbstractCheckRule;
import com.f.content.rules.CheckOrder;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author: feiwoscun
 * @Date: 2025/6/13
 * @Description: 测试，在这个包下写检查规则
 */
@Component
@CheckOrder(1)
public class TestRule extends AbstractCheckRule {

    @Override
    public boolean doCheck(List<MultipartFile> files, String content) {
        return super.doCheck(files, content);
    }
}
