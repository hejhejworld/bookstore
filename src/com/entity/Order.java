package com.entity;

import java.util.Date;

/**
 * 一个购物车生成一个Order对象，
 * 购物车中的每个商品分别为一个OrderItem对象，
 * Order和OrderItem用订单id关联
 */

public class Order {

    //status表示订单状态，0未发货，1已发货，2已签收
    private String orderid;
    private Date time;
    private Double price;
    private Integer status;
    private Integer userid;

    public Order(String orderid, Date time, Double price, Integer status, Integer userid) {
        this.orderid = orderid;
        this.time = time;
        this.price = price;
        this.status = status;
        this.userid = userid;
    }

    public Order() {
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderid='" + orderid + '\'' +
                ", time=" + time +
                ", price=" + price +
                ", status=" + status +
                ", userid=" + userid +
                '}';
    }
}
