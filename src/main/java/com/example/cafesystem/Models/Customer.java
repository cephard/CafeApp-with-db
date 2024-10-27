package com.example.cafesystem.Models;

import javafx.scene.control.DatePicker;

import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;

public class Customer {
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private int phoneNumber;
    private Date dateOfBirth;
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(DatePicker dateOfBirthPicker) {
        LocalDate localDate = dateOfBirthPicker.getValue();
        if (localDate != null) {
            this.dateOfBirth = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        } else {
            this.dateOfBirth = null;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", dateOfBirth=" + dateOfBirth +
                ", password='" + password + '\'' +
                '}';
    }

}
