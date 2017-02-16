package com.pandawork.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * 博客实体
 * Created by Taoyongpan on 2016/11/9.
 */
@Table(name = "t_blog")
@Entity
public class Blog {

    //博客ID
    @Id
    @Column(name = "b_id")
    private Integer bid;

    //博客名字
    @Column(name = "b_name")
    private String bname;

    //博客标签
    @Column(name = "b_lable")
    private String blable;

    //博客内容
    @Column(name = "b_context")
    private String bcontext;

    //用户姓名
    @Column(name = "u_name")
    private String uname;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBlable() {
        return blable;
    }

    public void setBlable(String blable) {
        this.blable = blable;
    }

    public String getBcontext() {
        return bcontext;
    }

    public void setBcontext(String bcontext) {
        this.bcontext = bcontext;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public ArrayList<Blog> blog(String bname, String blable, String uname){
        this.bname=bname;
        this.blable=blable;
        this.uname = uname;
        return blog(bname,blable,uname);
    }
}
