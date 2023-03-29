package com.travel.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author 李杨
 * @version 1.0
 * 基于 德鲁伊 的数据库连接池的工具类
 */
public class JDBCUtilsByDruid {
    private static DataSource ds;

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src\\druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    // 关闭连接
    // 这里的close是将连接放回连接池
    public static void close(ResultSet set, Statement statement, Connection connection){
        try {
            if (set!=null){
                set.close();
            }
            if (statement!=null){
                statement.close();
            }
            if (connection!=null){
                connection.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
