package com.travel.dao;

import com.travel.domain.Order_table;

import java.util.List;

public interface IOrderDao {

    //创建订单
    boolean insertGoodOrder(Integer order_ower,Integer order_from,String order_name,Double order_price,String order_introduce) throws Exception;

    //查找订单
    List<Order_table> getUserOrderList(Integer order_ower);

    //删除订单
    boolean delOrder(Integer order_id);
}
