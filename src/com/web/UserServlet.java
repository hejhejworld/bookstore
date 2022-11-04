package com.web;

import com.entity.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;
import com.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    public void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());
        String code = req.getParameter("code");

        HttpSession session = req.getSession();
        String KaptchaCode = (String) session.getAttribute("KAPTCHA_SESSION_KEY");

        if (!code.equalsIgnoreCase(KaptchaCode)) {
            req.setAttribute("errorMge", "验证码错误！");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }

        //用户名是否已存在
        if (userService.existUsername(username)) {
            //用户名已存在，回显信息
            req.setAttribute("username", username);
            req.setAttribute("password", req.getParameter("password"));
            req.setAttribute("repwd", req.getParameter("repwd"));
            req.setAttribute("email", req.getParameter("email"));
            req.setAttribute("errorMge", "用户名已被占用！");
            try {
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            userService.registUser(user);
            try {
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());

        if (userService.loginUser(user) == null) {
            req.setAttribute("errorMge", "用户名或密码错误");
            req.setAttribute("username", username);
            try {
                req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        //用户名密码正确
        } else {
            //发送Cookie，存活时间为一周
            Cookie usernameCookie = new Cookie("username", username);
            Cookie passwordCookie = new Cookie("password", password);
//            usernameCookie.setPath(req.getContextPath() + "/pages/user/login.jsp");
//            passwordCookie.setPath(req.getContextPath() + "/pages/user/login.jsp");
            usernameCookie.setMaxAge(60 * 60 * 24 * 7);
            passwordCookie.setMaxAge(60 * 60 * 24 * 7);
            resp.addCookie(usernameCookie);
            resp.addCookie(passwordCookie);

            //设置session，时长为30分钟，这里的时长是指浏览器不向服务器发送请求的时长
            HttpSession session = req.getSession();
            req.getSession().setMaxInactiveInterval(30);
            req.getSession().setAttribute("username", username);

            try {
                req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath() + "/pages/user/login.jsp");
    }
}
