package com.travel.dao.impl;

import com.travel.dao.IGoodsDAO;
import com.travel.domain.Goods_table;

import java.util.List;

public class GoodsDAOImpl extends BasicDAO implements IGoodsDAO {

    @Override
    public List<Goods_table> getStoreGoodsList(Integer goodsOwner) {
        String sql = "select * from goods_table where goods_owner = ? and goods_isdel = 0";
        List list = queryMulti(sql,Goods_table.class,goodsOwner);
        return list;
    }

    @Override
    public List<Goods_table> getGoodsByName(String goodsName) {
        String sql = "select * from goods_table where goods_name like ? and goods_isdel = 0";
        List list = queryMulti(sql,Goods_table.class,"%"+goodsName+"%");
        return list;
    }

    @Override
    public boolean findGoods(Integer goods_owner, String goods_name, Double goods_price, String goods_introduce) {
        String sql = "select * from goods_table where goods_owner = ? and" +
                " goods_name = ? and goods_price = ? and goods_introduce = ?";
        Object o = querySingle(sql, Goods_table.class, goods_owner, goods_name, goods_price, goods_introduce);
        if (o != null){
            return true;
        }
        return false;
    }

    @Override
    public boolean InsertGoodsToStore(Integer goodsOwner, String goodsName, Double goodsPrice, String goodsIntroduce) {
        String sql = "INSERT INTO goods_table (goods_owner,goods_name,goods_price,goods_introduce) VALUES(?,?,?,?)";
        int update = update(sql, goodsOwner, goodsName, goodsPrice, goodsIntroduce);
        return update==1;
    }

    @Override
    public boolean deleteGoods(Integer goodsId) {
        String sql = "update goods_table set goods_isdel = 1 where goods_id = ? and goods_isdel = 0";
        int update = update(sql, goodsId);
        return update==1;
    }

    @Override
    public boolean updateGoodsPrice(Integer goodsId, Double newPrice) {
        String sql = "update goods_table set goods_price = ? where goods_id = ?";
        int update = update(sql,newPrice,goodsId);
        return update==1;
    }

    @Override
    public boolean updateGoodsIntroduce(Integer goodsId, String introduce) throws Exception {
        String sql = "update goods_table set goods_introduce = ? where goods_id = ?";
        int update = update(sql,introduce,goodsId);
        return update==1;
    }

    @Override
    public boolean updateGoodsName(Integer goodsId, String name) {
        String sql = "update goods_table set goods_name = ? where goods_id = ?";
        int update = update(sql,name,goodsId);
        return update == 1;
    }
}
