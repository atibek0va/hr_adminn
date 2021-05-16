package com.example.hradmin.model;

public class Respond {
    String respond;
    String date;

    public Respond(){

    }

    public Respond(String respond, String date) {
        this.respond = respond;
        this.date = date;
    }

    public String getRespond() {
        return respond;
    }

    public void setRespond(String respond) {
        this.respond = respond;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
