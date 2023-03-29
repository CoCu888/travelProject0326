package com.travel.domain;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author 李杨
 * @version 1.0
 * @date 2023/3/19
 * @introduction
 */
public class User_table {
    private Integer user_id;
    private String user_phonenum;
    private String user_name;
    private String user_pwd;
    private String user_email;
    private Date user_regtime;
    private String user_city;
    private String user_isdel;

    public User_table(Integer user_id, String user_phonenum, String user_name, String user_pwd, String user_email,
                      Date user_regtime, String user_city, String user_isdel) {
        this.user_id = user_id;
        this.user_phonenum = user_phonenum;
        this.user_name = user_name;
        this.user_pwd = user_pwd;
        this.user_email = user_email;
        this.user_regtime = user_regtime;
        this.user_city = user_city;
        this.user_isdel = user_isdel;
    }

    public User_table() {
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_phonenum() {
        return user_phonenum;
    }

    public void setUser_phonenum(String user_phonenum) {
        this.user_phonenum = user_phonenum;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public Date getUser_regtime() {
        return user_regtime;
    }

    public void setUser_regtime(Date user_regtime) {
        this.user_regtime = user_regtime;
    }

    public String getUser_city() {
        return user_city;
    }

    public void setUser_city(String user_city) {
        this.user_city = user_city;
    }

    public String getUser_isdel() {
        return user_isdel;
    }

    public void setUser_isdel(String user_isdel) {
        this.user_isdel = user_isdel;
    }

    @Override
    public String toString() {
        return "User_table{" +
                "user_id=" + user_id +
                ", user_phonenum='" + user_phonenum + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_pwd='" + user_pwd + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_regtime=" + user_regtime +
                ", user_city='" + user_city + '\'' +
                ", user_isdel='" + user_isdel + '\'' +
                '}';
    }
}
