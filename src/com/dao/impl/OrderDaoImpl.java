package com.dao.impl;

import com.dao.OrderDao;
import com.entity.Order;

import java.util.List;

public class OrderDaoImpl extends BasicDao implements OrderDao {

    @Override
    public int createOrder(Order order) {
        String sql = "insert into t_order(orderid, time, price , status, userid) values (?, ?, ?, ?, ?)";
        return this.update(sql, order.getOrderid(), order.getTime(), order.getPrice(), order.getStatus(), order.getUserid());
    }

    @Override
    public List<Order> showMyOrder(Integer userid) {
        return null;
    }

    @Override
    public List<Order> showAllOrder() {
        return null;
    }

    @Override
    public void setStatus(Integer orderItemid) {

    }
}
