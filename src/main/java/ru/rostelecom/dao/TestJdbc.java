package ru.rostelecom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @since 0.1
 */
public class TestJdbc {
    public static void main(String[] args) {

        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:oracle";
        String userName = "smith";
        String password = "password";
        //String driver = "oracle.jdbc.driver.OracleDriver";

        System.out.println("Connection to DB: " + jdbcUrl);

        try (Connection myConn =
                        DriverManager.getConnection(jdbcUrl, userName, password)) {
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
