package com.travel.dao;

import com.travel.domain.Goods_table;
import com.travel.domain.Store_table;

import java.util.List;

/**
 * @author 李杨
 * @version 1.0
 * @date 2023/3/19
 * @introduction
 */
public interface IStoreDAO {

    // 新建店铺
    boolean createStore(Integer storeOwner, String storeCity, String storeName, String storeType, String storeAddress,
                        String storeIntroduce) throws Exception;

    //查询店铺是否存在
    boolean findStore(Integer storeOwner, String storeCity, String storeName, String storeType, String storeAddress);

    //通过id进行查询单个店铺
    String getStore(Integer store_id);

    // 修改店铺名称，传参用于数据校验
    boolean updateStoreName(Integer storeId, String store_name) throws Exception;

    // 修改店铺介绍，传参用于数据校验
    boolean updateStoreIntroduce(Integer storeId, String storeIntroduce) throws Exception;

    // 查询某商户旗下店铺，isdel不是1！！！
    List<Store_table> getBusinessStoreList(Integer storeOwner) throws Exception;

    // 删除店铺，isdel设为1
    boolean delStore(Integer storeId) throws Exception;


    // 通过城市和店铺类型查询，isdel不是1！！！
    List<Store_table> getTypeStoreList(String city, String storeType) throws Exception;

    // 通过城市和店铺名字查询，isdel不是1！！！
    List<Store_table> getNameStoreList(String city, String storeName) throws Exception;

    //通过城市和商品名字查询
    List<Goods_table>  getNameStoreList2(String city, String goods_name) throws Exception;

}
