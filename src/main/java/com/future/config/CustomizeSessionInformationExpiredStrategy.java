package com.future.config;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.future.utils.ContentResultForm;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Copyright (C) 2020
 * <p>
 * 版权所有。
 * <p>
 * 类名　　  :CustomizeSessionInformationExpiredStrategy
 * 功能概要  :会话信息过期策略
 * 做成日期  :2020-11-13  huangsl
 */
@Component
public class CustomizeSessionInformationExpiredStrategy implements SessionInformationExpiredStrategy {

    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent sessionInformationExpiredEvent) throws IOException, ServletException {
        ContentResultForm<Object> contentResultForm = new ContentResultForm<>(false, null, "USER_ACCOUNT_USE_BY_OTHERS");
        HttpServletResponse httpServletResponse = sessionInformationExpiredEvent.getResponse();
        httpServletResponse.setContentType("text/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSONUtil.toJsonStr(contentResultForm));
    }
}
