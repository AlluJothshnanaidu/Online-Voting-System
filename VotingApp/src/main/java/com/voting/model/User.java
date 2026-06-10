package com.voting.model;

public class User {

    private int voterId;
    private String name;
    private String email;
    private String password;
    private String mobile;
    private String voted;

    // Default Constructor
    public User() {
    }

    // Parameterized Constructor
    public User(int voterId, String name, String email,
                String password, String mobile, String voted) {

        this.voterId = voterId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
        this.voted = voted;
    }

    // Getters
    public int getVoterId() {
        return voterId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getMobile() {
        return mobile;
    }

    public String getVoted() {
        return voted;
    }

    // Setters
    public void setVoterId(int voterId) {
        this.voterId = voterId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setVoted(String voted) {
        this.voted = voted;
    }

    @Override
    public String toString() {
        return "User [voterId=" + voterId +
               ", name=" + name +
               ", email=" + email +
               ", mobile=" + mobile +
               ", voted=" + voted + "]";
    }
}