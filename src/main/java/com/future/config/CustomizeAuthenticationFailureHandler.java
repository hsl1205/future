package com.future.config;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.future.utils.ContentResultForm;
import com.future.utils.ResultForm;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
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
 * 类名　　  :CustomizeAuthenticationFailureHandler
 * 功能概要  :登录失败处理逻辑
 * 做成日期  :2020-11-13  huangsl
 */
@Component
public class CustomizeAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        //返回json数据
        String str = "";
        if (e instanceof AccountExpiredException) {
            //账号过期
            str = "USER_ACCOUNT_EXPIRED";
        } else if (e instanceof BadCredentialsException) {
            //密码错误
            str = "USER_CREDENTIALS_ERROR";
        } else if (e instanceof CredentialsExpiredException) {
            //密码过期
            str = "USER_CREDENTIALS_EXPIRED";
        } else if (e instanceof DisabledException) {
            //账号不可用
            str = "USER_ACCOUNT_DISABLE";
        } else if (e instanceof LockedException) {
            //账号锁定
            str = "USER_ACCOUNT_LOCKED";
        } else if (e instanceof InternalAuthenticationServiceException) {
            //用户不存在
            str = "USER_ACCOUNT_NOT_EXIST";
        }else{
            //其他错误
            str = ""+e.getMessage();
        }
        ContentResultForm<String> contentResultForm = new ContentResultForm<>(false,null, str);
        //处理编码方式，防止中文乱码的情况
        httpServletResponse.setContentType("text/json;charset=utf-8");
        //塞到HttpServletResponse中返回给前台
        httpServletResponse.getWriter().write(JSONUtil.toJsonStr(contentResultForm));
    }
}
