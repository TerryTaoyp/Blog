package com.pandawork.web.controller;

import com.pandawork.common.entity.Blog;
import com.pandawork.common.entity.User;
import com.pandawork.common.entity.Word;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.web.spring.AbstractController;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.Session;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/**
 * 博客管理Controller
 * Created by Taoyongpan on 2016/11/11.
 */
@Controller
@RequestMapping("blog")
public class BlogController extends AbstractController {
    /**
     * 列出所有博客&用户等级
     * @param blog
     * @return
     */
    @RequestMapping(value = "/main" , method = RequestMethod.GET)
    public String blogList(HttpServletRequest request,Model blog, RedirectAttributes redirectAttributes) {
        try{
            List<Blog> blogList = Collections.emptyList();
            blogList = blogService.listAllBlog();
            blog.addAttribute("blogList",blogList);
            check(request);
            return "main";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }
    /**
     * 跳转到主页面
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/tomain")
    public String tomain(Model blog,RedirectAttributes redirectAttributes)throws Exception{
               return "redirect:/blog/main";
    }

    /**
     * 增加博客
     * @param blog
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public String newBlog(Blog blog)throws Exception{
        try{
            blogService.newBlog(blog);
            return "redirect:/user/mymain";
        }catch (SSException e)
        {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 删除博客
     * @param bid
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delete/{bid}",method = RequestMethod.GET)
    public String delBlog(@PathVariable("bid") int bid)throws Exception{
        try{
            blogService.delBlogById(bid);
            return "redirect:/user/mymain";
        }catch (SSException e)
        {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 更新编辑博客
     * @param blog
     * @param bid
     * @return
     */
    @RequestMapping(value = "/update/{bid}",method = RequestMethod.POST)
    public String updateBlog(Blog blog,@PathVariable("bid") int bid){
        try{
            blogService.updateBlog(blog);
            return "redirect:/user/mymain";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 根据姓名查找
     * @param bname
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/query/{bname}")
    public String queryblog(HttpServletRequest request,@PathVariable("bname") String bname,Model model,Model word)throws Exception{
        try{
            Blog blog=blogService.queryBlogByName(bname);
            model.addAttribute("blog",blog);
            List<Word> wordList = wordService.queryByBid(blog.getBid());
            word.addAttribute("wordList",wordList);
            String uname1 = (String) request.getSession().getAttribute("uname");
            request.setAttribute("bid",blog.getBid());
            if(uname1==null){
                request.setAttribute("fnone","none");
            }
            return "blogdetail";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 新增留言
     * @param word
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/newword/{bname}",method = RequestMethod.POST)
    public String newWord(Word word)throws Exception{
        try{
            wordService.newWord(word);
            return "redirect:/blog/query/{bname}";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }
    /**
     * 多条件动态查询
     * @param model
     * @param bname
     * @param blable
     * @param uname
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/querymore")
    public String queryMore(HttpServletRequest request,Model  model,@RequestParam("bname") String bname,@RequestParam("blable") String blable,@RequestParam("uname") String uname)throws  Exception{
        try{
            List<Blog> bloglist = Collections.emptyList();
            bloglist = blogService.queryMore(bname,blable,uname);
            model.addAttribute("blogList",bloglist);
            check(request);
            return "main";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 跳转到博客编辑页面
     * @param model
     * @param bid
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/editblog/{bid}")
    public String toEditBlog(Model model,@PathVariable("bid") int bid)throws Exception{
        Blog blog = blogService.queryBlogById(bid);
        model.addAttribute("blog",blog);
        return "editblog";
    }

    /**
     * 跳转到新增博客页面
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/newblog")
    public String toNewBlog()throws Exception{
        return "newblog";
    }

    /**
     * 根据作者姓名查找博客
     * @param request
     * @param session
     * @param model
     * @param uname
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/queryuname/{uname}")
    public String queryByUname(HttpServletRequest request,HttpSession session,Model model,@PathVariable("uname") String uname)throws Exception{
        try{
            List<Blog> blog = blogService.queryByUname(uname);
            model.addAttribute("blogList",blog);
            check(request);
            return "main";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
      }
    }

    /**
     * 根据博客标签查找博客
     * @param request
     * @param session
     * @param model
     * @param blable
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/queryblable/{blable}")
    public String queryByBlable(HttpServletRequest request,HttpSession session,Model model,@PathVariable("blable") String blable)throws Exception{
        try{
            List<Blog> blog = blogService.queryByBlable(blable);
            model.addAttribute("blogList",blog);
            check(request);
            return "main";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 控制前端页面函数
     * @param request
     * @throws SSException
     */
    private void check(HttpServletRequest request)throws SSException {
        String uname = (String)request.getSession().getAttribute("uname");
        if(uname==null)
        {
            request.setAttribute("none", "none");//增删改
            request.setAttribute("pnone", "none");//超级管理员
            request.setAttribute("p1none", "none");//管理员
            request.setAttribute("p2none", "none");//用户
            request.setAttribute("ymsg", "none");//用户登录
            request.setAttribute("p4none", "none");//我的主页
        }
        else{
            User user = userService.queryByName(uname);
            System.out.println(user);
            request.setAttribute("user",user);
            if(user.getIsadmin()==2)
            {
                request.setAttribute("anone", "none");//登录注册
                request.setAttribute("p1none", "none");//管理员
                request.setAttribute("p2none", "none");//用户
            }else if(user.getIsadmin()==1){
                request.setAttribute("anone", "none");//登录注册
                request.setAttribute("pnone", "none");//超级管理员
                request.setAttribute("p1none", "#");//管理员
                request.setAttribute("p2none", "none");//用户
                request.setAttribute("p3none", "none");//身份选择
                request.setAttribute("isadmin","none");

            }else if(user.getIsadmin()==0){
                request.setAttribute("anone", "none");//登录注册
                request.setAttribute("pnone", "none");//超级管理员
                request.setAttribute("p1none", "none");//管理员
                request.setAttribute("ymsg", "none");//用户管理
                request.setAttribute("isadmin","none");
            }
        }
    }
}
