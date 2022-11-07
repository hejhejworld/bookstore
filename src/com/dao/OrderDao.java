package com.dao;

import com.entity.Order;

import java.util.List;

public interface OrderDao {

    public int createOrder(Order order);

    public List<Order> showMyOrder(Integer userid);

    public List<Order> showAllOrder();

    public void setStatus(Integer orderItemid);
}
