package com.pandawork.service;

import com.pandawork.common.entity.Blog;
import com.pandawork.core.common.exception.SSException;

import java.util.ArrayList;
import java.util.List;

/**
 * 博客管理的service层
 * Created by Taoyongpan on 2016/11/9.
 */
public interface BlogService {
    /**
     *
     * @return
     * @throws SSException
     */
    public List<Blog> listAllBlog()throws SSException;

    /**
     * 记录所有的条数
     * @return
     * @throws SSException
     */
    public int countAllBlog()throws SSException;

    /**
     * 根据id查找博客
     * @return
     * @throws SSException
     */
    public Blog queryBlogById(int bid)throws SSException;

    /**
     * 根据名字查找博客
     * @return
     * @throws SSException
     */
    public Blog queryBlogByName(String bname)throws SSException;

    /**
     * 增加博客
     * @throws SSException
     */
    public void newBlog(Blog blog)throws SSException;

    /**
     * 根据id删除博客
     * @return
     * @throws SSException
     */
    public Boolean delBlogById(int bid)throws SSException;

    /**
     * 编辑博客
     * @throws SSException
     */
    public void updateBlog(Blog blog)throws SSException;

    /**
     * 动态查询
     * @param bname
     * @param blable
     * @param uname
     * @return
     * @throws SSException
     */
    public  List<Blog>  queryMore(String bname, String blable, String uname)throws SSException;

    /**
     * 根据作者姓名查找博客
     * @param uname
     * @return
     * @throws SSException
     */
    public List<Blog> queryByUname(String uname)throws SSException;

    /**
     * 根据博客标签查找博客
     * @param blable
     * @return
     * @throws SSException
     */
    public List<Blog> queryByBlable(String blable)throws SSException;

    /**
     * 根据作者和标签查找博客
     * @param uname
     * @param blable
     * @return
     * @throws SSException
     */
    public List<Blog> queryByUnameAndBlable(String uname,String blable)throws SSException;
}
