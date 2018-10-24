package com.mybatis.project.mapper;

import com.mybatis.project.po.Orders;
import com.mybatis.project.po.OrdersCustom;
import com.mybatis.project.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.core.config.Order;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class OrdersMapperCustomTest {

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
    public void findOrdersUser() throws Exception {
      SqlSession sqlSession =  sqlSessionFactory.openSession();
        OrdersMapperCustom ordersMapperCustom  =  sqlSession.getMapper(OrdersMapperCustom.class);
        //调用mapper的方法
        List<OrdersCustom> list = ordersMapperCustom.findOrdersUser();
        System.out.println(list);
        sqlSession.close();
    }

    @Test
    public void findOrdersUserResultMap() throws Exception {
        SqlSession sqlSession =  sqlSessionFactory.openSession();
        OrdersMapperCustom ordersMapperCustom  =  sqlSession.getMapper(OrdersMapperCustom.class);
        //调用mapper的方法
        List<Orders> list = ordersMapperCustom.findOrdersUserResultMap();
        System.out.println(list);
        sqlSession.close();
    }

    @Test
    public void findOrdersAndOrderDetailResultMap() throws Exception {
        SqlSession sqlSession =  sqlSessionFactory.openSession();
        OrdersMapperCustom ordersMapperCustom  =  sqlSession.getMapper(OrdersMapperCustom.class);
        //调用mapper的方法
        List<Orders> list = ordersMapperCustom.findOrdersAndOrderDetailResultMap();
        System.out.println(list);
        sqlSession.close();
    }


    @Test
    public void findUserAndItemsResultMap() throws Exception {
        SqlSession sqlSession =  sqlSessionFactory.openSession();
        OrdersMapperCustom ordersMapperCustom  =  sqlSession.getMapper(OrdersMapperCustom.class);
        //调用mapper的方法
        List<User> list = ordersMapperCustom.findUserAndItemsResultMap();
        System.out.println(list);
        sqlSession.close();
    }

    //查询订单关联查询用户，用户信息是延迟加载
    @Test
    public void findOrderUserLazyLoading() throws Exception {
        SqlSession sqlSession =  sqlSessionFactory.openSession();
        OrdersMapperCustom ordersMapperCustom  =  sqlSession.getMapper(OrdersMapperCustom.class);
        //调用mapper的方法
        List<Orders> list = ordersMapperCustom.findOrderUserLazyLoading();
        for(Orders orders : list){
            //执行getUser()去查询用户信息，这里实现了按需加载
            User user = orders.getUser();
            System.out.println(user);
        }
        sqlSession.close();
    }

    //测试一级缓存 （sqlsession 级别的缓存，缓存在sqlsession ）
    @Test
    public void testCach1() throws Exception {
        SqlSession sqlSession =  sqlSessionFactory.openSession();
        UserMapper userMapper  =  sqlSession.getMapper(UserMapper.class);
        //调用mapper的方法
        //第一次发起请求
        User user1 = userMapper.findUserById(1);
        System.out.println(user1);

        //如果这里更新user1,并commit，会清空一级缓存

        //第二次发起请求
        User user2 = userMapper.findUserById(1);
        System.out.println(user2);
        sqlSession.close();
    }


    //测试二级缓存 （缓存在mapper的namesapce ,跨sqlsession ）
    @Test
    public void testCach2() throws Exception {
        SqlSession sqlSession1 =  sqlSessionFactory.openSession();
        SqlSession sqlSession2 =  sqlSessionFactory.openSession();
        SqlSession sqlSession3 =  sqlSessionFactory.openSession();
        UserMapper userMapper1  =  sqlSession1.getMapper(UserMapper.class);
        //调用mapper的方法
        //第一次发起请求
        User user1 = userMapper1.findUserById(1);
        System.out.println(user1);
        //这里执行关闭操作，将sqlsession 中的数据写到二级缓存中
        sqlSession1.close();

        //使用sqlSession3执行修改数据commit会清空UserMapper的二级缓存

        //可以在指定statement 设置是否使用二级缓存  userCash  或者是否刷新缓存  flushCash


        UserMapper userMapper2  =  sqlSession2.getMapper(UserMapper.class);
        //第二次发起请求
        User user2 = userMapper2.findUserById(1);
        System.out.println(user2);
        sqlSession2.close();

    }


}