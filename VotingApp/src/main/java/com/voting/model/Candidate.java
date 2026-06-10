package com.voting.model;

public class Candidate {

    private int candidateId;
    private String candidateName;
    private String partyName;

    // Default Constructor
    public Candidate() {
    }

    // Parameterized Constructor
    public Candidate(int candidateId, String candidateName, String partyName) {
        this.candidateId = candidateId;
        this.candidateName = candidateName;
        this.partyName = partyName;
    }

    // Getter Methods
    public int getCandidateId() {
        return candidateId;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public String getPartyName() {
        return partyName;
    }

    // Setter Methods
    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    @Override
    public String toString() {
        return "Candidate [candidateId=" + candidateId +
               ", candidateName=" + candidateName +
               ", partyName=" + partyName + "]";
    }
}