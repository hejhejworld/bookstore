package com.service.impl;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.entity.User;
import com.service.UserService;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    @Override
    public int registUser(User user) {
        return userDao.saveUser(user);
    }

    @Override
    public User loginUser(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existUsername(String username) {
        if (userDao.queryUsserByUsername(username) != null)
            return true;
        else return false;
    }
}
