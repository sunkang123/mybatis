package com.mybatis.bestPractice.nested;

import com.mybatis.bestPractice.batch.BatchInsertTest;
import com.mybatis.project.mapper.UserMapper;
import com.mybatis.project.po.User;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.VoidType;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.List;

/**
 * @Project: mybatis
 * @description: 嵌套查询
 * @author: sunkang
 * @create: 2018-10-28 18:24
 * @ModificationHistory who      when       What
 **/
public class NestedQueryTest {

    private final static Logger log = LoggerFactory.getLogger(NestedQueryTest.class);

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


    //嵌套结果   一对多
    @Test
    public void nestedResultTest(){
        SqlSession sqlSession  =sqlSessionFactory.openSession();
        //创建userMapper对象,mybatis自动生成mapper代理对象
        UserMapper userMapper =  sqlSession.getMapper(UserMapper.class);

        List<User> list = userMapper.findOrdersByUser();

        System.out.println(list);
    }

    //嵌套结果查询 ，可以设置延迟加载，来达到延迟加载的效果
    @Test
    public void nestedQuery() throws InterruptedException {
        SqlSession sqlSession  =sqlSessionFactory.openSession();
        //创建userMapper对象,mybatis自动生成mapper代理对象
        UserMapper userMapper =  sqlSession.getMapper(UserMapper.class);

        //这里是1次
        List<User> list = userMapper.findOrdersByUserLazy();
        System.out.println(list.get(0).getBirthday());

        Thread.sleep(5000);
        System.out.println("----------");
        //当要使用的时候他们再去拉取数据 这里就是N次
        System.out.println(list.get(0).getOrderList().get(0).getId());
        System.out.println(list.get(1).getOrderList().get(0).getId());
        //1次 + N次问题
    }




}
