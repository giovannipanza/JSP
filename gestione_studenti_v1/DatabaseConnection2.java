package com.example.test4;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DatabaseConnection2 {

    private static final String HOST = "localhost";
    private static final String PORT = "3306";
    private static final String DATABASE = "its_buzzi";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static MysqlDataSource getDataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName(HOST);
        dataSource.setPortNumber(Integer.parseInt(PORT));
        dataSource.setDatabaseName(DATABASE);
        dataSource.setUser(USERNAME);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }

}

