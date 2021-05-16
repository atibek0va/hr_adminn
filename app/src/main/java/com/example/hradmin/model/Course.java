package com.example.hradmin.model;

public class Course {
    String courseName;
    String courseUniver;

    public Course(){}

    public Course(String courseName, String courseUniver) {
        this.courseName = courseName;
        this.courseUniver = courseUniver;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseUniver() {
        return courseUniver;
    }

    public void setCourseUniver(String courseUniver) {
        this.courseUniver = courseUniver;
    }
}
