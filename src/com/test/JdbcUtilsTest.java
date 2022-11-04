package com.test;

import com.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

public class JdbcUtilsTest {
    @Test
    public void testJdbcUtils() {
        Connection conn = JdbcUtils.getConnection();
        System.out.println(conn);
    }

}
