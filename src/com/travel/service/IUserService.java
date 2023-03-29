package com.travel.service;

import com.travel.domain.Goods_table;
import com.travel.domain.Order_table;
import com.travel.domain.Store_table;
import com.travel.domain.User_table;


import java.util.List;

/**
 * @author 李杨
 * @version 1.0
 * @date 2023/3/20
 * @introduction
 */
public interface IUserService {

    // 账号注册，需要验证手机号是否已经注册，验证填入信息是否合法
    boolean regUser(String phoneNum, String userName, String pwd, String city) throws Exception;

    // 账号登录，需要验证是否登录成功，调用DAO的方法，返回空时说明登录失败
    boolean login(String phoneNum, String pwd) throws Exception;

    User_table getUser(String phoneNum, String pwd) throws Exception;

    // 通过城市和类型搜索店铺
    List<Store_table> getStoreByType(String city, String storeType) throws Exception;

    // 通过城市和名称搜索店铺
    List<Store_table> getStoreByName(String city, String storeName) throws Exception;

    // 通过城市和名称查询商品
    List<Goods_table> getGoodsByName(String city, String goodsName) throws Exception;
    
    // 修改用户基础信息，修改用户名，用户邮箱，用户城市的通用方法，
    /**
     * @param type 要修改信息的类型，用作判断，不同类型调用不同DAO
     * @param id 用户自己的id
     * @param newInfo 修改的值
     */
    boolean updateUser(String type, Integer id, String newInfo) throws Exception;

    // 账号注销
    boolean delAccount(Integer id) throws Exception;

    //添加订单
    boolean insertOrder(Integer order_ower,Integer order_from,String order_name,Double order_price,String order_introduce) throws Exception;

    //获取订单
    List<Order_table> getOrderList(Integer order_ower) throws Exception;

    boolean delOrder(Integer order_id) throws Exception;
}
