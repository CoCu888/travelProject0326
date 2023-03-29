package com.travel.dao;

import com.travel.domain.Goods_table;

import java.util.List;

/**
 * @author 李杨
 * @version 1.0
 * @date 2023/3/20
 * @introduction
 */
public interface IGoodsDAO {

    // 查询店铺下的商品，商品isdel不是1！！！
    List<Goods_table> getStoreGoodsList(Integer goodsOwner) throws Exception;

    // 通过名称查询商品，使用模糊查询，商品isdel不是1！！！
    List<Goods_table> getGoodsByName(String goodsName) throws Exception;

    //查询商品，防止重复插入
    boolean findGoods(Integer goods_owner,String goods_name,Double goods_price,String goods_introduce);

    // 新建商品
    boolean InsertGoodsToStore(Integer goodsOwner, String goodsName,
                               Double goodsPrice, String goodsIntroduce) throws Exception;

    // 修改价格
    boolean updateGoodsPrice(Integer goodsId, Double newPrice) throws Exception;

    // 修改商品介绍
    boolean updateGoodsIntroduce(Integer goodsId, String introduce) throws Exception;

    // 修改商品名称
    boolean updateGoodsName(Integer goodsId, String name) throws Exception;

    // 删除商品，假删除，将isdel属性设为1即可
    boolean deleteGoods(Integer goodsId) throws Exception;

}
