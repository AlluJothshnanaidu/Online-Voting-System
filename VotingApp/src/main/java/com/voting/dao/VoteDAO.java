package com.voting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VoteDAO {

    // Check whether user already voted
    public boolean hasVoted(int voterId) {

        boolean voted = false;

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "SELECT voted FROM voters WHERE voter_id=?");

            ps.setInt(1, voterId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                if ("YES".equalsIgnoreCase(rs.getString("voted"))) {
                    voted = true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return voted;
    }

    // Save vote
    public boolean castVote(int voterId, int candidateId) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            // Insert vote
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO votes(voter_id,candidate_id) VALUES(?,?)");

            ps.setInt(1, voterId);
            ps.setInt(2, candidateId);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                // Update voter status
                PreparedStatement ps2 = con.prepareStatement(
                        "UPDATE voters SET voted='YES' WHERE voter_id=?");

                ps2.setInt(1, voterId);

                ps2.executeUpdate();

                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // Get all candidates
    public ResultSet getCandidates() {

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM candidates");

            return ps.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // Get voting results
    public ResultSet getResults() {

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "SELECT c.candidate_name, COUNT(v.vote_id) AS total_votes "
                    + "FROM candidates c "
                    + "LEFT JOIN votes v "
                    + "ON c.candidate_id = v.candidate_id "
                    + "GROUP BY c.candidate_id, c.candidate_name");

            return ps.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}