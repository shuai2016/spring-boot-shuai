package com.shuai.component;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Map;

/**
 * MyErrorAttributes
 *
 * @author shuai
 * @date 2018/11/30
 */
@Component  //给容器加入自定义的ErrorAttributes
public class MyErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(requestAttributes, includeStackTrace);
        map.put("company","shuai.公司");
        //异常处理器携带的数据
        Object ext = requestAttributes.getAttribute("ext", 0);
        map.put("ext", ext);
        return map;
    }
}
