package com.mybatis.project.dao;

import com.mybatis.project.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.Date;
import java.util.List;

/**
 * @Project: mybatis
 * @description:  userDao的实现类
 * @author: sunkang
 * @create: 2018-10-07 15:10
 * @ModificationHistory who      when       What
 **/
public class UserDaoImpl  implements UserDao {

    //需要向dao实现类中注入SqlSessionFactory
    //这里通过构造注入
   private SqlSessionFactory sqlSessionFactory;
   public  UserDaoImpl(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
   }

    @Override
    public User findUserById(int id ) throws Exception {
        SqlSession  sqlSession = sqlSessionFactory.openSession();
        User user =    sqlSession.selectOne("test.findUserById",id);
        //释放资源
        sqlSession.close();
        return user;
    }

    @Override
    public List<User> findUserByName(String name) throws Exception {
        SqlSession  sqlSession = sqlSessionFactory.openSession();
        List<User> list =    sqlSession.selectList("test.findUserByName",name);
        //释放资源
        sqlSession.close();
        return list;
    }


    @Override
    public void insertUser(User user) throws Exception {
        SqlSession  sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("test.insertUser",user);
        //提交事务
        sqlSession.commit();
        sqlSession.close();

    }

    @Override
    public void deleteUser(int id) throws Exception {
        SqlSession  sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("test.deleteUser",id);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }




}
