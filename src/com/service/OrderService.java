package com.service;

import com.entity.Cart;

public interface OrderService {
    /**
     * 
     * @param cart
     * @param userid
     * @return orderid
     */
    public String creatOrder(Cart cart, Integer userid);
}
