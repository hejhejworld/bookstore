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
import java.util.List;

public class BookServlet extends BaseServlet {

    BookService bookService = new BookServiceImpl();

    public void addBook(HttpServletRequest req, HttpServletResponse resp) {

        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        bookService.addBook(book);

        //请求重定向
        try {
            resp.sendRedirect(req.getContextPath() + "/manager/bookservlet?action=page");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //不能用请求转发，因为浏览器会记录最后一次请求，当浏览器刷新的时候会造成表单重复提交，所以用请求重定向
//        try {
//            req.getRequestDispatcher("/manager/bookservlet?action=queryBooks").forward(req, resp);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public void deleteBook(HttpServletRequest req, HttpServletResponse resp) {

        int bookid = WebUtils.parseInt(req.getParameter("bookid"), -1);
        bookService.deleteBookById(bookid);
        try {
            resp.sendRedirect(req.getContextPath() + "/manager/bookservlet?action=page");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //查询图书信息保存到reqest域中转发给jsp页面
    public void queryBookById(HttpServletRequest req, HttpServletResponse resp) {
        Book book = bookService.queryBookById(WebUtils.parseInt(req.getParameter("bookid"), -1));
        req.setAttribute("book", book);
        try {
            req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public void updateBook(HttpServletRequest req, HttpServletResponse resp) {

        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        bookService.updateBook(book);
        try {
            req.getRequestDispatcher("/manager/bookservlet?action=page").forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public void queryBooks(HttpServletRequest req, HttpServletResponse resp) {
        List<Book> books = bookService.queryBooks();
        req.setAttribute("books", books);
        try {
            req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public void page(HttpServletRequest req, HttpServletResponse resp) {
        int currentPage = WebUtils.parseInt(req.getParameter("currentPage"), 1);
        Page<Book> page = bookService.page(currentPage);
        req.setAttribute("page", page);
        try {
            req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
