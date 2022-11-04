package com.web;

import com.entity.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String repwd = req.getParameter("repwd");
        req.setAttribute("username", username);
        req.setAttribute("password", password);
        req.setAttribute("repwd", repwd);
        req.setAttribute("email", email);
        req.setAttribute("errorMge", "用户名已存在！");

        //用户名是否已存在
        if (userService.existUsername(username)) {
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
        else {
            userService.registUser(new User(null, username, password,email));
            req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
        }

    }
}
