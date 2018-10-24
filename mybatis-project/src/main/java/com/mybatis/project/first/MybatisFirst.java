package com.mybatis.project.first;

import com.mybatis.project.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @Project: mybatis
 * @description:
 * @author: sunkang
 * @create: 2018-10-07 12:49
 * @ModificationHistory who      when       What
 **/
public class MybatisFirst {


    //根据id查询用户信息
    @Test
    public void findUserById() throws IOException {
        String resource = "SqlMapConfig.xml";
        //得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建会话工厂，传入mybatis的配置文件的信息
        SqlSessionFactory sqlSessionFactory  = new  SqlSessionFactoryBuilder().build(inputStream);
        //通过工厂得到Sqlsession
        SqlSession  sqlSession  = sqlSessionFactory.openSession();

        //通过sqlssion来操作数据库
        // 第一个参数： 映射文件的statement的id,等价于namespace + .+ statement的id
        //第二个参数： 指定和映射文件所匹配的parameterType类型 的参数
        User user = sqlSession.selectOne("test.findUserById",1);

        System.out.println(user);

        //释放资源
        sqlSession.close();
    }

    //根据用户名称模糊查询用户列表
    @Test
    public void findUserByNameTest() throws IOException {

        String resource = "SqlMapConfig.xml";
        //得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //创建会话工厂，传入mybatis的配置文件的信息
        SqlSessionFactory sqlSessionFactory  = new  SqlSessionFactoryBuilder().build(inputStream);

        //通过工厂得到Sqlsession
        SqlSession  sqlSession  = sqlSessionFactory.openSession();

        //通过sqlssion来操作数据库
        // 第一个参数： 映射文件的statement的id,等价于namespace + .+ statement的id
        //第二个参数： 指定和映射文件所匹配的parameterType类型 的参数
        List<User> list = sqlSession.selectList("test.findUserByName","王五");
        System.out.println(list);
        //释放资源
        sqlSession.close();

    }

    //添加用户信息
    @Test
    public void insertUserTest() throws IOException {

        String resource = "SqlMapConfig.xml";
        //得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //创建会话工厂，传入mybatis的配置文件的信息
        SqlSessionFactory sqlSessionFactory  = new  SqlSessionFactoryBuilder().build(inputStream);

        //通过工厂得到Sqlsession
        SqlSession  sqlSession  = sqlSessionFactory.openSession();

        //通过sqlssion来操作数据库
        User user =new User();
        user.setUsername("sunkang");
        user.setBirthday(new Date());
        user.setSex("1");
        user.setAddress("湖北咸宁");
        sqlSession.insert("test.insertUser",user);

        //提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }

    //根据用户id删除用户信息
    @Test
    public void deleteUserTest() throws IOException {
        String resource = "SqlMapConfig.xml";
        //得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建会话工厂，传入mybatis的配置文件的信息
        SqlSessionFactory sqlSessionFactory  = new  SqlSessionFactoryBuilder().build(inputStream);
        //通过工厂得到Sqlsession
        SqlSession  sqlSession  = sqlSessionFactory.openSession();
        //通过sqlssion来操作数据库
        sqlSession.delete("test.deleteUser",4);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }


    //更新用户
    @Test
    public void updateUserTest() throws IOException {
        String resource = "SqlMapConfig.xml";
        //得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //创建会话工厂，传入mybatis的配置文件的信息
        SqlSessionFactory sqlSessionFactory  = new  SqlSessionFactoryBuilder().build(inputStream);

        //通过工厂得到Sqlsession
        SqlSession  sqlSession  = sqlSessionFactory.openSession();
        //更新用户的信息
        User user =new User();
        user.setId(3);
        user.setUsername("wangzhezhi");
        user.setBirthday(new Date());
        user.setSex("3");
        user.setAddress("温州");
        //通过sqlssion来操作数据库
        sqlSession.update("test.updateUser",user);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }


}
