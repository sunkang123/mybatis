package com.mybatis.project.po;

/**
 * @Project: mybatis
 * @description:
 * @author: sunkang
 * @create: 2018-10-07 22:04
 * @ModificationHistory who      when       What
 **/
public class OrderDetail {

    private  Integer id;

    private  Integer ordersId;

    private  Integer itemsId;

    private  Integer itemsNum;

    //明细对应的商品信息
    private  Items items;

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Integer ordersId) {
        this.ordersId = ordersId;
    }

    public Integer getItemsId() {
        return itemsId;
    }

    public void setItemsId(Integer itemsId) {
        this.itemsId = itemsId;
    }

    public Integer getItemsNum() {
        return itemsNum;
    }

    public void setItemsNum(Integer itemsNum) {
        this.itemsNum = itemsNum;
    }
}
