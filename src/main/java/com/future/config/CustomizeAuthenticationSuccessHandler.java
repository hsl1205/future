package com.future.config;

import cn.hutool.json.JSONUtil;
import com.future.spring_data_jpa.user.entity.SysUser;
import com.future.spring_data_jpa.user.repository.SysUserRepository;
import com.future.utils.AccessAddressUtil;
import com.future.utils.ContentResultForm;
import com.future.utils.JwtTokenUtil;
import com.future.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C) 2020
 * <p>
 * 版权所有。
 * <p>
 * 类名　　  :CustomizeAuthenticationSuccessHandler
 * 功能概要  :登录成功处理逻辑
 * 做成日期  :2020-11-13  huangsl
 */
@Component
@Slf4j
public class CustomizeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Value("${token.expirationSeconds}")
    private int expirationSeconds;

    @Value("${token.validTime}")
    private int validTime;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        //更新用户表上次登录时间、更新人、更新时间等字段
        User userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //此处还可以进行一些处理，比如登录成功之后可能需要返回给前台当前用户有哪些菜单权限，
        //进而前台动态的控制菜单的显示等，具体根据自己的业务需求进行扩展
        //获取请求的ip地址
        String ip = AccessAddressUtil.getIpAddress(httpServletRequest);
        Map<String,Object> map = new HashMap<>();
        map.put("ip",ip);
        String jwtToken = JwtTokenUtil.generateToken(userDetails.getUsername(), expirationSeconds,map);
        SysUser sysUser = sysUserRepository.findByLoginName(userDetails.getUsername());
        //刷新时间
        Integer expire = validTime*24*60*60*1000;
        //获取请求的ip地址
        String currentIp = AccessAddressUtil.getIpAddress(httpServletRequest);
        redisUtil.setTokenRefresh(jwtToken,userDetails.getUsername(),currentIp);
        log.info("用户{}登录成功，信息已保存至redis",userDetails.getUsername());
        //修改数据库记录
        sysUserRepository.update(new Date(),new Date(),sysUser.getSysId());
        //返回jwtToken给前台
        HashMap<String, Object> loginInfo = new HashMap<>();
        loginInfo.put("jwtToken",jwtToken);
        loginInfo.put("userDetails",userDetails);
        ContentResultForm<Map> contentResultForm = new ContentResultForm<>(true, loginInfo, "USER_LOGIN_SUCCESS");
        //处理编码方式，防止中文乱码的情况
        httpServletResponse.setContentType("text/json;charset=utf-8");
        //塞到HttpServletResponse中返回给前台
        httpServletResponse.getWriter().write(JSONUtil.toJsonStr(contentResultForm));
    }
}
