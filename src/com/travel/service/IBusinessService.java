package com.travel.service;

import com.travel.domain.Business_table;
import com.travel.domain.Store_table;
import com.travel.domain.User_table;

import java.util.List;

/**
 * @author 李杨
 * @version 1.0
 * @date 2023/3/20
 * @introduction
 */
public interface IBusinessService {

    // 账号注册，需要验证手机号是否已经注册，验证填入信息是否合法
    boolean regBusiness(String phoneNum, String userName, String pwd) throws Exception;

    // 账号登录，需要验证是否登录成功，调用DAO的方法，返回空时说明登录失败
    boolean login(String phoneNum, String pwd) throws Exception;

    Business_table getBusiness(String phoneNum, String pwd) throws Exception;

    // 修改用户基础信息，修改用户名，用户邮箱，用户城市的通用方法，
    /**
     * @param type 要修改信息的类型，用作判断，不同类型调用不同DAO
     * @param id 用户自己的id
     * @param newInfo 修改的值
     */
    boolean updateBusiness(String type, Integer id, String newInfo) throws Exception;

    // 查询旗下店铺
    List<Store_table> getMyStore(Integer storeOwner) throws Exception;

    // 添加店铺
    boolean createStore(Integer storeOwner, String storeCity, String storeName, String storeType, String storeAddress,
                        String storeIntroduce) throws Exception;

    // 删除店铺，需要查询当前店铺是否还有商品，如果有则返回还有商品未删除，没有的话才能删除
    String delStore(Integer storeId) throws Exception;

    // 修改店铺信息，修改店铺名称，修改店铺介绍
    /**
     * @param type 要修改信息的类型，用作判断，不同类型调用不同DAO
     * @param storeId 店铺id
     * @param newInfo 修改的值
     */
    boolean updateStore(String type, Integer storeId, String newInfo) throws Exception;

    // 账号注销
    boolean delAccount(Integer id) throws Exception;

}