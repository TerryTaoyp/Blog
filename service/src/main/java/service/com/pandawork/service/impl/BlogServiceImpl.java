package com.pandawork.service.impl;

import com.pandawork.common.entity.Blog;
import com.pandawork.common.utils.NFException;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.Log;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.core.framework.dao.CommonDao;
import com.pandawork.mapper.BlogMapper;
import com.pandawork.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Taoyongpan on 2016/11/9.
 */
@Service("blogService")
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogMapper blogMapper;

    @Autowired
    protected CommonDao commonDao;

    /**
     * 增加博客
     * @param blog
     * @throws SSException
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public void newBlog(Blog blog)throws SSException{
        if (Assert.isNull(blog))
        {
            return;
        }
        Assert.isNotNull(blog.getBname(),NFException.BlogNameNull);
        Assert.isNotNull(blog.getBlable(),NFException.BlogLableNull);
        Assert.isNotNull(blog.getBcontext(),NFException.BlogContextNull);
        try{
            blogMapper.newBlog(blog);
        }catch (Exception e)
        {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    /**
     * 删除博客
     * @param bid
     * @return
     * @throws SSException
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public Boolean delBlogById(int bid)throws SSException{
        if (Assert.lessOrEqualZero(bid))
        {
            return null;
        }
        try{
            return blogMapper.delBlogById(bid);
        }catch (Exception e)
        {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.DelBlogNull,e);
        }
    }

    /**
     * 编辑博客
     * @param blog
     * @throws SSException
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public void updateBlog(Blog blog)throws SSException{
        if(Assert.isNull(blog))
        {
            return;
        }
        try{
            blogMapper.updateBlog(blog);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.UpdateBlogFailed,e);
        }
    }

    /**
     * 根据ID查找博客
     * @param bid
     * @return
     * @throws SSException
     */
    @Override
    public Blog queryBlogById(int bid)throws SSException{
        if (Assert.lessOrEqualZero(bid))
        {
            return null;
        }
        try{
            return blogMapper.queryBlogById(bid);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.QueryUserByNameFailed,e);
        }
    }

    /**
     * 根据名字查找博客
     * @param bname
     * @return
     * @throws SSException
     */
    @Override
    public Blog queryBlogByName(String bname)throws SSException{
        if(Assert.isNull(bname)){
            return null;
        }
        try{
            return blogMapper.queryBlogByName(bname);
        }catch (Exception e)
        {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.QueryUserByNameFailed,e);
        }
    }

    /**
     * 列出所有博客
     * @return
     * @throws SSException
     */
    @Override
    public List<Blog> listAllBlog()throws SSException{
        try{
            return blogMapper.listAllBlog();
        }catch (Exception e)
        {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.ListUserAll,e);
        }
    }

    /**
     * 记录所有博客的条数
     * @return
     * @throws SSException
     */
    @Override
    public int countAllBlog()throws SSException{
        try{
            return blogMapper.countAll();
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.CountUserAll,e);
        }
    }

    /**
     * 多条件动态查询
     * @param bname
     * @param blable
     * @param uname
     * @return
     * @throws SSException
     */
    @Override
    public List<Blog> queryMore(String bname, String blable, String uname)throws SSException{
        try{
            List<Blog> blogs = Collections.emptyList();
            return blogMapper.queryMore(bname,blable,uname);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.CountUserAll,e);
        }
    }

    /**
     * 根据作者姓名查找用户
     * @param uname
     * @return
     * @throws SSException
     */
    @Override
    public List<Blog> queryByUname(String uname)throws SSException{
        if(Assert.isNull(uname))
        {
            return null;
        }
        try{
            return blogMapper.queryByUname(uname);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.CountUserAll,e);
        }
    }

    /**
     * 根据博客标签查找博客
     * @param blable
     * @return
     * @throws SSException
     */
    @Override
    public List<Blog> queryByBlable(String blable)throws SSException{
        if(Assert.isNull(blable)){
            return null;
        }
        try{
            return blogMapper.queryByBlable(blable);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.CountUserAll,e);
        }
    }

    /**
     * 根据作者和博客查找
     * @param uname
     * @param blable
     * @return
     * @throws SSException
     */
    @Override
    public List<Blog> queryByUnameAndBlable(String uname,String blable)throws SSException{
        if(Assert.isNull(uname)&&Assert.isNull(blable)){
            return null;
        }
        try{
            return blogMapper.queryByUnameAndBlable(uname,blable);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.CountUserAll,e);
        }
    }
}
