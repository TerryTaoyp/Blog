package com.pandawork.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 留言实体
 * Created by Taoyongpan on 2016/11/14.
 */

@Table( name = "t_userword")
@Entity
public class Word {
    //留言ID
    @Id
    @Column( name = "w_id")
    private Integer wid;

    //当前博客ID
    @Column( name = "b_id")
    private Integer bid;

    //留言作者
    @Column( name = "u_name")
    private String uname;

    //留言主体
    @Column( name = "w_contant")
    private String wcontant;

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getWcontant() {
        return wcontant;
    }

    public void setWcontant(String wcontant) {
        this.wcontant = wcontant;
    }

    @Override
    public String toString() {
        return "Word{" +
                "uname='" + uname + '\'' +
                '}';
    }
}
