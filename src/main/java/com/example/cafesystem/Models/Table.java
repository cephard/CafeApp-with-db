package com.example.cafesystem.Models;

import java.util.HashMap;

public class Table {
    private int tableId;
    private int seats;
    private int maxBookingHours;
    private String tableType; // e.g., "2 Seats", "4 Seats", etc.

    public Table() {
        // Default constructor
    }

    public Table(int tableId, int seats, int maxBookingHours, String tableType) {
        this.tableId = tableId;
        this.seats = seats;
        this.maxBookingHours = maxBookingHours;
        this.tableType = tableType;
    }

    // Getters and Setters
    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getMaxBookingHours() {
        return maxBookingHours;
    }

    public void setMaxBookingHours(int maxBookingHours) {
        this.maxBookingHours = maxBookingHours;
    }

    public String getTableType() {
        return tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

    @Override
    public String toString() {
        return "Table{" +
                "tableId=" + tableId +
                ", seats=" + seats +
                ", maxBookingHours=" + maxBookingHours +
                ", tableType='" + tableType + '\'' +
                '}';
    }

    public HashMap<String, Object> tableSet() {
        HashMap<String, Object> table = new HashMap<>();
        table.put("table_id", tableId);
        table.put("seats", seats);
        table.put("max_booking_hours", maxBookingHours);
        table.put("table_type", tableType);
        return table;
    }
}
