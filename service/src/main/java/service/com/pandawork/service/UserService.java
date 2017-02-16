package com.pandawork.service;

import com.pandawork.common.entity.User;
import com.pandawork.core.common.exception.SSException;

import java.util.List;

/**
 *userService层
 * Created by Taoyongpan on 2016/11/5.
 */
public interface UserService {
    /**
     *增加用户
     * @param user
     * @throws SSException
     */
    public void newUser(User user)throws SSException;

    /**
     * 删除用户信息
     * @param uid
     * @return
     * @throws SSException
     */
    public boolean delById(int uid)throws SSException;

    /**
     * 更新用户信息
     * @param user
     * @throws SSException
     */
    public void update(User user)throws SSException;

    /**
     * 列出用户信息
     * @return
     * @throws SSException
     */
    public List<User> listAll() throws SSException;

    /**
     * 记录用户条数
     * @return
     * @throws SSException
     */
    public int countAll() throws SSException;

    /**
     * 根据id查找用户
     * @param uid
     * @return
     * @throws SSException
     */
    public User queryById(int uid)throws SSException;

    /**
     * 根据姓名查找用户
     * @param name
     * @return
     * @throws SSException
     */
    public User queryByName(String name)throws SSException;

    /**
     * 根据用户等级查找
     * @param isadmin
     * @return
     * @throws SSException
     */
    public List<User> queryByIsAdmin(int isadmin)throws SSException;

    /**
     * 用户登录
     * @param uname
     * @param upwd
     * @return
     */
    public User checkLogin(String uname, String upwd) throws SSException;
}
