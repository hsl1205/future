package com.future.spring_data_jpa.user.repository;

import com.future.spring_data_jpa.user.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * Copyright (C) 2020
 * <p>
 * 版权所有。
 * <p>
 * 类名　　  :SysUserRepository
 * 功能概要  :用户登录数据操作
 * 做成日期  :2020-11-13  huangsl
 */
@Transactional
@Repository
public interface SysUserRepository extends JpaRepository<SysUser,String> {

    /**
     * 保存用户
     * @param s
     * @param <S>
     * @return
     */
    @Override
    <S extends SysUser> S saveAndFlush(S s);

    SysUser findByLoginName(String loginName);

    //更新用户表上次登录时间、更新人、更新时间等字段
    @Query(value = "UPDATE sys_user SET sys_user.last_login_time = ?1, update_time = ?2 WHERE sys_id = ?3 ", nativeQuery = true)
    @Modifying
    void update(Date lastLoginTime, Date updateTime, String id);
}
