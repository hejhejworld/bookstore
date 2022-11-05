package com.entity;

import java.util.*;

/**
 * 使用session实现购物车功能，没有使用数据库，因为session是web层API，所以直接在web层实现
 */
public class Cart {

    private Map<Integer, CartItem> items = new LinkedHashMap<>();

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }

    /**
     * 添加商品，如果商品已存在则更新该商品的数量，并更新该商品的总金额，
     * 如果商品不存在则直接添加
     * @param cartItem 添加进来的商品对象
     */
    public void addItem(CartItem cartItem) {
        CartItem item = items.get(cartItem.getId());
        if (item == null) {
            items.put(cartItem.getId(), cartItem);
        } else {
            item.setCount(item.getCount() + 1);
            item.setTotalPrice(item.getPrice() + item.getTotalPrice());
        }
    }

    public void deleteItem(Integer id) {
        items.remove(id);
    }

    public void clear() {
        items.clear();
    }

    public void updateCuont(Integer id, Integer count) {
        CartItem item = items.get(id);
        if (item != null) {
            item.setCount(count);
            item.setTotalPrice(item.getPrice() * item.getCount());
        }
    }

    public Integer getTotalCount() {
        Integer totalCount = 0;
        for (CartItem item : items.values()) {
            totalCount += item.getCount();
        }
        return totalCount;
    }


    public Double getTotalPrice() {
        Double totalPrice = 0.0;
        for (CartItem item : items.values()) {
            totalPrice += item.getTotalPrice();
        }
        return totalPrice;
    }


    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }
}
