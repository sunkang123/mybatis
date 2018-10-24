package com.mybatis.project.dao;

import com.mybatis.project.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.net.SocketTimeoutException;

import static org.junit.Assert.*;

public class UserDaoImplTest {


    private SqlSessionFactory sqlSessionFactory ;
    @Before
    public void setUp() throws Exception {
        //创建sqlsessionFactory
        String resource = "SqlMapConfig.xml";
        //得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //创建会话工厂，传入mybatis的配置文件的信息
         sqlSessionFactory  = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void findUserById() throws Exception {
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);

        //调用userDao的方法
        User user  = userDao.findUserById(1);
        System.out.println(user);
    }

    @Test
    public void insertUser() {
    }

    @Test
    public void deleteUser() {
    }
}