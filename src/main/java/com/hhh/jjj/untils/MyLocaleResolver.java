package com.hhh.jjj.untils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {// 完成请求参数的判断 从而选择中英文区域信息

        Locale locale = Locale.getDefault();// 获取当前默认的区域信息
        String l = request.getParameter("l");  // 参数 l=en_US   l=zh_CN
        if(StringUtils.hasLength(l)){          //  spring提供给 StringUtils 一系列开发常用方法 如 是否为null  是否有长度 ....
            String[] s = l.split("_");  // zh     CN
            locale=new Locale(s[0],s[1]); // 使用 语言 城市 来构建区域信息对象
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}