package com.mybatis.bestPractice.paging;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mybatis.project.mapper.UserMapper;
import com.mybatis.project.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * @Project: mybatis
 * @description:  分页插件演示
 * @author: sunkang
 * @create: 2018-10-28 16:13
 * @ModificationHistory who      when       What
 **/
public class UserPagingTest {

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
    public void testPaging() throws Exception {
        SqlSession sqlSession  =sqlSessionFactory.openSession();
        //创建userMapper对象,mybatis自动生成mapper代理对象
        final UserMapper userMapper =  sqlSession.getMapper(UserMapper.class);
        //方式一：use static method startPage
        PageHelper.startPage(1,2);
        //查询会进行分页
        List<User> userList  = userMapper.selectAll();
//        System.out.println(userList.get(0));

        //方式二： ISelect interface
        //startPage的pageNum为2，pageSize为2，说明从2页面开始查，也就是从第三条数据开始查
        PageInfo<User> page =PageHelper.startPage(2, 2).doSelectPageInfo(new ISelect() {
            public void doSelect() {
                userMapper.selectAll();
            }
        });
        System.out.println("total: "+ page.getTotal());
        System.out.println("pagesize:"+page.getPageSize());
        System.out.println("pageNum:"+page.getPageNum());
        for(User user: page.getList()){
            System.out.println(user);
        }
    }
}
