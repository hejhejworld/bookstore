package com.web;

import com.entity.Book;
import com.entity.Cart;
import com.entity.CartItem;
import com.service.BookService;
import com.service.impl.BookServiceImpl;
import com.utils.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CartServlet extends BaseServlet {

    BookService bookService = new BookServiceImpl();

    public void addItem(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Book book = bookService.queryBookById(id);
        CartItem cartItem = new CartItem(book.getBookid(), book.getBookname(), 1, book.getPrice(), book.getPrice());
        if (req.getSession().getAttribute("cart") == null)
            req.getSession().setAttribute("cart", new Cart());
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        cart.addItem(cartItem);
        req.getSession().setAttribute("lastItemName", cartItem.getName());
        resp.sendRedirect(req.getHeader("Referer"));
    }

    public void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        cart.deleteItem(id);
        if (req.getSession().getAttribute("lastItemName") != null)
            req.getSession().removeAttribute("lastItemName");
        resp.sendRedirect(req.getHeader("Referer"));
    }

    public void clear(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        cart.clear();
        if (req.getSession().getAttribute("lastItemName") != null)
            req.getSession().removeAttribute("lastItemName");
        resp.sendRedirect(req.getHeader("Referer"));
    }

    public void updateCount(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        int count = WebUtils.parseInt(req.getParameter("count"), 1);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        cart.updateCuont(id, count);
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
