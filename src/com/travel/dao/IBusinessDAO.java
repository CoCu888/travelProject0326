package com.travel.dao;

import com.travel.domain.Business_table;
import com.travel.domain.User_table;

/**
 * @author 李杨
 * @version 1.0
 * @date 2023/3/19
 * @introduction
 */
public interface IBusinessDAO {

    // 注册用户
    boolean insertBusiness(String phoneNum, String userName, String pwd);

    // 获取用户对象，isdel不是1！！！
    Business_table getBusiness(String phoneNum, String pwd) throws Exception;

    // 查询手机号是否注册过，isdel不是1！！！
    boolean checkPhoneNum(String phoneNum) throws Exception;

    // 查询手机号是否注册过，isdel不是1！！！
    boolean checkEmail(String Email) throws Exception;

    // 更新手机号
    boolean updatePhoneNum(Integer id, String newPhoneNum) throws Exception;

    boolean updateName(Integer id,String name) throws Exception;

    // 修改用户密码
    boolean updatePwd(Integer id, String newPwd) throws Exception;

    // 修改邮箱
    boolean updateEmail(Integer id, String newEmail) throws Exception;

    // 账号注销，假删除，将isdel属性设为1即可
    boolean delAccount(Integer id) throws Exception;

}
