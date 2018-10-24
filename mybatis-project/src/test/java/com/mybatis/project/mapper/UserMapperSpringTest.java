package com.mybatis.project.mapper;

import com.mybatis.project.dao.UserDao;
import com.mybatis.project.po.User;
import com.mybatis.project.po.UserCustom;
import com.mybatis.project.po.UserQueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 与spring进行继承测试
 */
public class UserMapperSpringTest {

    private ApplicationContext applicationContext;


    @Before
    public void setUp() throws Exception {
        applicationContext =new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
    }

    @Test
    public void findUserById() throws Exception {
        UserMapper userMapper = applicationContext.getBean("userMapper",UserMapper.class);
        //调用userDao的方法
        User user  = userMapper.findUserById(1);
        System.out.println(user);
    }


}