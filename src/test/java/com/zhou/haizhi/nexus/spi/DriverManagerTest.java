package com.zhou.haizhi.nexus.spi;

import org.junit.Test;

import java.sql.*;

/**
 * Create by zhoumingbing on 2019-12-29
 */
public class DriverManagerTest {

    @Test
    public void driver() throws SQLException {
        String url = "jdbc:mysql://60.205.176.135:3306/test";
        String user = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, user, password);
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet schemas = metaData.getSchemas();
        System.out.println(schemas.getFetchSize());
        System.out.println(metaData.getTableTypes());
    }
}
