package com.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 使用druid连接池连接数据库，
 * 数据库事务是基于Connection连接的
 * 为了保证操作的是同一个数据库连接，使用线程局部变量保存数据库连接
 */
public class JdbcUtils {

    private static DataSource dataSource;
    private static ThreadLocal<Connection> conn = new ThreadLocal<Connection>();

    //    static {
//        Properties properties = new Properties();
//        try {
//            properties.load(new FileInputStream("E:\\ideaWorkSpace\\bookstore\\src\\druid.properties"));
//            dataSource = (DruidDataSource)DruidDataSourceFactory.createDataSource(properties);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    static {
        try {
            Properties properties = new Properties();
            // 读取 jdbc.properties属性配置文件
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            // 从流中加载数据
            properties.load(inputStream);
            // 创建 数据库连接 池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() {

        Connection conn = JdbcUtils.conn.get();

        if (conn == null) {
            try {
                conn = dataSource.getConnection();
                JdbcUtils.conn.set(conn);
                //设为手动管理事务
                conn.setAutoCommit(false);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return conn;
    }

    public static void commitAndClose() {

        Connection conn = JdbcUtils.conn.get();

        if (conn != null) {
            try {
                conn.commit();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        JdbcUtils.conn.remove();
    }

    public static void rollbcakAndClose() {

        Connection conn = JdbcUtils.conn.get();

        if (conn != null) {
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        JdbcUtils.conn.remove();
    }

}
