package com.pandawork.mapper;

import com.pandawork.common.entity.Blog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * 博客管理mapper层
 * Created by Taoyongpan on 2016/11/9.
 */
public interface BlogMapper {

    /**
     * 列出所有博客
     * @return
     * @throws Exception
     */
    public List<Blog> listAllBlog()throws Exception;

    /**
     *查询所有记录数目
     * @return
     * @throws Exception
     */
    public Integer countAll()throws Exception;

    /**
     * 根据ID查询
     * Param bid
     * @return
     * @throws Exception
     */
    public Blog queryBlogById(@Param("bid") int bid)throws Exception;

    /**
     * 根据姓名查询
     * Param bname
     * @return
     * @throws Exception
     */
    public Blog queryBlogByName(@Param("bname") String bname)throws Exception;

    /**
     * 增加博客
     * Param blog
     * @throws Exception
     */
    public void newBlog(@Param("blog") Blog blog)throws Exception;

    /**
     * 更新博客
     * Param bid
     * @return
     * @throws Exception
     */
    public void updateBlog(@Param("blog") Blog blog)throws Exception;

    /**
     * 根据ID删除博客
     * Param bid
     * @return
     * @throws Exception
     */
    public Boolean delBlogById(@Param("bid") int bid)throws Exception;

    /**
     * 动态查询
     * @param bname
     * @param blable
     * @param uname
     * @return
     * @throws Exception
     */
    public List<Blog> queryMore(@Param("bname") String bname,@Param("blable") String blable,@Param("uname") String uname)throws Exception;

    /**
     * 根据作者姓名查找
     * @param uname
     * @return
     * @throws Exception
     */
    public List<Blog> queryByUname(@Param("uname") String uname)throws Exception;

    /**
     * 根据标签查找
     * @param blable
     * @return
     * @throws Exception
     */
    public List<Blog> queryByBlable(@Param("blable") String blable)throws Exception;

    /**
     * 根据作者姓名和标签查找博客
     * @param uname
     * @param blable
     * @return
     * @throws Exception
     */
    public List<Blog> queryByUnameAndBlable(@Param("uname") String uname,@Param("blable") String blable)throws Exception;

}
