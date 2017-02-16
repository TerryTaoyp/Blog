package com.pandawork.test;

import com.pandawork.common.entity.User;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试service页面
 * Created by Taoyongpan on 2016/11/5.
 */
public class UserServiceTest extends AbstractTestCase {
    @Autowired
    UserService userService;

    /**
     * 测试新增用户信息
     * @throws SSException
     */
    @Test
    public void testNewUser() throws SSException{
        User user = new User();
        user.setIsadmin(2);
        user.setUname("Taoyongpan");
        user.setUpwd("123456");
        userService.newUser(user);
    }

    /**
     * 测试列出所用用户
     * @throws SSException
     */
    @Test
    public void testListUserAll()throws SSException
    {
            System.out.println(userService.listAll());
    }

    /**
     * 测试记录所有条数
     * @throws SSException
     */
    @Test
    public void testCountAll()throws SSException{
        System.out.println(userService.countAll());
    }

    /**
     * 测试根据ID删除用户
     * @throws SSException
     */
    @Test
    public void testDelUserById()throws SSException
    {
        User user = new User();
        user.setUid(2);
        userService.delById(2);
    }

    /**
     * 测试编辑用户信息
     * @throws SSException
     */
    @Test
    public void testUpdate()throws SSException{
        User user = new User();
        user.setUid(3);
        user.setUname("admin4");
        user.setUpwd("admin4");
        userService.update(user);
    }

    /**
     * 测试根据ID查找用户
     * @throws SSException
     */
    @Test
    public void testQueryById() throws SSException{
        User user = new User();
        user = userService.queryById(3);
        System.out.println(user.getUname());
    }

    /**
     * 测试根据姓名查找用户
     * @throws SSException
     */
    @Test
    public void testQueryByName()throws SSException
    {
        User user = null;
        user = userService.queryByName("admin");
        System.out.println(user.getUpwd());
    }

    /**
     * 测试登录
     * @throws Exception
     */
    @Test
    public void testLogin() throws Exception
    {
        User user = new User();
        user.setUname("admin2");
        user.setUpwd("admin");
        userService.checkLogin(user.getUname(),user.getUpwd());
        System.out.println( userService.checkLogin(user.getUname(),user.getUpwd()));
        System.out.println(user.getUpwd());
    }

    /**
     * 测试根据isadmin查找用户
     * @throws Exception
     */
    @Test
    public void testQueryByIsAdmin()throws Exception{
        System.out.println(userService.queryByIsAdmin(0));
    }
}
