package com.travel.service.impl;

import com.travel.dao.impl.GoodsDAOImpl;
import com.travel.service.IStoreService;

public class IStoreServiceImpl implements IStoreService {
    private GoodsDAOImpl goodsDAO = new GoodsDAOImpl();

    @Override
    public boolean insertGoods(Integer goodsOwner, String goodsName, Double goodsPrice, String goodsIntroduce) throws Exception {
        boolean goods = goodsDAO.findGoods(goodsOwner, goodsName, goodsPrice, goodsIntroduce);
        if (!goods) {
            boolean b = goodsDAO.InsertGoodsToStore(goodsOwner, goodsName, goodsPrice, goodsIntroduce);
            return b;
        }
        return false;
    }

    @Override
    public boolean updateGoodsPrice(Integer goodsId, Double newPrice) throws Exception {
        boolean b = goodsDAO.updateGoodsPrice(goodsId,newPrice);
        return b;
    }

    @Override
    public boolean updateGoodsIntroduce(Integer goodsId, String introduce) throws Exception {
        boolean b = goodsDAO.updateGoodsIntroduce(goodsId, introduce);
        return b;
    }

    @Override
    public boolean updateGoodsName(Integer goodsId, String name) throws Exception {
        boolean b = goodsDAO.updateGoodsName(goodsId, name);
        return b;
    }

    @Override
    public boolean deleteGoods(Integer goodsId) throws Exception {
        boolean b = goodsDAO.deleteGoods(goodsId);
        return b;
    }
}
