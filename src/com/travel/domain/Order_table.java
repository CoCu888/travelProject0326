package com.travel.domain;

import java.util.Date;

public class Order_table {
    private Integer order_id;
    private Integer order_ower;
    private Integer order_from;
    private String order_name;
    private Double order_price;
    private String order_introduce;
    private Date order_time;
    private String order_isdel;

    public Order_table() {
    }

    public Order_table(Integer order_id, Integer order_ower, Integer order_from, String order_name, Double order_price, String order_introduce, Date order_time, String order_isdel) {
        this.order_id = order_id;
        this.order_ower = order_ower;
        this.order_from = order_from;
        this.order_name = order_name;
        this.order_price = order_price;
        this.order_introduce = order_introduce;
        this.order_time = order_time;
        this.order_isdel = order_isdel;
    }

    @Override
    public String toString() {
        return "Order_table{" +
                "order_id=" + order_id +
                ", order_ower=" + order_ower +
                ", order_from=" + order_from +
                ", order_name='" + order_name + '\'' +
                ", order_price=" + order_price +
                ", order_introduce='" + order_introduce + '\'' +
                ", order_time=" + order_time +
                ", order_isdel='" + order_isdel + '\'' +
                '}';
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getOrder_ower() {
        return order_ower;
    }

    public void setOrder_ower(Integer order_ower) {
        this.order_ower = order_ower;
    }

    public Integer getOrder_from() {
        return order_from;
    }

    public void setOrder_from(Integer order_from) {
        this.order_from = order_from;
    }

    public String getOrder_name() {
        return order_name;
    }

    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }

    public Double getOrder_price() {
        return order_price;
    }

    public void setOrder_price(Double order_price) {
        this.order_price = order_price;
    }

    public String getOrder_introduce() {
        return order_introduce;
    }

    public void setOrder_introduce(String order_introduce) {
        this.order_introduce = order_introduce;
    }

    public Date getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Date order_time) {
        this.order_time = order_time;
    }

    public String getOrder_isdel() {
        return order_isdel;
    }

    public void setOrder_isdel(String order_isdel) {
        this.order_isdel = order_isdel;
    }
}