package com.web;

import com.entity.Book;
import com.entity.Page;
import com.service.BookService;
import com.service.impl.BookServiceImpl;
import com.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientBookServlet extends BaseServlet {

    BookService bookService = new BookServiceImpl();

    public void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int currentPage = WebUtils.parseInt(req.getParameter("currentPage"), 1);
        Page<Book> page = bookService.page(currentPage);
        page.setUrl("clientbookservlet?action=page");
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }

    public void queryBooksByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int min = WebUtils.parseInt(req.getParameter("min"), 0);
        int max = WebUtils.parseInt(req.getParameter("max"), 0);
        int currentPage = WebUtils.parseInt(req.getParameter("currentPage"), 1);
        Page<Book> page = bookService.queryBooksByPrice(currentPage, min, max);

        //回显数据
        req.setAttribute("min", min);
        req.setAttribute("max", max);

        StringBuilder sb = new StringBuilder("clientbookservlet?action=queryBooksByPrice");
        if (req.getParameter("min") != null)
            sb.append("&min=").append(req.getParameter("min"));
        if (req.getParameter("max") != null)
            sb.append("&max=").append(req.getParameter("max"));
        page.setUrl(sb.toString());

        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }
}
