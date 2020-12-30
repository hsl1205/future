package com.future.spring_data_jpa.user.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.io.Serializable;

/**
 * 用户表(SysUser)实体类
 *
 * @author makejava
 * @since 2020-11-13 10:34:46
 */
@Entity
@Table(name = "sys_user")
@Data
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class SysUser implements UserDetails,  Serializable {
    private static final long serialVersionUID = -76517248100323257L;

    @Id
    @Column(name = "sys_id",nullable = false,length = 50)
    @GeneratedValue(generator = "jpa-uuid")
    private String sysId;

    /**
     * 用户id
     */
    @Column(name = "user_id",nullable = false,length = 50)
    private String userId;
    /**
    * 账号
    */
    private String loginName;
    /**
    * 用户名
    */
    private String userName;
    /**
    * 用户密码
    */
    private String password;
    /**
    * 上一次登录时间
    */
    private Date lastLoginTime;
    /**
    * 账号是否可用。默认为1（可用）
    */
    private boolean enabled;
    /**
    * 是否过期。默认为1（没有过期）
    */
    private boolean accountNonExpired;
    /**
    * 账号是否锁定。默认为1（没有锁定）
    */
    private boolean accountNonLocked;
    /**
    * 证书（密码）是否过期。默认为1（没有过期）
    */
    private boolean credentialsNonExpired;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 修改时间
    */
    private Date updateTime;
    /**
    * 创建人
    */
    private String createUser;
    /**
    * 修改人
    */
    private String updateUser;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.getLoginName();
    }

    /**
     * 重写equals和hashcode方法
     * @param obj 用户对象
     * @return 返回重写后的用户名
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SysUser) {
            SysUser another = (SysUser)obj;
            return this.getUsername().equals(another.getUsername());
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return this.getUsername().hashCode();
    }
}
