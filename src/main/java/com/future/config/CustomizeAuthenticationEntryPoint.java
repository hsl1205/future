package com.future.config;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.future.utils.ContentResultForm;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Copyright (C) 2020
 * <p>
 * 版权所有。
 * <p>
 * 类名　　  :CustomizeAuthenticationEntryPoint
 * 功能概要  :匿名用户访问无权限资源时的异常
 * 做成日期  :2020-11-13  huangsl
 */
@Component
public class CustomizeAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        ContentResultForm<Object> contentResultForm = new ContentResultForm<>(false, null, "USER_NOT_LOGIN");
        httpServletResponse.setContentType("text/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSONUtil.toJsonStr(contentResultForm));
    }
}
