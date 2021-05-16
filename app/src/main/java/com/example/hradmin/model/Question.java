package com.example.hradmin.model;

public class Question {
    String question;
    String date;
    String email;

    public Question(){

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Question(String question, String date, String email) {
        this.question = question;
        this.date = date;
        this.email = email;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
