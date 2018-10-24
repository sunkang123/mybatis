package com.mybatis.project.dao;

import com.mybatis.project.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;

/**
 * 与sprig 整合之后的测试
 */
public class UserDaoImplSpringTest {

    private ApplicationContext applicationContext;


    @Before
    public void setUp() throws Exception {
        applicationContext =new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
    }

    @Test
    public void findUserById() throws Exception {

        UserDao  userDao = applicationContext.getBean("userDao",UserDao.class);

        //调用userDao的方法
        User user  = userDao.findUserById(1);
        System.out.println(user);
    }

}