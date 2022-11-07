package com.entity;

public class OrderItem {

    private Integer id;
    private String name;
    private Double price;
    private Double totalPrice;
    private String orderid;

    public OrderItem(Integer id, String name, Double price, Double totalPrice, String orderid) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.totalPrice = totalPrice;
        this.orderid = orderid;
    }

    public OrderItem() {
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                ", orderid='" + orderid + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }
}
