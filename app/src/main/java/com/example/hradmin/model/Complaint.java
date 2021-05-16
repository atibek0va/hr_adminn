package com.example.hradmin.model;

public class Complaint {
    String complaint;
    String date;
    String email;

    public Complaint(){

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Complaint(String complaint, String date, String email) {
        this.complaint = complaint;
        this.date = date;
        this.email = email;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String question) {
        this.complaint = complaint;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
