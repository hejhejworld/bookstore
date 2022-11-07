package com.dao.impl;

import com.dao.OrderItemDao;
import com.entity.OrderItem;

public class OrderItemDaoImpl extends BasicDao implements OrderItemDao {
    @Override
    public int createOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item (id, name, price, total_price, orderid) values (?, ?, ?, ?, ?)";
        return this.update(sql, orderItem.getId(), orderItem.getName(), orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getOrderid());
    }
}
