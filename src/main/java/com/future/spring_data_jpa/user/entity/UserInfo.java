package com.future.spring_data_jpa.user.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Copyright (C) 2020
 * <p>
 * 版权所有。
 * <p>
 * 类名　　  :UserInfo
 * 功能概要  :用户信息
 * 做成日期  :2020-11-10  huangsl
 */
@Entity
@Table(name = "user_info")
@Data
@DynamicInsert
@DynamicUpdate
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class UserInfo {

    //主键
    @Id
    @Column(name = "user_id",nullable = false,length = 50)
    @GeneratedValue(generator = "jpa-uuid")
    private String userId;

    //姓名
    @Column(name = "USER_NAME",length = 50)
    private String userName;

    //登录名
    @Column(name = "LOGIN_NAME",length = 50)
    private String loginName;

    //登录密码
    @Column(name = "PASSWORD",length = 50)
    private String password;

    //性别
    @Column(name = "SEX",columnDefinition = "varchar(1) default '1'")
    private String sex;

    //年龄
    @Column(name = "AGE",length = 50)
    private Integer age;

    //联系方式
    @Column(name = "MOBILE",length = 50)
    private String mobile;

    //居住地址
    @Column(name = "ADDRESS",length = 255)
    private String address;

    //工作单位
    @Column(name = "WORK_UNIT",length = 255)
    private String workUnit;

    //创建时间
    @Column(name = "CREATE_TIME")
    private Date createTime;

    //是否删除 0表示启用标志，1表示删除标志
    @Column(name = "IS_DELETE",columnDefinition = "varchar(1) default '0'")
    private String isDelete;
}
