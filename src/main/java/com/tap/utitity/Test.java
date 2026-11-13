package com.tap.utitity;

import java.sql.Connection;

public class Test {

    public static void main(String[] args) {

        Connection con = DBconnection.getconnection();

        if (con != null) {
            System.out.println("Database Connected Successfully!");
        } else {
            System.out.println("Connection Failed!");
        }
    }
}
