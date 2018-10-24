package com.mybatis.project.mapper;

import com.mybatis.project.po.User;
import com.mybatis.project.po.UserCustom;
import com.mybatis.project.po.UserQueryVo;

import java.util.List;

/**
 * @Project: mybatis
 * @description: userMapper接口
 * @author: sunkang
 * @create: 2018-10-07 15:07
 * @ModificationHistory who      when       What
 **/
public interface UserMapper {

    //用户信息的综合查询
    public  List<UserCustom> findUserList(UserQueryVo userQueryVo) throws  Exception;

    //用户信息的综合查询总数
    public  int findUserCount(UserQueryVo userQueryVo) throws  Exception;


    //通过resultMap 查询用户
    public User findUserByIdResultMap(int id) throws Exception;

    //根据id查询用户
    public User findUserById(int id) throws Exception;


    //通过用户名称查找用户
    public List<User> findUserByName(String name) throws  Exception;

    //添加用户信息

    public void insertUser(User user)  throws  Exception;

    //删除用户信心
    public void deleteUser(int id) throws  Exception;

}
