package com.f.content.rules;

import com.f.justsharecommon.domain.Content;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Comparator;
import java.util.List;

/**
 * @Author: feiwoscun
 * @Date: 2025/6/13
 * @Description: 这里采用每次触发检查时都使用new一个实体类，不用@Component或者static
 * 方法来标注doCheck，也是为了增强扩展性，用户还可以编写new的规则，增加和删减成员变量
 */

@Data
public class CheckFilter   {


    private Content content;
    private List<MultipartFile> files;
    private final List<ContentCheckRule> rules;

    public CheckFilter(Content content, List<MultipartFile> files,
                       List<ContentCheckRule> rules) {
        this.content = content;
        this.files = files;
        this.rules = rules;
        rules.sort(Comparator.comparingInt(a ->
                a.getClass().getAnnotation(CheckOrder.class).value()));
    }

    /**
     * 链式检查=》 参考tomcat filter
     * @param i
     * @return
     */
    public boolean doCheck(int i) {
        if (i == rules.size()) {
            return true;
        }
        ContentCheckRule contentCheckRule = rules.get(i);
        return contentCheckRule.doCheck(files, content) && doCheck( i + 1);
    }
    public boolean doCheck() {
      return doCheck(0);
    }
}
