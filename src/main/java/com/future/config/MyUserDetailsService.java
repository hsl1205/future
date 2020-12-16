package com.future.config;

import com.future.spring_data_jpa.user.entity.SysUser;
import com.future.spring_data_jpa.user.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C) 2020
 * <p>
 * 版权所有。
 * <p>
 * 类名　　  :UserDetailsServiceImpl
 * 功能概要  :用户登录接口实现
 * 做成日期  :2020-11-13  huangsl
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null || "".equals(username)) {
            throw new RuntimeException("用户不能为空");
        }
        //根据用户名查询用户
        SysUser sysUser = sysUserRepository.findByLoginName(username);
        if (sysUser == null) {
            throw new RuntimeException("用户不存在");
        }
        //声明用户授权  暂无相关的权限
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        return new User(sysUser.getLoginName(), sysUser.getPassword(), sysUser.isEnabled(), sysUser.isAccountNonExpired(), sysUser.isCredentialsNonExpired(), sysUser.isAccountNonLocked(), grantedAuthorities);
    }
}
