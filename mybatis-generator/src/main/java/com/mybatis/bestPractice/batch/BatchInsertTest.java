package com.mybatis.bestPractice.batch;

import com.mybatis.project.mapper.UserMapper;
import com.mybatis.project.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Project: mybatis
 * @description: 批量更新
 * @author: sunkang
 * @create: 2018-10-28 17:38
 * @ModificationHistory who      when       What
 **/
public class BatchInsertTest {

    private final static Logger log = LoggerFactory.getLogger(BatchInsertTest.class);

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


    /**
     * 方式一： for 循环 一个一个插入
     * @throws Exception
     */
    @Test
    public void batchInsertTest() throws  Exception{
        long start = System.currentTimeMillis();
        SqlSession sqlSession  =sqlSessionFactory.openSession();
        //创建userMapper对象,mybatis自动生成mapper代理对象
         UserMapper userMapper =  sqlSession.getMapper(UserMapper.class);
        for (int i = 0; i < 100; i++) {
            User  user= new User();
            user.setSex("男");
            user.setUsername("sun");
            user.setAddress("address");
            userMapper.insert(user);
        }
        sqlSession.commit();
        log.info("cost {}ms", System.currentTimeMillis() - start);
        //输出日志如下： INFO [main] - cost 1928ms
    }


    //方式二： 拼装insert 的SQL语句，进行批量插入 ,这种方式的速度最快，推荐这种
    @Test
    public void insertBatchByConnSql() {
        long start = System.currentTimeMillis();
        SqlSession sqlSession  =sqlSessionFactory.openSession();
        //创建userMapper对象,mybatis自动生成mapper代理对象
         UserMapper userMapper =  sqlSession.getMapper(UserMapper.class);
         List<User> userList = new ArrayList<User>();
        for (int i = 0; i < 100; i++) {
            User  user= new User();
            user.setSex("男");
            user.setUsername("sun");
            user.setAddress("address");
            userList.add(user);
        }
        userMapper.insertBatch(userList);
        sqlSession.commit();
        log.info("cost {}ms", System.currentTimeMillis() - start);
        // INFO [main] - cost 1610ms
    }

    //方式三： 执行批量插入，10个一插入
    @Test
    public void insertBatchByConnectSql() {
        long start = System.currentTimeMillis();
        SqlSession sqlSession  =sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        //创建userMapper对象,mybatis自动生成mapper代理对象
        UserMapper userMapper =  sqlSession.getMapper(UserMapper.class);
        List<User> userList = new ArrayList<User>();
        for (int i = 0; i < 100; i++) {
            User  user= new User();
            user.setSex("男");
            user.setUsername("sun");
            user.setAddress("address");
            userMapper.insert(user);
            if (i % 10 == 0 && i != 0) {
                sqlSession.commit();
                sqlSession.clearCache();
            }
        }
        log.info("cost {}ms", System.currentTimeMillis() - start);
        //输出日志如下：INFO [main] - cost 1673ms
    }

}
