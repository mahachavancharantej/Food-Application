package com.tap.utitity;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {

    private static final String URL = "jdbc:mysql://localhost:3306/foodapp";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Thejesh@1421u";

    public static Connection getconnection() {

        Connection con = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            System.out.println("Database Connected Successfully");

        } catch (Exception e) {
            System.out.println("Database Connection Failed");
            e.printStackTrace();
        }
        return con;
    }
}