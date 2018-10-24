package com.mybatis.project.mapper;

import com.mybatis.project.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.beans.Transient;
import java.io.InputStream;

/**
 * @Project: mybatis
 * @description:
 * @author: sunkang
 * @create: 2018-10-10 14:10
 * @ModificationHistory who      when       What
 **/
public class ExampleTypeHandlerTest {

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

    //测试自己增加的typehandler的情况,插入的 时候，address字段的前面会增加 address:
    @Test
    public  void testHandler() throws Exception{
        SqlSession sqlSession  =sqlSessionFactory.openSession();
        //创建userMapper对象,mybatis自动生成mapper代理对象
        UserMapper userMapper =  sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("wangzhezhi");
        user.setAddress("hangzhoubingjiang");
        //调用userMapper方法
         userMapper.insertUser(user);
         sqlSession.commit();
        sqlSession.close();
    }
}
