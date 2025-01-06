package com.example.cafesystem.Models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Booking {
    private int bookingId;
    private Table table;
    private Customer customer; // Reference to the customer who booked the table
    private LocalDate bookingDate;
    private LocalTime startTime;
    private LocalTime endTime;

    public Booking(int bookingId, Table table, Customer customer, LocalDate bookingDate, LocalTime startTime, LocalTime endTime) {
        this.bookingId = bookingId;
        this.table = table;
        this.customer = customer;
        this.bookingDate = bookingDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Getters and Setters
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", table=" + table +
                ", customer=" + customer +
                ", bookingDate=" + bookingDate +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
