package com.service.impl;

import com.dao.BookDao;
import com.dao.OrderDao;
import com.dao.OrderItemDao;
import com.dao.impl.BookDaoImpl;
import com.dao.impl.OrderDaoImpl;
import com.dao.impl.OrderItemDaoImpl;
import com.entity.*;
import com.service.OrderService;

import java.util.Date;
import java.util.Map;

public class OrderServiceImpl implements OrderService {

    OrderDao orderDao = new OrderDaoImpl();
    OrderItemDao orderItemDao = new OrderItemDaoImpl();
    BookDao bookDao = new BookDaoImpl();

    @Override
    public String creatOrder(Cart cart, Integer userid) {
        //用时间和userid创建orderid，保证唯一性
        String orderid = System.currentTimeMillis() + "" + userid;
        Order order = new Order(orderid, new Date(), cart.getTotalPrice(), 0, userid);
        orderDao.createOrder(order);

        for (Map.Entry<Integer, CartItem> item : cart.getItems().entrySet()) {
            OrderItem orderItem = new OrderItem(null, item.getValue().getName(), item.getValue().getPrice(), item.getValue().getTotalPrice(), orderid);
            orderItemDao.createOrderItem(orderItem);
            //更新图书库存和销量
            Book book = bookDao.queryBookById(item.getKey());
            book.setSales(book.getSales() + item.getValue().getCount());
            book.setStock(book.getStock() - item.getValue().getCount());
            bookDao.updateBook(book);
        }

        return orderid;
    }
}
