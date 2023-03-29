package com.travel.service.impl;
import com.travel.dao.impl.OrderDAOImpl;
import com.travel.dao.impl.StoreDAOImpl;
import com.travel.dao.impl.UserDAOImpl;
import com.travel.domain.Goods_table;
import com.travel.domain.Order_table;
import com.travel.domain.Store_table;
import com.travel.domain.User_table;
import com.travel.service.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {
    private UserDAOImpl userDAO = new UserDAOImpl();
    private StoreDAOImpl storeDAO = new StoreDAOImpl();
    private OrderDAOImpl orderDAO = new OrderDAOImpl();

    public boolean regUser(String user_phonenum, String user_name, String user_pwd, String user_city) throws Exception {
        if (user_phonenum !=null && user_name!=null && user_pwd!=null && user_city!=null){
            boolean b = userDAO.checkPhoneNum(user_phonenum);
            if (!b){
                boolean f  = userDAO.insertUser(user_phonenum,user_name,user_pwd,user_city);
                if (f){
                    System.out.println("插入数据成功");
                    return true;
                }else {
                    System.out.println("插入数据失败");
                    return false;
                }
            }else {
                System.out.println("用户已经存在");
                return false;
            }
        } else{
            return false;
        }
    }

    @Override
    public boolean login(String user_phonenum, String user_pwd) throws Exception {
        User_table user_table = userDAO.getUser(user_phonenum, user_pwd);
        if (user_table == null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public User_table getUser(String phoneNum, String pwd) throws Exception {
        return userDAO.getUser(phoneNum,pwd);
    }


    @Override
    public List<Store_table> getStoreByType(String city, String storeType) throws Exception {
        List<Store_table> typeStoreList = storeDAO.getTypeStoreList(city, storeType);
        return typeStoreList;
    }

    @Override
    public List<Store_table> getStoreByName(String city, String storeName) throws Exception {
        List<Store_table> nameStoreList = storeDAO.getNameStoreList(city,storeName);
        return nameStoreList;
    }

    @Override
    public List<Goods_table> getGoodsByName(String city, String goodsName) throws Exception {
        List<Goods_table> nameStoreList2 = storeDAO.getNameStoreList2(city,goodsName);
        return nameStoreList2;
    }

    @Override
    public boolean updateUser(String type, Integer id, String newInfo) throws Exception {
        if (type.equals("user_phonenum")){
            boolean b = userDAO.checkPhoneNum(newInfo);
            if (!b){
                return userDAO.updatePhoneNum(id, newInfo);
            }else {
                return false;
            }
        }else if (type.equals("user_name")){
            return userDAO.updateName(id,newInfo);
        }else if (type.equals("user_pwd")){
            return userDAO.updatePwd(id,newInfo);
        }else if (type.equals("user_email")){
            boolean b = userDAO.checkEmail(newInfo);
            if (!b){
                return userDAO.updateEmail(id, newInfo);
            }else {
                return false;
            }
        }else if (type.equals("user_city")){
            return userDAO.updateCity(id,newInfo);
        }else {
            System.out.println("传入类型异常！");
        }
        return false;
    }

    @Override
    public boolean delAccount(Integer id) throws Exception {
        boolean b = userDAO.delAccount(id);
        return b;
    }

    @Override
    public boolean insertOrder(Integer order_ower, Integer order_from, String order_name, Double order_price, String order_introduce) throws Exception{
        boolean b = orderDAO.insertGoodOrder(order_ower, order_from, order_name, order_price, order_introduce);
        return b;
    }

    @Override
    public List<Order_table> getOrderList(Integer order_ower) {
        List<Order_table> userOrderList = orderDAO.getUserOrderList(order_ower);
        return userOrderList;
    }

    @Override
    public boolean delOrder(Integer order_id) {
        boolean b = orderDAO.delOrder(order_id);
        return b;
    }
    public String getPwd(String pwd) throws Exception{
        return userDAO.getPwd(pwd);
    }
}
