package com.test;

import com.entity.Cart;
import com.entity.CartItem;
import org.junit.Test;

import static org.junit.Assert.*;

public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "apple", 3, 10.1, 30.1));
        System.out.println(cart);
        cart.addItem(new CartItem(1, "apple", 1, 10.1, 30.1));
        System.out.println(cart);
        cart.addItem(new CartItem(2, "apple", 3, 10.1, 30.1));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "apple", 3, 10.1, 30.1));
        System.out.println(cart);
        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "apple", 3, 10.1, 30.1));
        cart.addItem(new CartItem(2, "apple", 1, 10.1, 30.1));
        System.out.println(cart);
        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCuont() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "apple", 3, 10.1, 30.1));
        System.out.println(cart);
        cart.updateCuont(1, 5);
        System.out.println(cart);
    }
}