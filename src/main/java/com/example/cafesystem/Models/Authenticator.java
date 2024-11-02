package com.example.cafesystem.Models;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Authenticator {

    public static String harshPassword(String password) {
        try {
            // Create a MessageDigest instance for SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Hash the password and get the byte array
            byte[] hashedBytes = digest.digest(password.getBytes());

            // Convert a byte array to hexadecimal format
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString(); // Return the hashed password
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e); // Handle the exception appropriately
        }
    }

}
