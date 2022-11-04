package com.dao.impl;

import com.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BasicDao {

    private QueryRunner queryRunner = new QueryRunner();

    //增删改操作
    public int update(String sql, Object... parameters) {

        Connection conn = JdbcUtils.getConnection();

        try {
            return queryRunner.update(conn, sql, parameters);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return -1;
    }

    //查询单行单列
    public Object queryScalar(String sql, Object... parameters) {

        Connection conn = JdbcUtils.getConnection();

        try {
            return queryRunner.query(conn, sql, new ScalarHandler(), parameters);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return null;
    }

    //查询单行
    public <T>T querySingle(String sql, Class<T> clazz, Object... parmeters) {

        Connection conn = JdbcUtils.getConnection();

        try {
            return queryRunner.query(conn, sql, new BeanHandler<T>(clazz), parmeters);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return null;
    }

    //查询多行
    public <T> List<T> queryMultiple(String sql, Class<T> clazz, Object... parameters) {

        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new BeanListHandler<T> (clazz), parameters);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return null;
    }

}
