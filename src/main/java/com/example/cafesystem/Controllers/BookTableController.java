package com.example.cafesystem.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.time.LocalDate;
import java.time.LocalTime;

public class BookTableController {

    @FXML
    private ComboBox<String> tableTypeComboBox;

    @FXML
    private DatePicker datePicker;

    @FXML
    private ComboBox<String> startHourComboBox;

    @FXML
    private ComboBox<String> startMinuteComboBox;

    @FXML
    private ComboBox<String> endHourComboBox;

    @FXML
    private ComboBox<String> endMinuteComboBox;

    @FXML
    private Button bookButton;

    @FXML
    public void initialize() {
        // Set button action
        bookButton.setOnAction(event -> handleBooking());
    }

    private void handleBooking() {
        String tableType = tableTypeComboBox.getValue();
        LocalDate selectedDate = datePicker.getValue();
        LocalTime startTime = parseTime(startHourComboBox.getValue(), startMinuteComboBox.getValue());
        LocalTime endTime = parseTime(endHourComboBox.getValue(), endMinuteComboBox.getValue());

        if (tableType == null || selectedDate == null || startTime == null || endTime == null) {
            showAlert(AlertType.ERROR, "Incomplete Information", "Please fill all fields before booking.");
            return;
        }

        // Ensure the end time is after the start time
        if (!endTime.isAfter(startTime)) {
            showAlert(AlertType.ERROR, "Invalid Time", "End time must be after start time.");
            return;
        }

        // Get maximum booking duration for the selected table type
        int maxBookingHours = getMaxBookingHours(tableType);

        // Check if the booking duration is within the allowed range
        if (startTime.plusHours(maxBookingHours).isBefore(endTime)) {
            showAlert(AlertType.ERROR, "Booking Duration Exceeded",
                    String.format("The maximum booking duration for a %s table is %d hour(s).", tableType, maxBookingHours));
            return;
        }

        // Ensure the booking is within the same day
        if (selectedDate.isBefore(LocalDate.now()) || !isBookingSameDay(startTime, endTime)) {
            showAlert(AlertType.ERROR, "Invalid Booking Date", "Bookings must be within the same day and in the future.");
            return;
        }

        // Booking successful
        String message = String.format("Table Type: %s\nDate: %s\nStart Time: %s\nEnd Time: %s",
                tableType, selectedDate, startTime, endTime);
        showAlert(AlertType.INFORMATION, "Booking Successful", message);
    }

    private int getMaxBookingHours(String tableType) {
        return switch (tableType) {
            case "2 Seats" -> 1;
            case "4 Seats" -> 2;
            case "6 Seats" -> 3;
            case "10 Seats" -> 4;
            default -> 0;
        };
    }

    private LocalTime parseTime(String hour, String minute) {
        if (hour == null || minute == null) {
            return null;
        }
        try {
            int h = Integer.parseInt(hour);
            int m = Integer.parseInt(minute);
            return LocalTime.of(h, m);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private boolean isBookingSameDay(LocalTime startTime, LocalTime endTime) {
        return endTime.isAfter(startTime) && endTime.getHour() < 24;
    }

    private void showAlert(AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
