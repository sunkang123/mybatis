package com.mybatis.project.mapper;


import com.sun.media.sound.SoftTuning;
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

public class ItemsMapperTest {

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

  /*  @Test
    public void selectByExample() {
        SqlSession sqlSession  = sqlSessionFactory.openSession();
        ItemsMapper itemsMapper =   sqlSession.getMapper(ItemsMapper.class);
        //ItemsExample 的作用就是动态创建查询条件，主要还是方便测试用的
        ItemsExample itemsExample = new ItemsExample();
        List<Integer> ids =new ArrayList<>();
        ids.add(1);
        ids.add(2);
        //添加条件，添加id的范围为1,2之间的
        itemsExample.createCriteria().andIdIn(ids);
        //添加条件为id <3的记录
        itemsExample.createCriteria().andIdGreaterThanOrEqualTo(3);
        List<Items>  items= itemsMapper.selectByExample(itemsExample);
        System.out.println(items);
    }*/

}