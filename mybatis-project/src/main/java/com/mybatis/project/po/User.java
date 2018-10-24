package com.mybatis.project.po;

import org.apache.logging.log4j.core.config.Order;

import javax.naming.directory.SearchResult;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Project: mybatis
 * @description:
 * @author: sunkang
 * @create: 2018-10-07 12:44
 * @ModificationHistory who      when       What
 **/
public class User  implements Serializable {

        private int id;
        private String username;// 用户姓名
        private String sex;// 性别
        private Date birthday;// 生日
        private String address;// 地址

    //用户创建的订单列表
    private List<Orders> orderList;

    public List<Orders> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Orders> orderList) {
        this.orderList = orderList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                '}';
    }
}
