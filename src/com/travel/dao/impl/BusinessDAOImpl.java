package com.travel.dao.impl;

import com.travel.dao.IBusinessDAO;
import com.travel.domain.Business_table;

public class BusinessDAOImpl extends BasicDAO implements IBusinessDAO {
    @Override
    public boolean insertBusiness(String phoneNum, String userName, String pwd) {
        String sql = "INSERT INTO business_table (business_phonenum,business_name,business_pwd,business_regtime) VALUES(?,?,MD5(?),NOW())";
        int i = update(sql,phoneNum,userName,pwd);
        return i==1;
    }

    @Override
    public Business_table getBusiness(String phoneNum, String pwd) throws Exception {
        String sql = "select * from business_table where business_phonenum = ? and business_pwd = md5(?) and business_isdel = 0";
        Business_table business_table = (Business_table)querySingle(sql, Business_table.class, phoneNum, pwd);
        return business_table;
    }

    @Override
    public boolean checkPhoneNum(String phoneNum) throws Exception {
        String sql = "select * from business_table where business_phonenum = ? and business_isdel = 0";
        Business_table business_table = (Business_table)querySingle(sql, Business_table.class, phoneNum);
//        System.out.println(business_table);
        if (business_table == null){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public boolean checkEmail(String Email) throws Exception {
        String sql = "select * from business_table where business_email = ? and business_isdel = 0";
        Business_table business_table = (Business_table)querySingle(sql, Business_table.class,Email);
        System.out.println(business_table);
        if (business_table == null){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public boolean updatePhoneNum(Integer id, String newPhoneNum) throws Exception {
        String sql = "update business_table set business_phonenum=? where business_id = ?";
        int update = update(sql, newPhoneNum, id);
        return update == 1;
    }

    @Override
    public boolean updateName(Integer id, String name) throws Exception {
        String sql = "update business_table set business_name = ? where business_id = ?";
        int update = update(sql, name, id);
        return update == 1;
    }

    @Override
    public boolean updatePwd(Integer id, String newPwd) throws Exception {
        String sql = "update business_table set business_pwd = md5(?) where business_id = ?";
        int update = update(sql,newPwd,id);
        return update == 1;
    }

    @Override
    public boolean updateEmail(Integer id, String newEmail) throws Exception {
        String sql = "update business_table set business_email = ? where business_id = ?";
        int update = update(sql,newEmail,id);
        return update == 1;
    }

    @Override
    public boolean delAccount(Integer id) throws Exception {
        String sql = "update business_table set business_isdel = 1 where business_id = ? AND business_isdel=0";
        int update = update(sql,id);
        return update == 1;
    }

    public String getPwd(String pwd) throws Exception{
        String sql = "select MD5(?) FROM DUAL;";
        Object o = queryScalar(sql, pwd);
        return (String) o;
    }
}
