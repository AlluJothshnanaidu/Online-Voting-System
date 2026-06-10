package com.voting.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.voting.dao.VoteDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/results")
public class ResultServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        VoteDAO dao = new VoteDAO();

        try {

            ResultSet rs = dao.getResults();

            List<String> results =
                    new ArrayList<>();

            while(rs.next()) {

                String data =
                        rs.getString("candidate_name")
                        + " - "
                        + rs.getInt("total_votes")
                        + " Votes";

                results.add(data);
            }

            request.setAttribute(
                    "results",
                    results);

            request.getRequestDispatcher(
                    "result.jsp")
                    .forward(request, response);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}