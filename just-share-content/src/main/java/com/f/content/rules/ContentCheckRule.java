package com.f.content.rules;

import com.f.justsharecommon.domain.Content;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ContentCheckRule {


    boolean doCheck(List<MultipartFile> files, Content content);
}
