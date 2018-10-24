package com.mybatis.project.po;

import java.util.List;

/**
 * @Project: mybatis
 * @description:  用户包装类型
 * @author: sunkang
 * @create: 2018-10-07 17:01
 * @ModificationHistory who      when       What
 **/
public class UserQueryVo {

    //在这里包装所需要的查询条件


    //传入多个id
    private List<Integer> ids;

    //用户查询条件
    private UserCustom userCustom;


    //可以包装其他的查询条件，订单、商品


    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }


    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
