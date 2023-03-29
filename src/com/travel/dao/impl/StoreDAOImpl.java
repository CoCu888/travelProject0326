package com.travel.dao.impl;

import com.travel.dao.IStoreDAO;
import com.travel.domain.Goods_table;
import com.travel.domain.Store_table;

import java.util.List;

/*
*  待修改:
*  storeIntroduce 不能为空
* */
public class StoreDAOImpl extends BasicDAO implements IStoreDAO {

    @Override
    public boolean createStore(Integer storeOwner, String storeCity, String storeName, String storeType, String storeAddress, String storeIntroduce) {
        String sql = "INSERT INTO store_table (store_owner,store_city ,store_name ,store_type ,store_address ,store_introduce) VALUES(?,?,?,?,?,?);";
        int update = update(sql, storeOwner, storeCity, storeName, storeType, storeAddress, storeIntroduce);
        return update == 1;
    }

    @Override
    public boolean findStore(Integer storeOwner, String storeCity, String storeName, String storeType, String storeAddress) {
        String sql = "select * from store_table where store_owner = ? and store_city = ? " +
                "and store_name = ? and store_type = ? and store_address = ?";
        Object o = querySingle(sql, Store_table.class, storeOwner, storeCity, storeName, storeType, storeAddress);
        if (o == null){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public String getStore(Integer store_id) {
        String sql = "select store_isdel from store_table where store_id = ? and store_isdel = 0";
        Object o = queryScalar(sql, store_id);
        if (o == null){
            return "空";
        }
        return o.toString();
    }

    @Override
    public boolean updateStoreName(Integer storeId,String store_name ) {
        String sql = "update store_table set store_name = ? where store_id = ?";
        int update = update(sql, store_name, storeId);
        return update == 1;
    }

    @Override
    public boolean updateStoreIntroduce(Integer storeId,String store_introduce) {
        String sql = "update store_table set store_introduce = ? where store_id = ?";
        int update = update(sql,store_introduce,storeId);
        return update == 1;
    }

    @Override
    public List<Store_table> getBusinessStoreList(Integer storeOwner) {
        String sql = "SELECT * from store_table where store_owner = ? and store_isdel = 0";
        return queryMulti(sql, Store_table.class, storeOwner);
    }

    @Override
    public boolean delStore(Integer storeId ) throws Exception {
        String sql = "update store_table set store_isdel = 1 where store_id = ? and store_isdel = 0";
        int update = update(sql, storeId);
        return update == 1;
    }

    @Override
    public List<Store_table> getTypeStoreList(String city, String storeType) {
        String sql = "select * from store_table where store_city = ? and store_type = ? and store_isdel = 0";
        List list = queryMulti(sql, Store_table.class,city,storeType);
        return list;
    }

    @Override
    public List<Store_table> getNameStoreList(String city, String storeName) {
        String sql = "select * from Store_table where store_city= ? and store_name LIKE ? and store_isdel = 0";
        List list = queryMulti(sql, Store_table.class,city,"%"+storeName+"%");
        return list;
    }

    @Override
    public List<Goods_table> getNameStoreList2(String city, String goods_name) throws Exception {
        String sql = "select goods_table.* from goods_table,store_table where goods_owner = store_id " +
                "and store_city = ? and goods_name like ? and store_isdel = 0 and goods_isdel = 0";
        List list = queryMulti(sql, Goods_table.class,city,"%"+goods_name+"%");
        return list;
    }
}
