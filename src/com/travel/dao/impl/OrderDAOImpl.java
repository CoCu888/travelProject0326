package com.travel.dao.impl;

import com.travel.dao.IOrderDao;
import com.travel.domain.Order_table;

import java.util.List;

public class OrderDAOImpl extends BasicDAO implements IOrderDao {
    @Override
    public boolean insertGoodOrder(Integer order_ower,Integer order_from, String order_name, Double order_price, String order_introduce) throws Exception {
        String sql = "insert into order_table(order_ower,order_from,order_name,order_price,order_introduce,order_time) VALUES(?,?,?,?,?,NOW())";
        int update = update(sql, order_ower,order_from,order_name, order_price, order_introduce);
        return update==1;
    }

    @Override
    public List<Order_table> getUserOrderList(Integer order_ower) {
        String sql = "select * from order_table where order_ower = ? and order_isdel = 0";
        List list = queryMulti(sql, Order_table.class, order_ower);
        return list;
    }

    @Override
    public boolean delOrder(Integer order_id) {
        String sql = "update order_table SET order_isdel = 1 where order_id = ? and order_isdel = 0";
        int update = update(sql, order_id);
        return update == 1;
    }
}
