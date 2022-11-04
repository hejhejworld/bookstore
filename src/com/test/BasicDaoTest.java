package com.test;

import com.dao.impl.BasicDao;
import com.entity.User;
import org.junit.Test;

public class BasicDaoTest {

    BasicDao basicDao = new BasicDao();

    @Test
    public void update() {
        String sql;
        sql = "insert into user values (?, ?, ?, ?)";
        System.out.println("row:" + basicDao.update(sql,3,"b","123","b@123.com"));
    }

    @Test
    public void querySingle() {
        String sql = "select userid, email from user where userid = ?";
        System.out.println(basicDao.querySingle(sql, User.class, 2));
    }

    @Test
    public void queryMultiple() {
        String sql = "select * from user";
        System.out.println(basicDao.queryMultiple(sql, User.class));
    }

    @Test
    public void queryScalar() {
        String sql = "select userid from user where userid = 1";
        System.out.println(basicDao.queryScalar(sql));
    }
}
