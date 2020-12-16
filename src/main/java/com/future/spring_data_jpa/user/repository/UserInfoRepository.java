package com.future.spring_data_jpa.user.repository;
import com.future.spring_data_jpa.user.entity.SysUser;
import com.future.spring_data_jpa.user.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Copyright (C) 2020
 * <p>
 * 版权所有。
 * <p>
 * 类名　　  :UserInfoRepository
 * 功能概要  :调用jpa实现数据访问
 * 做成日期  :2020-11-10  huangsl
 */
@Transactional
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

    /**
     * 保存用户信息
     * @param s
     * @param <S>
     * @return
     */
    @Override
    <S extends UserInfo> S saveAndFlush(S s);

    //修改用户的启用状态
    @Query(value = "update user_info u set u.is_delete=?1 where u.user_id=?2", nativeQuery = true)
    @Modifying
    public void delUser(String isDelete,String userId);

    //查询所有的用户信息
    List<UserInfo> findAllByIsDelete(String isDelete);

    //根据userId查询用户信息

    UserInfo findByUserId(String userId);
}
