package com.f.content.controller;

import com.f.content.domain.UserPublishContent;
import com.f.content.factory.PublishStrategyFactory;
import com.f.justsharecommon.domain.Content;
import com.f.content.rules.CheckFilter;
import com.f.content.rules.ContentCheckRule;
import com.f.justsharecommon.api.CommonResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author: feiwoscun
 * @Date: 2025/6/13
 * @Description:
 */
@RestController
@RequestMapping("/publish")
@RequiredArgsConstructor
public class ContentController {
    private final List<ContentCheckRule> rules;
    private final PublishStrategyFactory publishStrategyFactory;

    public CommonResult<?> publishContent(@RequestParam Content content, @RequestParam List<MultipartFile> files) {
        try {
            //todo 检查文件，内容
            new CheckFilter(content, files, rules).doCheck();
            //todo 触发发布，文章入库，文件异步上传，回调通知
            UserPublishContent userPublishContent = UserPublishContent.builder()
                    .content(content)
                    .files(files)
                    .build();
            publishStrategyFactory.publish(content.getPublishRule(), userPublishContent);
        } catch (Exception e) {
            //todo 这里要捕捉异常，要检查是什么异常
            return CommonResult.failed();
        }

        return CommonResult.success("");
    }
}
