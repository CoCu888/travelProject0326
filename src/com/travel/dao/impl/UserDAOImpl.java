package com.travel.dao.impl;

import com.travel.dao.IUserDAO;
import com.travel.domain.User_table;

/**
 * @author 李杨
 * @version 1.0
 * @date 2023/3/20
 * @introduction
 */
@SuppressWarnings({"All"})
public class UserDAOImpl extends BasicDAO implements IUserDAO {

    @Override
    public boolean insertUser(String phoneNum, String userName, String pwd, String city) {
        String sql = "insert into user_table (user_phonenum, user_name, user_pwd, user_regtime, user_city)" +
                "values(?,?,MD5(?),now(),?)";
        int i = update(sql,phoneNum, userName, pwd, city);
        return i==1;
    }

    @Override
    public User_table getUser(String phoneNum, String pwd) throws Exception {
        String sql = "select * from User_table where user_phonenum = ?  and user_pwd = MD5(?) and user_isdel = 0";
        User_table user = (User_table) querySingle(sql, User_table.class, phoneNum, pwd);
        return user;
    }

    @Override
    public boolean checkPhoneNum(String phoneNum) throws Exception {
        String sql = "select * from user_table where user_phonenum = ? and user_isdel = 0";
        Object o = querySingle(sql, User_table.class, phoneNum);
        if (o == null){
            return false; //返回false表示该用户不存在
        }else {
            return true;  //返回true表示该用户存在
        }
    }

    @Override
    public boolean checkEmail(String Email) throws Exception {
        String sql = "select * from user_table where user_email = ? and user_isdel = 0";
        Object o = querySingle(sql, User_table.class, Email);
//        System.out.println(o);
        if (o == null){
            return false; //返回false表示该用户不存在
        }else {
            return true;  //返回true表示该用户存在
        }
    }

    @Override
    public boolean updatePhoneNum(Integer id, String newPhoneNum) throws Exception {
        String sql = "update user_table set user_phonenum=? where user_id = ? ";
        int i = update(sql, newPhoneNum, id);
        return i==1;
    }

    @Override
    public boolean updatePwd(Integer id, String newPwd) throws Exception {
        String sql = "update user_table set user_pwd = md5(?) where user_id = ?";
        int update = update(sql, newPwd, id);
        if (update==1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean updateCity(Integer id, String newCity) throws Exception {
        String sql = "update user_table set user_city = ? where user_id = ?";
        int update = update(sql, newCity, id);
        if (update==1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean updateEmail(Integer id, String newEmail) throws Exception {
        String sql = "update user_table set user_email = ? where user_id = ?";
        int update = update(sql, newEmail, id);
        if (update==1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean updateName(Integer id, String newName) throws Exception {
        String sql = "update user_table set user_name = ? where user_id = ?";
        int update = update(sql, newName, id);
        return update == 1;
    }

    @Override
    public boolean delAccount(Integer id) throws Exception {
        String sql = "update user_table set user_isdel = 1 where user_id = ? ";
        int update = update(sql, id);
        return update == 1;
    }

    public String getPwd(String pwd) throws Exception{
        String sql = "select MD5(?) FROM DUAL;";
        Object o = queryScalar(sql, pwd);
        return (String) o;

    }
}
