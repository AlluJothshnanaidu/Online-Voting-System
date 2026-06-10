package com.voting.dao;

import java.sql.*;

public class UserDAO {
	
	

    public boolean registerUser(
            String name,
            String email,
            String password,
            String mobile) {

        boolean status = false;

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(
                            "insert into voters(name,email,password,mobile) values(?,?,?,?)");

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, mobile);

            int rows = ps.executeUpdate();

            if(rows > 0)
                status = true;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public ResultSet loginUser(
            String email,
            String password) {

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(
                            "select * from voters where email=? and password=?");

            ps.setString(1, email);
            ps.setString(2, password);

            return ps.executeQuery();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}