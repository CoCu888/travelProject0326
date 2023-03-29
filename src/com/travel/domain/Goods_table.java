package com.travel.domain;

/**
 * @author 李杨
 * @version 1.0
 * @date 2023/3/19
 * @introduction
 */
public class Goods_table {
    private Integer goods_id;
    private Integer goods_owner;
    private String goods_name;
    private Double goods_price;
    private String goods_introduce;
    private String goods_isdel;

    public Goods_table() {
    }

    public Goods_table(Integer goods_id, Integer goods_owner, String goods_name, Double goods_price,
                       String goods_introduce, String goods_isdel) {
        this.goods_id = goods_id;
        this.goods_owner = goods_owner;
        this.goods_name = goods_name;
        this.goods_price = goods_price;
        this.goods_introduce = goods_introduce;
        this.goods_isdel = goods_isdel;
    }

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public Integer getGoods_owner() {
        return goods_owner;
    }

    public void setGoods_owner(Integer goods_owner) {
        this.goods_owner = goods_owner;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public Double getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(Double goods_price) {
        this.goods_price = goods_price;
    }

    public String getGoods_introduce() {
        return goods_introduce;
    }

    public void setGoods_introduce(String goods_introduce) {
        this.goods_introduce = goods_introduce;
    }

    public String getGoods_isdel() {
        return goods_isdel;
    }

    public void setGoods_isdel(String goods_isdel) {
        this.goods_isdel = goods_isdel;
    }

    @Override
    public String toString() {
        return "Goods_table{" +
                "goods_id=" + goods_id +
                ", goods_owner=" + goods_owner +
                ", goods_name='" + goods_name + '\'' +
                ", goods_price=" + goods_price +
                ", goods_introduce='" + goods_introduce + '\'' +
                ", goods_isdel='" + goods_isdel + '\'' +
                '}';
    }
}
