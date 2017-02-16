package com.pandawork.service.impl;

import com.pandawork.common.entity.User;
import com.pandawork.common.utils.NFException;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.core.common.util.CommonUtil;
import com.pandawork.core.framework.dao.CommonDao;
import com.pandawork.mapper.UserMapper;
import com.pandawork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * userService的实现
 * Created by Taoyongpan on 2016/11/5.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    protected CommonDao commonDao;

    /**
     *用户增加
     * @param user
     * @throws SSException
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public void newUser(User user)throws SSException
    {
        if(Assert.isNull(user))
        {
            return;
        }
        Assert.isNotNull(user.getUname(), NFException.UnameNotNull);
        Assert.isNotNull(user.getUpwd(),NFException.UpwdNotNull);
        try{
            if(userMapper.queryByName(user.getUname())!=null)
            {
                return;
            }
            else{
                user.setUpwd(CommonUtil.md5(user.getUpwd()));
                userMapper.newUser(user);
            }
        }catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    /**
     * 用户删除
     * @param uid
     * @return
     * @throws SSException
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public boolean delById(int uid)throws SSException
    {
        if(Assert.lessOrEqualZero(uid))
        {
            return false;
        }
        try{
            return userMapper.delById(uid);
        }catch (Exception e)
        {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.DelUserNull,e);
        }
    }

    /**
     * 用户编辑
     * @param user
     * @throws SSException
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public void update(User user)throws SSException
    {
        if(!Assert.isNotNull(user))
        {
            return;
        }
        try{
            user.setUpwd(CommonUtil.md5(user.getUpwd()));
            userMapper.update(user);
        }catch (Exception e)
        {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.UpdateUserFailed,e);
        }
    }

    /**
     * 列出所用用户
     * @return
     * @throws SSException
     */
    @Override
    public List<User> listAll()throws SSException
    {
        List<User> userList= Collections.emptyList();
        try{
            userList = userMapper.listAll();
        }catch (Exception e)
        {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.ListUserAll,e);
        }
        return userList;
    }

    /**
     * 记录所用用户的条数
     * @return
     * @throws SSException
     */
    @Override
    public int countAll()throws SSException
    {
        int count;
        try{
            count = userMapper.countAll();
        }catch(Exception e)
        {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.CountUserAll,e);
        }
        return count;
    }

    /**
     * 根据ID查找
     * @param uid
     * @return
     * @throws SSException
     */
    @Override
    public User queryById(int uid)throws SSException
    {
        if (Assert.lessOrEqualZero(uid))
        {
            return null;
        }
        try{
            return userMapper.queryById(uid);
        }catch (Exception e)
        {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.QueryUserByIdFailed,e);
        }
    }

    /**
     * 根据姓名查找
     * @param uname
     * @return
     * @throws SSException
     */
    @Override
    public User queryByName(String uname)throws SSException
    {
        if (Assert.isNull(uname))
        {
            return null;
        }
        try{
            return userMapper.queryByName(uname);
        }catch (Exception e)
        {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.QueryUserByNameFailed,e);
        }
    }

    /**
     * 登录验证
     * @param uname
     * @param upwd
     * @return
     * @throws Exception
     */
     @Override
     public User checkLogin(String uname, String upwd)throws SSException
     {
         if (Assert.isNull(uname) || Assert.isNull(upwd))
         {
            return null;
         }
         try{
            User user = new User();

            user = userMapper.queryByName(uname);
          if(user!=null)
            {
                upwd = CommonUtil.md5(upwd);
                if(user.getUpwd().equals(upwd)){
                    return user;
            }
            else {
                return null;
            }
           }else{
            return null;
         }
      }
     catch (Exception e)
     {
        LogClerk.errLog.error(e);
        throw SSException.get(NFException.QueryUserByNameFailed,e);
     }
   }

    /**
     * 根据管理员等级查找
     * @param isadmin
     * @return
     * @throws SSException
     */
    @Override
    public List<User> queryByIsAdmin(int isadmin)throws SSException{
        try{
            return userMapper.queryByIsAdmin(isadmin);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.QueryUserByNameFailed,e);
        }
    }
}
