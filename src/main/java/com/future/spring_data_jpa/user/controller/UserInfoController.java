package com.future.spring_data_jpa.user.controller;

import com.future.spring_data_jpa.user.entity.SysUser;
import com.future.spring_data_jpa.user.entity.UserInfo;
import com.future.spring_data_jpa.user.service.SysUserService;
import com.future.spring_data_jpa.user.service.UserInfoService;
import com.future.utils.ContentResultForm;
import com.future.utils.ResultForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * Copyright (C) 2020
 * <p>
 * 版权所有。
 * <p>
 * 类名　　  :UserInfoController
 * 功能概要  :用户控制层
 * 做成日期  :2020-11-10  huangsl
 */
@RestController
@RequestMapping("userInfo")
@Api(value = "用户controller",tags = {"用户操作接口"})
@Slf4j
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private SysUserService sysUserService;

    /**
     * 添加用户
     * @param sysUser  用户信息
     * @return   返回创建后的页面信息
     */
    @ApiOperation(value = "新增用户信息")
    @PostMapping
    public ResultForm addUser(@RequestBody SysUser sysUser, Principal principal) {
        try {
            sysUserService.save(sysUser,principal);
            return new ContentResultForm<>(true,null,"添加用户成功！");
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return new ContentResultForm<>(false,null,"新增用户失败！");
        }
    }

    @ApiOperation(value = "更新用户信息")
    @PutMapping
    public void update(@RequestBody UserInfo userInfo){
        userInfoService.saveOrUpdate(userInfo);
    }

    @ApiOperation(value = "删除用户信息（启用状态变为1）")
    @DeleteMapping("/id/{id}")
    public void delUser(@PathVariable String id){
        userInfoService.delUser(id);
    }

    @ApiOperation(value = "根据id查询用户信息")
    @GetMapping("/id/{id}")
    public UserInfo findById(@PathVariable String id){
        return userInfoService.findById(id);
    }

    @ApiOperation(value = "查询所有用户")
    @GetMapping("/")
    public List<UserInfo> findAll(){
        return userInfoService.findAll();
    }
}
