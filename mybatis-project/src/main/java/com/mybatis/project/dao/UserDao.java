package com.mybatis.project.dao;

import com.mybatis.project.po.User;

import java.io.IOException;
import java.util.List;

/**
 * @Project: mybatis
 * @description: dao接口
 * @author: sunkang
 * @create: 2018-10-07 15:07
 * @ModificationHistory who      when       What
 **/
public interface UserDao {

    //根据id查询用户
    public User findUserById(int id ) throws Exception;


    //通过用户名称查找用户
    public List<User> findUserByName(String name) throws  Exception;


    //添加用户信息

    public void insertUser(User user)  throws  Exception;

    //删除用户信心
    public void deleteUser(int  id) throws  Exception;

}
