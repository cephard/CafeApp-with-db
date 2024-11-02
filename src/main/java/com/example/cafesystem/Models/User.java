package com.example.cafesystem.Models;

import javafx.scene.control.DatePicker;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;

public class User {
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private Long phoneNumber;
    private Date dateOfBirth;
    private String password;

    public User(){

    }

    public User(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
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

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", dateOfBirth=" + dateOfBirth +
                ", password='" + password + '\'' +
                '}';
    }

    public HashMap<String, Object> userSet() {
        HashMap<String, Object>user = new HashMap<String, Object>();
        user.put("first_name", firstName);
        user.put("last_name",lastName);
        user.put("email",email);
        user.put("date_of_birth",dateOfBirth.toString());
        user.put("phone_number",phoneNumber);
        user.put("address",address);
        user.put("password",password);
        return user;
    }
}
