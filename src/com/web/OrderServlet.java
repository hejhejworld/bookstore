package com.web;

import com.entity.Cart;
import com.service.OrderService;
import com.service.impl.OrderServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderServlet extends BaseServlet{

    OrderService orderService = new OrderServiceImpl();

    public void createOrder(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        Integer userid = (Integer) req.getSession().getAttribute("userid");
        String orderid = orderService.creatOrder(cart, userid);
        cart.clear();
        req.getSession().removeAttribute("lastItemName");
        //回显订单号
        req.getSession().setAttribute("orderid", orderid);
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
    }
}
