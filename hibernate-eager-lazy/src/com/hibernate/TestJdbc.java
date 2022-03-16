package com.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/one-to-many-bi?useSSL=false";
        String user = "root";
        String password = "";

        try {
            System.out.println("Connecting to DB...");

            Connection conn = DriverManager.getConnection(url, user, password);

            System.out.println("Connection Successful!!" + conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
