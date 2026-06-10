package com.voting.servlet;

import java.io.IOException;

import com.voting.dao.VoteDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/vote")
public class VoteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
                request.getSession(false);

        if (session == null) {

            response.getWriter().println(
                    "<h3>Please Login First!</h3>");

            return;
        }

        try {

            int voterId =
                    (Integer) session.getAttribute("voterId");

            int candidateId =
                    Integer.parseInt(
                            request.getParameter("candidate"));

            VoteDAO dao = new VoteDAO();

            // Check already voted
            if (dao.hasVoted(voterId)) {

                response.getWriter().println(
                        "You have already voted!");

                return;
            }

            // Cast Vote
            boolean status =
                    dao.castVote(voterId, candidateId);

            if (status) {

                response.getWriter().println(
                        "<h2>Vote Cast Successfully!</h2>");

                response.getWriter().println(
                        "<a href='results'>View Results</a>");

            } else {

                response.getWriter().println(
                        "<h3>Failed to Cast Vote!</h3>");
            }

        } catch (Exception e) {

            e.printStackTrace();

            response.getWriter().println(
                    "<h3>Something went wrong!</h3>");
        }
    }
}