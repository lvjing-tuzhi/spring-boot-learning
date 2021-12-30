package com.tuzhi.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @program: SpringBoot-web
 * @description: 国际化自定义
 * @author: 兔子
 * @create: 2021-12-11 20:15
 **/

public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("l");
        Locale aDefault = Locale.getDefault();
        if (l != null) {
            String[] s = l.split("_");
            aDefault = new Locale(s[0], s[1]);
        }
        return aDefault;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
