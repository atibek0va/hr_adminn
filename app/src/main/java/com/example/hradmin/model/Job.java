package com.example.hradmin.model;

public class Job {
    String jobName;
    String jobSalary;
    String jobTime;

    public Job(){

    }

    public Job(String jobName, String jobSalary, String jobTime) {
        this.jobName = jobName;
        this.jobSalary = jobSalary;
        this.jobTime = jobTime;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobSalary() {
        return jobSalary;
    }

    public void setJobSalary(String jobSalary) {
        this.jobSalary = jobSalary;
    }

    public String getJobTime() {
        return jobTime;
    }

    public void setJobTime(String jobTime) {
        this.jobTime = jobTime;
    }
}
