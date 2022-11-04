package com.service;


import com.entity.User;

public interface UserService {
    /**
     * 注册
     * @param user
     */
    public int registUser(User user);

    /**
     * 登录
     * @param user
     * @return
     */
    public User loginUser(User user);

    /**
     * 注册时检查用户名是否已存在
     * @param username
     * @return
     */
    public boolean existUsername(String username);
}
