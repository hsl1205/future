package com.future.spring_data_jpa.user.service;

import com.future.spring_data_jpa.user.entity.SysUser;
import com.future.spring_data_jpa.user.entity.UserInfo;

import java.util.List;

/**
 * Copyright (C) 2020
 * <p>
 * 版权所有。
 * <p>
 * 类名　　  :UserInfoService
 * 功能概要  :接口层
 * 做成日期  :2020-11-10  huangsl
 */
public interface UserInfoService {

    void saveOrUpdate(UserInfo userInfo);

    void delUser(String userId);

    UserInfo findById(String userId);

    List<UserInfo> findAll();
}
