package com.travel.domain;

import java.util.Date;

/**
 * @author 李杨
 * @version 1.0
 * @date 2023/3/19
 * @introduction
 */
public class Business_table {
    private Integer business_id;
    private String business_phonenum;
    private String business_name;
    private String business_pwd;
    private String business_email;
    private Date business_regtime;
    private String business_isdel;

    public Business_table(){}

    public Business_table(Integer business_id, String business_phonenum, String business_name, String business_pwd, String business_email, Date business_regtime, String business_isdel) {
        this.business_id = business_id;
        this.business_phonenum = business_phonenum;
        this.business_name = business_name;
        this.business_pwd = business_pwd;
        this.business_email = business_email;
        this.business_regtime = business_regtime;
        this.business_isdel = business_isdel;
    }

    @Override
    public String toString() {
        return "Business_table{" +
                "business_id=" + business_id +
                ", business_phonenum='" + business_phonenum + '\'' +
                ", business_name='" + business_name + '\'' +
                ", business_pwd='" + business_pwd + '\'' +
                ", business_email='" + business_email + '\'' +
                ", business_regtime=" + business_regtime +
                ", business_isdel='" + business_isdel + '\'' +
                '}';
    }

    public Integer getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(Integer business_id) {
        this.business_id = business_id;
    }

    public String getBusiness_phonenum() {
        return business_phonenum;
    }

    public void setBusiness_phonenum(String business_phonenum) {
        this.business_phonenum = business_phonenum;
    }

    public String getBusiness_name() {
        return business_name;
    }

    public void setBusiness_name(String business_name) {
        this.business_name = business_name;
    }

    public String getBusiness_pwd() {
        return business_pwd;
    }

    public void setBusiness_pwd(String business_pwd) {
        this.business_pwd = business_pwd;
    }

    public String getBusiness_email() {
        return business_email;
    }

    public void setBusiness_email(String business_email) {
        this.business_email = business_email;
    }

    public Date getBusiness_regtime() {
        return business_regtime;
    }

    public void setBusiness_regtime(Date business_regtime) {
        this.business_regtime = business_regtime;
    }

    public String getBusiness_isdel() {
        return business_isdel;
    }

    public void setBusiness_isdel(String business_isdel) {
        this.business_isdel = business_isdel;
    }
}
