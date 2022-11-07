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

    /**
     * 根据价格区间查询图书
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void queryBooksByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int min = WebUtils.parseInt(req.getParameter("min"), 0);
        int max = WebUtils.parseInt(req.getParameter("max"), 0);
        int currentPage = WebUtils.parseInt(req.getParameter("currentPage"), 1);
        Page<Book> page = bookService.queryBooksByPrice(currentPage, min, max);

        //回显数据
        req.setAttribute("min", min);
        req.setAttribute("max", max);

        /**
         * 因为在价格区间查询时会提交表单，带有请求请求参数，
         * 请求转发回去后点下一页时，因为没有提交表单，所以就没有价格区间的请求参数，
         * 所以这里把参数保存到page对象的url属性中，当点下一页时浏览器请求的url就会带上max和min
         */
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
