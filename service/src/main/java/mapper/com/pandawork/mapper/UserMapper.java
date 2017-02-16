package com.pandawork.mapper;

import com.pandawork.common.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户信息管理Mapper层
 * Created by Taoyongpan on 2016/11/5.
 */
public interface UserMapper {

    /**
     * 添加用户信息
     * @param user
     * @throws Exception
     */
    public void newUser(@Param("user")User user) throws Exception;

    /**
     * 删除用户信息
     * @param uid
     * @return
     * @throws Exception
     */
    public boolean delById(@Param("uid") int uid)throws Exception;

    /**
     * 更新用户信息
     * @param user
     * @return
     * @throws Exception
     */
    public void update(@Param("user") User user)throws Exception;

    /**
     * 列出用户表
     * @return
     * @throws Exception
     */
    public List<User> listAll()throws Exception;

    /**
     * 查询所有记录数目
     * @return
     * @throws Exception
     */
    public Integer countAll()throws Exception;

    /**
     * 根据id查找用户
     * @param uid
     * @return
     * @throws Exception
     */
    public User queryById(@Param("uid") int uid)throws Exception;

    /**
     * 根据用户等级选择
     * @param isadmin
     * @return
     * @throws Exception
     */
    public List<User> queryByIsAdmin(@Param("isadmin")int isadmin)throws Exception;

    /**
     * 根据姓名查找信息
     * @param uname
     * @return
     * @throws Exception
     */
    public User queryByName(@Param("uname") String uname) throws Exception;

}
