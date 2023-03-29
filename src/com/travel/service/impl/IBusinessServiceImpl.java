package com.travel.service.impl;

import com.travel.dao.impl.BusinessDAOImpl;
import com.travel.dao.impl.GoodsDAOImpl;
import com.travel.dao.impl.StoreDAOImpl;
import com.travel.domain.Business_table;
import com.travel.domain.Goods_table;
import com.travel.domain.Store_table;
import com.travel.domain.User_table;
import com.travel.service.IBusinessService;

import java.util.List;

public class IBusinessServiceImpl implements IBusinessService {
    private BusinessDAOImpl businessDAO = new BusinessDAOImpl();
    private StoreDAOImpl storeDAO = new StoreDAOImpl();
    private GoodsDAOImpl goodsDAO = new GoodsDAOImpl();

    @Override
    public boolean regBusiness(String phoneNum, String userName, String pwd) throws Exception {
        boolean b = businessDAO.checkPhoneNum(phoneNum);
        if (!b){
            boolean b1 = businessDAO.insertBusiness(phoneNum,userName,pwd);
            if (b1){
                System.out.println("插入数据成功");
                return true;
            }else {
                System.out.println("插入数据失败");
                return false;
            }
        }else {
            System.out.println("用户已存在，注册失败");
            return false;
        }
    }

    @Override
    public boolean login(String phoneNum, String pwd) throws Exception {
        Business_table business = businessDAO.getBusiness(phoneNum, pwd);
        System.out.println(business);
        if (business == null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public Business_table getBusiness(String phoneNum, String pwd) throws Exception{
        Business_table business = businessDAO.getBusiness(phoneNum, pwd);
        return business;
    }

    @Override
    public boolean updateBusiness(String type, Integer id, String newInfo) throws Exception {
        if (type.equals("business_phonenum")){
            boolean b = businessDAO.checkPhoneNum(newInfo);
            if (!b){
                return businessDAO.updatePhoneNum(id,newInfo);
            }else {
                return false;
            }
        }else if (type.equals("business_name")){
            return businessDAO.updateName(id,newInfo);
        }else if (type.equals("business_pwd")){
            return businessDAO.updatePwd(id,newInfo);
        }else if (type.equals("business_email")){
            boolean b = businessDAO.checkEmail(newInfo);
            if (!b){
                return businessDAO.updateEmail(id,newInfo);
            }else {
                return false;
            }
        }else {
            System.out.println("传入类型错误");
        }
        return false;
    }

    @Override
    public List<Store_table> getMyStore(Integer storeOwner) throws Exception {
        List<Store_table> businessStoreList = storeDAO.getBusinessStoreList(storeOwner);
        return businessStoreList;
    }

    @Override
    public boolean createStore(Integer storeOwner, String storeCity, String storeName, String storeType, String storeAddress, String storeIntroduce) throws Exception {
        boolean store1 = storeDAO.findStore(storeOwner, storeCity, storeName, storeType, storeAddress);
        if (!store1){
            boolean store = storeDAO.createStore(storeOwner, storeCity, storeName, storeType, storeAddress, storeIntroduce);
            return store;
        }else {
            return false;
        }
    }

    //接口要求：先查询该店铺是否还有商品，还有商品则需先将商品删除
    @Override
    public String delStore(Integer storeId) throws Exception {
        List<Goods_table> storeGoodsList = goodsDAO.getStoreGoodsList(storeId);
        if (storeGoodsList.size() != 0){
            return "您的店铺还有商品上架，请将您店铺商品的先下架";
        }else {
            Object store = storeDAO.getStore(storeId);
            if (store.equals("0")){
                boolean b = storeDAO.delStore(storeId);
                return b?"删除成功":"删除失败";
            }else {
                return "商品不存在";
            }
        }
    }

    @Override
    public boolean updateStore(String type, Integer storeId, String newInfo) throws Exception {
        if (type.equals("store_name")){
            return storeDAO.updateStoreName(storeId,newInfo);
        }else if (type.equals("store_introduce")){
            return storeDAO.updateStoreIntroduce(storeId,newInfo);
        }else {
            System.out.println("传入类型异常");
            return false;
        }
    }

    @Override
    public boolean delAccount(Integer id) throws Exception {

        List<Store_table> storeList = storeDAO.getBusinessStoreList(id);
        if (storeList.size() != 0){
            return false;
        }else {
            boolean b = businessDAO.delAccount(id);
            return b;
        }

    }
    public String getPwd(String pwd) throws Exception{
        return businessDAO.getPwd(pwd);
    }
}
