package com.mybatis.project.po;

/**
 * @Project: mybatis
 * @description: 订单的拓展类
 * @author: sunkang
 * @create: 2018-10-07 20:24
 * @ModificationHistory who      when       What
 **/
//通过此类映射订单和用户的查询结果，让此类继承较多的pojo 类
public class OrdersCustom extends  Orders {

    //添加用户的信息
    /**
     * user.username
     * user.sex
     * user.address
     */
    private String  username;
    private String  sex;
    private  String  address;

    public String toString() {
        return "OrdersCustom{" +
                "username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                "id=" + getId() +
                ", userId=" + getUserId() +
                ", number='" + getNumber() + '\'' +
                ", createTime=" + getCreateTime() +
                ", note='" + getNote() + '\'' +
                ", user=" + getUser() +
                '}';
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



}
