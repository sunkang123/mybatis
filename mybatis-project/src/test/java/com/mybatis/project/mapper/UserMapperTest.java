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

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserMapperTest {

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
        SqlSession sqlSession  =sqlSessionFactory.openSession();
        //创建userMapper对象,mybatis自动生成mapper代理对象
        UserMapper userMapper =  sqlSession.getMapper(UserMapper.class);
        //调用userMapper方法
        User user = userMapper.findUserById(1);
        System.out.println(user);
    }

    //测试resultMap的测试
    @Test
    public void findUserByIdResultMap() throws Exception {
        SqlSession  sqlSession  =sqlSessionFactory.openSession();
        //创建userMapper对象,mybatis自动生成mapper代理对象
        UserMapper userMapper =  sqlSession.getMapper(UserMapper.class);
        //调用userMapper方法
        User user = userMapper.findUserByIdResultMap(1);
        System.out.println(user);
    }

    @Test
    public void findUserList() throws Exception {
        SqlSession  sqlSession  =sqlSessionFactory.openSession();
        //创建userMapper对象,mybatis自动生成mapper代理对象
        UserMapper userMapper =  sqlSession.getMapper(UserMapper.class);
        //创建包装对象，设置查询条件
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom  userCustom = new UserCustom();
        userCustom.setSex("1");
        userCustom.setUsername("王五");
        //传入多个id
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        userQueryVo.setIds(ids) ;
        userQueryVo.setUserCustom(userCustom);
        //调用userMapper方法
        List<UserCustom>  list = userMapper.findUserList(userQueryVo);
        System.out.println(list);
    }

    @Test
    public void findUserCount() throws Exception {

        SqlSession  sqlSession  =sqlSessionFactory.openSession();
        //创建userMapper对象,mybatis自动生成mapper代理对象
        UserMapper userMapper =  sqlSession.getMapper(UserMapper.class);
        //创建包装对象，设置查询条件
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom  userCustom = new UserCustom();
        userCustom.setSex("1");
        userCustom.setUsername("王五");
        userQueryVo.setUserCustom(userCustom);
        //调用userMapper方法
        int count= userMapper.findUserCount(userQueryVo);
        System.out.println(count);
    }

    @Test
    public void findUserByName() throws Exception {

        SqlSession  sqlSession  =sqlSessionFactory.openSession();
        //创建userMapper对象,mybatis自动生成mapper代理对象
        UserMapper userMapper =  sqlSession.getMapper(UserMapper.class);
        //调用userMapper方法
        List<User> list = userMapper.findUserByName("王五");
        System.out.println(list);
    }


}