package com.pandawork.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User实体
 * Created by Taoyongpan on 2016/11/5.
 */
@Table( name = "t_user" )
@Entity
public class User {
    //ID用户
    @Id
    @Column(name = "u_id")
    private Integer uid;
    //用户姓名
    @Column( name = "u_name")
    private String uname;
    //用户密码
    @Column( name = "u_pwd")
    private String upwd;
    //管理员等级
    @Column( name = "is_admin")

    private Integer isadmin;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public Integer getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(Integer isadmin) {
        this.isadmin = isadmin;
    }
}
