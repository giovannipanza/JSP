package com.example.test4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * This class can be used to initialize the database connection
 * viene creata manualmente stringa di connessione JDBC
 */
public class DatabaseConnection {
    protected static Connection initializeDatabase()
            throws SQLException, ClassNotFoundException
    {
        // Initialize all the information regarding
        // Database Connection
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql:// localhost:3306/";
        // Database name to access
        String dbName = "its_buzzi";
        // Database user and password
        String dbUsername = "root";
        String dbPassword = "root";

        Class.forName(dbDriver); // Load the driver
        Connection con = DriverManager.getConnection(dbURL + dbName,
                dbUsername,
                dbPassword);
        return con;
    }
}
// Path: src/main/java/HelloServlet.java
