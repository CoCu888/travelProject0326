package com.travel.test;
import com.travel.dao.IBusinessDAO;
import com.travel.dao.impl.BusinessDAOImpl;
import com.travel.dao.impl.GoodsDAOImpl;
import com.travel.dao.impl.StoreDAOImpl;
import com.travel.domain.*;
import com.travel.service.impl.IBusinessServiceImpl;
import com.travel.service.impl.IStoreServiceImpl;
import com.travel.service.impl.UserServiceImpl;
import java.util.List;

import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;

/**
 * @author 李杨
 * @version 1.0
 * @date 2023/3/19
 * @introduction
 */
@SuppressWarnings("all")
public class TestUser {
    private UserServiceImpl userService;
    public static void main(String[] args) throws Exception {

//        BusinessDAOImpl iBusinessDAO = new BusinessDAOImpl();
//        boolean b = iBusinessDAO.insertBusiness("asd", "asd", "asd");
//        System.out.println(b);

        IBusinessServiceImpl iBusinessService = new IBusinessServiceImpl();
        System.out.println();
//        boolean b = iBusinessService.updateBusiness("business_pwd", 1, "asd");
//        System.out.println(b);

//        boolean b = iBusinessService.regBusiness("pwd", "asd", "123456");
//        System.out.println(b);
//


//        boolean b = iBusinessService.updateBusiness("business_name", 6, "张三");
//        System.out.println(b);
//        boolean b1 = userDAO.checkEmail("2118058518@qq.com");
//        System.out.println(b1);
//        BusinessDAOImpl businessDAO = new BusinessDAOImpl();
//        StoreDAOImpl storeDAO = new StoreDAOImpl();
//        GoodsDAOImpl goodsDAO = new GoodsDAOImpl();
//        Integer.parseInt("1");
//        User_table user = userDAO.getUser("15074708409","123456");
//        System.out.println(user);
//        boolean b = userDAO.insertUser("15874703708","谷炜","123456","衡阳");
//        System.out.println(b);
//        boolean b = userDAO.checkPhoneNum("15874703708");
//        System.out.println(b);
//        boolean b = userDAO.updatePwd(1,"123456");
//        System.out.println(b);
//        boolean b = userDAO.updateCity(1,"香港");
//        System.out.println(b);
//        boolean b = businessDAO.insertBusiness("15074708409", "谷彤", "123456");
//        System.out.println(b);
//        Business_table business = businessDAO.getBusiness("15074708409","123456");
//        System.out.println(business);
//        boolean b = businessDAO.checkPhoneNum("15074708409");
//        System.out.println(b);
//        boolean b = businessDAO.updatePhoneNum(7,"110");
//        System.out.println(b);
//        boolean b = businessDAO.updateName(7,"李四");
//        System.out.println(b);
//        boolean b = businessDAO.updatePwd(7, "123456");
//        System.out.println(b);
//        boolean b = businessDAO.updateEmail(7,"2641977996@qq.com");
//        System.out.println(b);
//        boolean b = businessDAO.delAccount(7);
//        System.out.println(b);
//        boolean store = storeDAO.createStore(1,"澳门","澳门赌场","娱乐场所","澳门","赌博");
//        System.out.println(store);
//        List<Store_table> businessStoreList = storeDAO.getBusinessStoreList(1);
//        for (Object o :businessStoreList) {
//            System.out.println(o);
//        }
//        boolean b = storeDAO.delStore(1);
//        System.out.println(b);
//        List<Store_table> nameStoreList = storeDAO.getNameStoreList("澳门", "门");
//        for (Object o :nameStoreList) {
//            System.out.println(o);
//        }
//        List<Goods_table> nameStoreList2 = storeDAO.getNameStoreList2("长春", "头牌鲜切黄牛肉");
//        for (Object o :nameStoreList2) {
//            System.out.println(o);
//        }
//        List<Goods_table> storeGoodsList = goodsDAO.getStoreGoodsList(1);
//        for (Object o :storeGoodsList) {
//            System.out.println(o);
//        }
//        List<Goods_table> goodsByName = goodsDAO.getGoodsByName("菜");
//        for (Object o :goodsByName) {
//            System.out.println(o);
//        }
//        boolean b = goodsDAO.InsertGoodsToStore(1,"剁头鱼",40.0,"鱼");
//        System.out.println(b);
//        boolean b = goodsDAO.deleteGoods(20);
//        System.out.println(b);
//        boolean b = goodsDAO.updateGoodsIntroduce(20,"蒸鱼");
//        System.out.println(b);
//        boolean b = goodsDAO.updateGoodsName(20,"清蒸鲈鱼");
//        System.out.println(b);

//        UserServiceImpl userService = new UserServiceImpl();
//        boolean login = userService.login("15074708409", "123456");
//        System.out.println(login);
//        boolean b = userService.regUser("123","gt","123456","北京");
//        System.out.println(b);
//        List<Store_table> storeByType = userService.getStoreByType("长春","饭店");
//        for (Object o :storeByType) {
//            System.out.println(o);
//        }
//        List<Store_table> storeByName = userService.getStoreByName("长春","饭");
//        for (Object o :storeByName) {
//            System.out.println(o);
//        }
//        List<Goods_table> goodsByName = userService.getGoodsByName("长春","头牌鲜切黄牛肉");
//        for (Object o :goodsByName) {
//            System.out.println(o);
//        }
//        boolean b = userService.updateUser("user_email",12,"666@qq.com");
//        System.out.println(b);
//        boolean b = iBusinessService.updateBusiness("business_pwd", 7, "123456");
//        System.out.println(b);
//        boolean login = iBusinessService.login("110", "123456");
//        System.out.println(login);
//        boolean b = iBusinessService.updateBusiness("business_phonenum", 7, "15074708409");
//        System.out.println(b);
//        List<Store_table> myStore = iBusinessService.getMyStore(1);
//        for (Object o :myStore) {
//            System.out.println(o);
//        }
//        boolean store = iBusinessService.createStore(1,"长春","ikun","酒店","解放西","happy");
//        System.out.println(store);
//        String s = iBusinessService.delStore(1);
//        System.out.println(s);
//        boolean b = iBusinessService.updateStore("store_name",12,"夺宝肉");
//        System.out.println(b);
//        boolean b = iBusinessService.delAccount(1);
//        System.out.println(b);
//        boolean b = iStoreService.updateGoodsPrice(20, 199.9);
//        System.out.println(b);
//        boolean b = iStoreService.updateGoodsIntroduce(20,"00000");
//        System.out.println(b);
//        boolean b = iStoreService.updateGoodsName(20,"apple");
//        System.out.println(b);
//        boolean b = iStoreService.deleteGoods(21);
//        System.out.println(b);
//        boolean asdasd = goodsDAO.findGoods(2, "666", 999.0, "asdasd");
//        System.out.println(asdasd);
//        boolean b = iStoreService.insertGoods(2, "66", 999.0, "asdasd");
//        System.out.println(b);
//        boolean b = iBusinessService.delAccount(1);
//        System.out.println(b);

//        boolean login = userService.login("","");
    }
}

