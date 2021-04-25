package com.future.config;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.future.utils.ContentResultForm;
import com.future.utils.DateUtil;
import com.future.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
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
 * 类名　　  :CustomizeLogoutSuccessHandler
 * 功能概要  :登出成功处理逻辑
 * 做成日期  :2020-11-13  huangsl
 */
@Component
@Slf4j
public class CustomizeLogoutSuccessHandler implements LogoutSuccessHandler {

    @Autowired
    private RedisUtil redisUtil;
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        ContentResultForm<Object> contentResultForm = new ContentResultForm<>(true, null, "USER_LOGOUT_SUCCESS");
        String authHeader = httpServletRequest.getHeader("Authorization");
        httpServletResponse.setContentType("text/json;charset=utf-8");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            final String authToken = authHeader.substring("Bearer ".length());
            //将token放入黑名单中
            redisUtil.hset("blacklist", authToken, DateUtil.getTime());
            log.info("token：{}已加入redis黑名单",authToken);
            log.info("用户登出成功！");
            httpServletResponse.getWriter().write(JSONUtil.toJsonStr(contentResultForm));
        }else {
            httpServletResponse.getWriter().write(JSONUtil.toJsonStr(new ContentResultForm<>(false,null,"USER_LOGOUT_FAILED")));
        }
    }
}
