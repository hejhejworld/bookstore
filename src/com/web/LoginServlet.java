package com.web;

import com.entity.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        req.setAttribute("errorMge", "用户名或密码错误");
        req.setAttribute("username", username);

        if (userService.loginUser(new User(null, username, password, null)) == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
    }
}
