package com.pandawork.web.controller;

import com.pandawork.common.entity.Blog;
import com.pandawork.common.entity.User;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.core.common.util.CommonUtil;
import com.pandawork.web.spring.AbstractController;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Taoyongpan on 2016/11/7.
 */
@Controller
@RequestMapping("user")
public class UserController extends AbstractController {

    /**
     *列出用户的Controller
     * @param model
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String userList(Model model,HttpServletRequest request)
    {
        try{
            List<User> list= Collections.emptyList();
            String uname = (String)request.getSession().getAttribute("uname");
            User user =userService.queryByName(uname);
            if(user.getIsadmin()==2){
                list = userService.listAll();
            }else if(user.getIsadmin()==1){
                list = userService.queryByIsAdmin(0);
            }
            model.addAttribute("list",list);
            return "userList";
        }catch (SSException e)
        {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 删除用户的Controller
     * @param uid
     * @return
     */
    @RequestMapping(value = "/delete/{uid}",method = RequestMethod.GET)
    public String deleteUser(@PathVariable("uid") int uid){
        try{
            userService.delById(uid);
            return "redirect:/user/list";//删除后还需重定向页面才可获取最新列表
        }catch (SSException e)
        {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 跳转到from页面
     * @return
     */
    @RequestMapping(value = "/form",method = RequestMethod.GET)
    public String toform(HttpServletRequest request){;
        try{
            String uname = (String)request.getSession().getAttribute("uname");
            User user =userService.queryByName(uname);
            if(user.getIsadmin()==1){
                request.setAttribute("p3none", "none");//身份选择
            }
        return "form";
        }catch (SSException e)
        {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 跳转到edit页面
     * @param uid
     * @return
     */
    @RequestMapping(value = "/edit/{uid}")
    public String toedit(@PathVariable("uid") int uid){
        return "edit";
    }

    /**
     * 增加
     * @param user
     * @return
     */
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String newUser(User user)
    {
        try{
            userService.newUser(user);
            return "redirect:/user/list";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 更新用户的Controller
     * @param user
     * @param uid
     * @return
     */
    @RequestMapping(value = "/update/{uid}",method = RequestMethod.POST)
    public String update(User user,@PathVariable("uid") int uid){
        if(Assert.isNull(user))
        {
            return null;
        }
        try{
            userService.update(user);
            return "redirect:/user/list";
        }catch (SSException e)
        {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 根据ID查找用户的Controller
     * @param user
     * @param uid
     * @return
     */
    @RequestMapping(value = "/edit/{uid}",method = RequestMethod.POST)
    public String edit(User user,@PathVariable("uid") int uid,Model model){
        try{
            userService.queryById(uid);
            user = userService.queryById(uid);
            model.addAttribute("model",user);
            return "edit";
        }catch (SSException e)
        {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 根据ID查找用户
     * @param uid
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/queryid/{uid}",method = RequestMethod.POST)
    public String queryblogById(@PathVariable("uid") int uid,Model model){
        try{
            User user = userService.queryById(uid);
            model.addAttribute("user",user);
            return "redirect:/blog/main";
        }catch (SSException e)
        {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }
    /**
     * 登录页面的controller
     * @param userName
     * @param password
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpSession session,@RequestParam("uname") String userName, @RequestParam("upwd") String password,@RequestParam("isadmin") int isadmin,Model a,RedirectAttributes redirectAttributes)throws Exception
    {


        System.out.println(userName);
        try{
            User checkUser = null;
            checkUser = userService.checkLogin(userName,password);
            User user = userService.queryByName(userName);
            System.out.println(user);
            if(user==null){
                redirectAttributes.addFlashAttribute("msg1","该用户名不存在！");
                return "redirect:/user/tologin";
            }else {
                if(checkUser!=null){
                    redirectAttributes.addFlashAttribute("user",user);
                    session.setAttribute("uname",user.getUname());
                    return "redirect:/blog/main";
                }else{
                    redirectAttributes.addFlashAttribute("msg1","密码错误！");
                    return "redirect:/user/tologin";
                }
            }
        }catch (SSException e)
        {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 登录页面的controller
     * @param
     * @param
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/applogin")
    public String applogin()throws Exception
    {

        List<String> strings = new ArrayList<String>();
        strings.add("12");
        strings.add("fghj");

        JSONArray jsonArray = JSONArray.fromObject(strings);

        return  jsonArray.toString();
    }

    /**
     * 跳转到登录页面
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/tologin",method = RequestMethod.GET)
    public String tologin()throws Exception{
        return "login";
    }

    /**
     * 跳转到注册页面
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/toregister" , method = RequestMethod.GET)
    public String toregister()throws Exception{
        return "register";
    }
    @RequestMapping(value = "/register" ,method = RequestMethod.POST)
    public String register(User user,RedirectAttributes redirectAttributes)throws Exception{
        try{
            if (userService.queryByName(user.getUname())!=null)
            {
                redirectAttributes.addFlashAttribute("msg","该用户名已经存在！");
                return "redirect:/user/toregister";
            }else{
                userService.newUser(user);
                redirectAttributes.addFlashAttribute("msg1","注册成功！");
                return "redirect:/user/tologin";
            }

        }catch (SSException e)
        {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 跳转到我的主页
     * @param session
     * @param request
     * @param blog
     * @param redirectAttributes
     * @return
     * @throws Exception
     */
    @RequestMapping("/mymain")
    public String toMymain(HttpSession session,HttpServletRequest request,Model blog, RedirectAttributes redirectAttributes)throws Exception{
        try{
            List<Blog> blogList = Collections.emptyList();
            String uname = (String)request.getSession().getAttribute("uname");
            blogList = blogService.queryByUname(uname);
            blog.addAttribute("blogList",blogList);
            User user = userService.queryByName(uname);
            check(request);
            return "mymain";
        }catch (SSException e)
        {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }

    }

    /**
     * 根据标签查找我的博客
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
            String uname = (String)request.getSession().getAttribute("uname");
            System.out.println(uname);
            List<Blog> blog = blogService.queryByUnameAndBlable(uname,blable);
            model.addAttribute("blogList",blog);
            check(request);
            return "mymain";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 页面样式的函数
     * @param request
     * @throws SSException
     */
    public void check(HttpServletRequest request)throws SSException
    {
        String uname = (String)request.getSession().getAttribute("uname");
        System.out.println(uname);
        if(uname==null)
        {
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

            }else if(user.getIsadmin()==0){
                request.setAttribute("anone", "none");//登录注册
                request.setAttribute("pnone", "none");//超级管理员
                request.setAttribute("p1none", "none");//管理员
                request.setAttribute("ymsg", "none");//用户管理
            }
        }
    }
}

