package com.travel.service;

/**
 * @author 李杨
 * @version 1.0
 * @date 2023/3/20
 * @introduction
 */
public interface IStoreService {

    // 添加商品
    boolean insertGoods(Integer goodsOwner, String goodsName,
                        Double goodsPrice, String goodsIntroduce) throws Exception;

    // 修改价格
    boolean updateGoodsPrice(Integer goodsId, Double newPrice) throws Exception;

    // 修改商品介绍
    boolean updateGoodsIntroduce(Integer goodsId, String introduce) throws Exception;

    // 修改商品名称
    boolean updateGoodsName(Integer goodsId, String name) throws Exception;

    // 删除商品
    boolean deleteGoods(Integer goodsId) throws Exception;
}
