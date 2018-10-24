package com.mybatis.project.mapper;

import com.mybatis.project.po.Orders;
import com.mybatis.project.po.OrdersCustom;
import com.mybatis.project.po.User;

import java.util.List;

/**
 * @Project: mybatis
 * @description:  订单的mapper
 * @author: sunkang
 * @create: 2018-10-07 20:30
 * @ModificationHistory who      when       What
 **/
public interface OrdersMapperCustom {

    //查询订单关联查询用户信息
     List<OrdersCustom> findOrdersUser() throws  Exception;

    //查询订单关联查询用户信息使用resultMap
    List<Orders> findOrdersUserResultMap() throws  Exception;

    //查询订单（关联用户）及其订单明细
    List<Orders>  findOrdersAndOrderDetailResultMap() throws  Exception;

    //查询用户购买的商品信息
    List<User>  findUserAndItemsResultMap() throws  Exception;

    //查询订单关联查询用户，用户信息是延迟加载
    List<Orders>  findOrderUserLazyLoading() throws  Exception;
}
