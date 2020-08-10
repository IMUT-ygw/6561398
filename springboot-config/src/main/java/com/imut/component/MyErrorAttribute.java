package com.imut.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/7 10:25
 */
@Component
public class MyErrorAttribute extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String,Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("company","ygw");
        return map;
    }
}
