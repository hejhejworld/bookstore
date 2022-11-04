package com.test;

import com.entity.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;
import org.junit.Test;

public class UserServiceImplTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void registUser() {
        User user = new User(null, "e", "123", "e@123.com");
        System.out.println(userService.registUser(user));
    }

    @Test
    public void loginUser() {
        System.out.println(userService.loginUser(new User
                (null, "admit", "admit", "admit@123.com")));
    }

    @Test
    public void existUsername() {
        System.out.println(userService.existUsername("admit"));
    }
}