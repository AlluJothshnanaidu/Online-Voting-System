package com.voting.dao;

import java.sql.*;

public class DBConnection {

    private static final String URL =
        "jdbc:mysql://localhost:3306/online_voting_system";

    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    URL, USER, PASSWORD);

        } catch(Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}