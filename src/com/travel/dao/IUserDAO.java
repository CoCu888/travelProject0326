package com.travel.dao;

import com.travel.domain.User_table;

/**
 * @author 李杨
 * @version 1.0
 * @date 2023/3/19
 * @introduction
 */
public interface IUserDAO {

    // 注册用户
    boolean insertUser(String phoneNum, String userName, String pwd, String city) throws Exception;

    // 获取用户对象
    User_table getUser(String phoneNum, String pwd) throws Exception;

    // 查询手机号是否注册过
    boolean checkPhoneNum(String phoneNum) throws Exception;

    //查询邮箱是否已被注册
    boolean checkEmail(String Email) throws Exception;

    // 更新手机号
    boolean updatePhoneNum(Integer id, String newPhoneNum) throws Exception;

    // 修改用户密码
    boolean updatePwd(Integer id, String newPwd) throws Exception;

    // 修改用户城市
    boolean updateCity(Integer id, String newCity) throws Exception;

    // 修改邮箱
    boolean updateEmail(Integer id, String newEmail) throws Exception;

    // 修改用户名
    boolean updateName(Integer id, String newName) throws Exception;

    // 账号注销，假删除，将isdel属性设为1即可
    boolean delAccount(Integer id) throws Exception;


}
