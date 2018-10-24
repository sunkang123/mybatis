package com.mybatis.project.dao;

import com.mybatis.project.po.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * @Project: mybatis
 * @description:  与spring 进行整合后的dao开发
 * @author: sunkang
 * @create: 2018-10-09 19:53
 * @ModificationHistory who      when       What
 **/
public class UserDaoimpl2 extends SqlSessionDaoSupport  implements UserDao{
    @Override
    public User findUserById(int id) throws Exception {
        //这里面继承了SqlSessionDaoSupport，通过 this.getSqlSession();得到sqlsession
        SqlSession sqlSession = this.getSqlSession();
        User user =    sqlSession.selectOne("test.findUserById",id);
        return user;
    }

    @Override
    public List<User> findUserByName(String name) throws Exception {
        return null;
    }

    @Override
    public void insertUser(User user) throws Exception {

    }

    @Override
    public void deleteUser(int id) throws Exception {

    }
}
