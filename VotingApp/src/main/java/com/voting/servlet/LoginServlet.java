package com.voting.servlet;

import java.io.IOException;
import java.sql.ResultSet;

import com.voting.dao.UserDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String email =
                request.getParameter("email");

        String password =
                request.getParameter("password");

        UserDAO dao = new UserDAO();

        try {

            ResultSet rs =
                    dao.loginUser(email, password);

            if (rs != null && rs.next()) {

                HttpSession session =
                        request.getSession();

                session.setAttribute(
                        "voterId",
                        rs.getInt("voter_id"));

                session.setAttribute(
                        "name",
                        rs.getString("name"));

                response.sendRedirect("vote.jsp");

            } else {

                response.getWriter().println(
                        "<h3>Invalid Email or Password</h3>");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}