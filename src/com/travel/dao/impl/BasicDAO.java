package com.travel.dao.impl;

import com.travel.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 李杨
 * @version 1.0
 */
public class BasicDAO<T>{
    private QueryRunner qr = new QueryRunner();

    // 开发通用dml方法，针对任意表
    public int update(String sql, Object... parameters){

        Connection connection = null;

        try {
            connection = JDBCUtilsByDruid.getConnection();
            int update = qr.update(connection, sql, parameters);
            return update;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }

    }

    // 返回多个对象，针对任意表

    /**
     * @param sql sql语句，可以有?
     * @param clazz 传入一个类的CLass对象比如Cart.class\
     * @param parameters 传入?的具体的值，可以是多个
     * @return 根据class返回对应的ArrayList集合
     */

    public List<T> queryMulti(String sql, Class<T> clazz, Object... parameters){

        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection,sql,new BeanListHandler<T>(clazz),parameters);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }

    }

    // 查询单行
    public T querySingle(String sql, Class<T> clazz, Object... parameters){

        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection,sql,new BeanHandler<T>(clazz),parameters);

        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }

    }

    // 返回单行单列
    public Object queryScalar(String sql, Object... parameters){

        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection,sql,new ScalarHandler(),parameters);

        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }

    }

}
