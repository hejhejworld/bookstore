package com.dao;

import com.entity.User;

public interface UserDao {

    /**
     * 根据用户名查询用户是否存在
     * @param username
     * @return 用户存在返回对应User，不存在返回null
     */
    public User queryUsserByUsername(String username);

    /**
     * 根据用户名和密码查询
     * @param username
     * @param password
     * @return 存在返回对应User，不存在返回null
     */
    public User queryUserByUsernameAndPassword(String username, String password);

    /**
     * 保存用户信息
     * @param user
     * @return 成功返回影响行数，失败返回-1
     */
     public int saveUser(User user);
}
