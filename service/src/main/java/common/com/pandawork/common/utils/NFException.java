package com.pandawork.common.utils;

import com.pandawork.core.common.exception.IBizExceptionMes;

/**
 * NFException
 *
 * @author: zhangteng
 * @time: 2015/3/24 16:55
 */
public enum  NFException implements IBizExceptionMes {
    SystemException("系统内部异常", 1),

    UserNameNotNull("用户名不能为空", 10001),
    PasswordNotNull("密码不能为空", 10002),
    ListStudentAll("获取学生列表失败",10003),
    CountAll("获取学生信息数目失败",10004 ),
    StudentNameNotNull("获取学生姓名为空",10005 ),
    StudentNumLessOrEqualZero("学生学号小于零",10006 ),
    SexNotNull( "获取学生性别为空",10007),
    GradeLessOrEqualZero("获取学生年级小于零",10008),
    ClassNumLessOrEqualZero("获取学生年级小于零",10009),
    CollegeNotNull("获取学生学院为空",10010),
    BirthdayNotNull("获取学生生日为空",10011),
    GoodStudentNotNull("获取是否为好学生为空",10012),
    DelStudentNull("删除学生信息失败",10013),
    UpdateStudentFailed("更新学生信息失败",10014),
    UpdateStudentByIdFailed("按照id查询学生信息失败",10016),
    QueryByNameFailed("按照姓名查询学生信息失败",10017 ),

    queryStudentByIdFailed("", 10018),
    UnameNotNull("用户名不能为空",10019),
    UpwdNotNull("密码不能为空",10020),
    DelUserNull("删除用户信息失败",10021),
    UpdateUserFailed("更新用户信息失败",10022),
    ListUserAll("获取用户列表失败",10023),
    CountUserAll("获取用户数目失败",10024),
    QueryUserByIdFailed("根据id查找用户信息失败",10025),
    QueryUserByNameFailed("根据姓名查找用户信息失败",10026),
    BlogNameNull("博客名字为空",10027),
    BlogLableNull("博客标签 为空",10028),
    BlogContextNull("博客内容为空",10029),
    DelBlogNull("博客删除失败",10030),
    UpdateBlogFailed("博客更新失败",10031)

    ;

    private String msg;

    private Integer code;

    NFException(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
    }


    @Override
    public String getMes() {
        return null;
    }

    @Override
    public int getCode() {
        return 0;
    }
}
