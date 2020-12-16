package com.future.spring_data_jpa.user.service.impl;

import com.future.spring_data_jpa.user.entity.SysUser;
import com.future.spring_data_jpa.user.entity.UserInfo;
import com.future.spring_data_jpa.user.repository.SysUserRepository;
import com.future.spring_data_jpa.user.repository.UserInfoRepository;
import com.future.spring_data_jpa.user.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.UUID;

/**
 * Copyright (C) 2020
 * <p>
 * 版权所有。
 * <p>
 * 类名　　  :SysUserServiceImpl
 * 功能概要  :SysUser接口实现
 * 做成日期  :2020-12-03  huangsl
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserRepository sysUserRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Override
    public void save(SysUser sysUser,Principal principal) {
        //先创建用户信息表 获取userId 赋给sys_user表
        UserInfo userInfo = new UserInfo();
        UserInfo save1 = userInfoRepository.save(userInfo);
        //密码加密
        BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
        sysUser.setPassword(encoder.encode(sysUser.getPassword()).trim());
        //create_user   当前登录人的名字
        sysUser.setCreateUser(principal.getName());
        sysUser.setUserId(save1.getUserId());
        SysUser save = sysUserRepository.save(sysUser);
    }
}
