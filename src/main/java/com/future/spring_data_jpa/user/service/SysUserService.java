package com.future.spring_data_jpa.user.service;

import com.future.spring_data_jpa.user.entity.SysUser;

import java.security.Principal;

/**
 * Copyright (C) 2020
 * <p>
 * 版权所有。
 * <p>
 * 类名　　  :SysUserService
 * 功能概要  :SysUser接口
 * 做成日期  :2020-12-03  huangsl
 */
public interface SysUserService {
    void save(SysUser sysUser, Principal principal);
}
