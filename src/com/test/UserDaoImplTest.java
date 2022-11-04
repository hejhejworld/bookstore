package com.test;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.entity.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoImplTest {

    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUsserByUsername() {
        System.out.println(userDao.queryUsserByUsername("admit"));
        System.out.println(userDao.queryUsserByUsername("admit123"));
    }

    @Test
    public void queryUserByusernameAndPassword() {
        System.out.println(userDao.queryUserByUsernameAndPassword("admit", "admit"));
        System.out.println(userDao.queryUserByUsernameAndPassword("admit", "admit1234"));
    }

    @Test
    public void saveUser() {
        User user = new User(null, "d", "123", "c@123.com");
        System.out.println(userDao.saveUser(user));
    }
}