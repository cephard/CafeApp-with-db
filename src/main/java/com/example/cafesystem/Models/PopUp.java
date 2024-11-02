package com.example.cafesystem.Models;

public class PopUp {
    private static String title;
    private static String message;

    public PopUp(String title, String message) {
        PopUp.title = title;
        PopUp.message = message;
    }

    public static String getTitle() {
        return title;
    }

    public static void setPopTitle(String title) {
        PopUp.title = title;
    }

    public static String getMessage() {
        return message;
    }

    public static void setMessage(String message) {
        PopUp.message = message;
    }
}
