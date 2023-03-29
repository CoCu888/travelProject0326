package com.travel.domain;

/**
 * @author 李杨
 * @version 1.0
 * @date 2023/3/19
 * @introduction
 */
public class Store_table {
    private Integer store_id;
    private Integer store_owner;
    private String store_city;
    private String store_name;
    private String store_type;
    private String store_address;
    private String store_introduce;
    private String store_score;
    private String store_isdel;

    public Store_table(Integer store_id, Integer store_owner, String store_city, String store_name, String store_type,
                       String store_address, String store_introduce, String store_score, String store_isdel) {
        this.store_id = store_id;
        this.store_owner = store_owner;
        this.store_city = store_city;
        this.store_name = store_name;
        this.store_type = store_type;
        this.store_address = store_address;
        this.store_introduce = store_introduce;
        this.store_score = store_score;
        this.store_isdel = store_isdel;
    }

    public Store_table() {
    }

    public Integer getStore_id() {
        return store_id;
    }

    public void setStore_id(Integer store_id) {
        this.store_id = store_id;
    }

    public Integer getStore_owner() {
        return store_owner;
    }

    public void setStore_owner(Integer store_owner) {
        this.store_owner = store_owner;
    }

    public String getStore_city() {
        return store_city;
    }

    public void setStore_city(String store_city) {
        this.store_city = store_city;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getStore_type() {
        return store_type;
    }

    public void setStore_type(String store_type) {
        this.store_type = store_type;
    }

    public String getStore_address() {
        return store_address;
    }

    public void setStore_address(String store_address) {
        this.store_address = store_address;
    }

    public String getStore_introduce() {
        return store_introduce;
    }

    public void setStore_introduce(String store_introduce) {
        this.store_introduce = store_introduce;
    }

    public String getStore_score() {
        return store_score;
    }

    public void setStore_score(String store_score) {
        this.store_score = store_score;
    }

    public String getStore_isdel() {
        return store_isdel;
    }

    public void setStore_isdel(String store_isdel) {
        this.store_isdel = store_isdel;
    }
    @Override
    public String toString() {
        return "Store_table{" +
                "store_id=" + store_id +
                ", store_owner=" + store_owner +
                ", store_city='" + store_city + '\'' +
                ", store_name='" + store_name + '\'' +
                ", store_type='" + store_type + '\'' +
                ", store_address='" + store_address + '\'' +
                ", store_introduce='" + store_introduce + '\'' +
                ", store_score='" + store_score + '\'' +
                ", store_isdel='" + store_isdel + '\'' +
                '}';
    }
}
