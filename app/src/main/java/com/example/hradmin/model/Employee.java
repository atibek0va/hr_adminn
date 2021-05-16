package com.example.hradmin.model;

public class Employee {
    String employeeName;
    String employeeSpecial;
    String employeeIIN;
    String employeeNumber;
    String employeeAddress;
    String employeeEmail;
    String employeePassword;

    String employeeWorkingHour;
    String employeeCuratorship;
    String employeeAddworks;

    public  Employee(){}

    public Employee(String employeeName, String employeeSpecial, String employeeIIN, String employeeNumber, String employeeAddress, String employeeEmail, String employeePassword, String employeeWorkingHour, String employeeCuratorship, String employeeAddworks) {
        this.employeeName = employeeName;
        this.employeeSpecial = employeeSpecial;
        this.employeeIIN = employeeIIN;
        this.employeeNumber = employeeNumber;
        this.employeeAddress = employeeAddress;
        this.employeeEmail = employeeEmail;
        this.employeePassword = employeePassword;

        this.employeeWorkingHour = employeeWorkingHour;
        this.employeeCuratorship = employeeCuratorship;
        this.employeeAddworks = employeeAddworks;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeSpecial() {
        return employeeSpecial;
    }

    public void setEmployeeSpecial(String employeeSpecial) {
        this.employeeSpecial = employeeSpecial;
    }

    public String getEmployeeIIN() {
        return employeeIIN;
    }

    public void setEmployeeIIN(String employeeIIN) {
        this.employeeIIN = employeeIIN;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }
    public String getEmployeeWorkingHour() {
        return employeeWorkingHour;
    }

    public void setEmployeeWorkingHour(String employeeWorkingHour) {
        this.employeeWorkingHour = employeeWorkingHour;
    }

    public String getEmployeeCuratorship() {
        return employeeCuratorship;
    }

    public void setEmployeeCuratorship(String employeeCuratorship) {
        this.employeeCuratorship = employeeCuratorship;
    }

    public String getEmployeeAddworks() {
        return employeeAddworks;
    }

    public void setEmployeeAddworks(String employeeAddworks) {
        this.employeeAddworks = employeeAddworks;
    }
}
