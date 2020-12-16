package com.future.spring_data_jpa.user.service.impl;

import com.future.spring_data_jpa.user.entity.SysUser;
import com.future.spring_data_jpa.user.entity.UserInfo;
import com.future.spring_data_jpa.user.repository.SysUserRepository;
import com.future.spring_data_jpa.user.repository.UserInfoRepository;
import com.future.spring_data_jpa.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright (C) 2020
 * <p>
 * 版权所有。
 * <p>
 * 类名　　  :UserInfoServiceImpl
 * 功能概要  :实现层
 * 做成日期  :2020-11-10  huangsl
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public void saveOrUpdate(UserInfo userInfo) {
        userInfoRepository.save(userInfo);
    }

    @Override
    public void delUser(String userId) {
        userInfoRepository.delUser("1",userId);
    }

    @Override
    public UserInfo findById(String userId) {
        return userInfoRepository.findByUserId(userId);
    }

    @Override
    public List<UserInfo> findAll() {
        //查询所有用户状态为0的
        return userInfoRepository.findAllByIsDelete("0");
    }
}
