package com.example.cafesystem.Models;

import java.util.Date;

public class Staff extends User {
    private String role;
    private Date employmentDate;
    private int hours; // per week
    private double shiftLength; //in hours but may contain minutes
    private double salary;// per hour

    public Staff(String firstName, String lastName, String role, double shiftLength, int hours, int salary ){
        super(firstName, lastName);
        this.role = role;
        this.hours = hours;
        this.salary = salary;
        this.shiftLength = shiftLength;
        this.employmentDate = new Date();

    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public double getShiftLength() {
        return shiftLength;
    }

    public void setShiftLength(double shiftLength) {
        this.shiftLength = shiftLength;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
