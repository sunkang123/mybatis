package com.mybatis.project.po;

import java.util.Date;
import java.util.List;

/**
 * @Project: mybatis
 * @description:  订单类
 * @author: sunkang
 * @create: 2018-10-07 20:21
 * @ModificationHistory who      when       What
 **/
public class Orders {

    private Integer id;

    private Integer userId;

    private  String number;

    private Date createTime;

    private String note;

    //用户信息
    private User user;

    //订单详情
    List<OrderDetail>  orderDetails;

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


}
