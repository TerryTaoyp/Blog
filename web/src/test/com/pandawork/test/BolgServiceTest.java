package com.pandawork.test;

import com.pandawork.common.entity.Blog;
import com.pandawork.service.BlogService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Taoyongpan on 2016/11/9.
 */
public class BolgServiceTest extends AbstractTestCase {
    @Autowired
    BlogService blogService;
    //测试新增博客信息
    @Test
    public void testNewBlog()throws Exception{
        Blog blog = new Blog();
        blog.setBname("Tao");
        blog.setBlable("Java");
        blog.setBcontext("JJJJJ");
        blog.setUname("www");
        blogService.newBlog(blog);
    }

    //测试删除博客信息
    @Test
    public void testDelBlog()throws Exception{
        Blog blog = new Blog();
        blog.setBid(1);
        blogService.delBlogById(blog.getBid());
    }

    //测试博客更新
    @Test
    public void testUpdateBlog()throws Exception{
        Blog blog = new Blog();
        blog.setBid(2);
        blog.setBname("Tao");
        blog.setBlable("C++");
        blog.setBcontext("LLLLL");
        blogService.updateBlog(blog);

    }

    //测试根据id查找博客
    @Test
    public void testQueryBlogById()throws Exception{
        Blog blog = new Blog();
        blog.setBid(2);
        blogService.queryBlogById(blog.getBid());
    }

    //测试根据名字查找博客
    @Test
    public void testQueryBlogByName()throws Exception{
        Blog blog = new Blog();
        blog.setBname("Tao");
        blogService.queryBlogByName(blog.getBname());
    }

    //测试列出博客列表
    @Test
    public void  testListAllBlog()throws Exception{
        System.out.println(blogService.listAllBlog());
    }

    //测试记录博客条数
    @Test
    public void  testCountAll()throws Exception{
        System.out.println(blogService.countAllBlog());
    }
    //测试动态查询
    @Test
    public void testQueryMore()throws Exception{
        System.out.println(blogService.queryMore("","", "Tao"));
    }
}
