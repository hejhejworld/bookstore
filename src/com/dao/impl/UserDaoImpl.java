package com.dao.impl;

import com.dao.UserDao;
import com.entity.User;

public class UserDaoImpl extends BasicDao implements UserDao {

    @Override
    public User queryUsserByUsername(String username) {
        String sql;

        sql = "select userid, username, password, email from user where username = ?";
        return querySingle(sql, User.class, username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql;

        sql = "select userid, username, password, email from user where username = ? and password = ?";
        return querySingle(sql, User.class, username, password);
    }

    @Override
    public int saveUser(User user) {
        String sql;

        sql = "insert into user(username, password, email) values (?, ?, ?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }
}
