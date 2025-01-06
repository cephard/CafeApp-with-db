package com.example.cafesystem.Models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticatorTest {

    @BeforeEach
    void setUp() {
        // This method will be executed before each test
        // You can initialize any common resources here if needed.
    }

    @AfterEach
    void tearDown() {
        // This method will be executed after each test
        // Clean up or reset the test environment if needed.
    }

    @Test
    void testHarshPassword() {
        // Test input password
        String password = "password123";

        // Expected hashed value for "password123" using SHA-256
        String expectedHashedPassword = "ef92b778bafe771e89245b89ecbc08a44a4e166c06659911881f383d4473e94f"; // You should generate this manually or using a reliable tool

        // Call the method
        String hashedPassword = Authenticator.harshPassword(password);

        // Assert that the hashed password matches the expected value
        assertEquals(expectedHashedPassword, hashedPassword, "The hashed password should match the expected value.");
    }

    @Test
    void testHarshPasswordNullInput() {
        // Test null input (null password)
        assertThrows(NullPointerException.class, () -> {
            Authenticator.harshPassword(null);
        }, "Null password should throw a NullPointerException");
    }

    @Test
    void testHarshPasswordEmptyInput() {
        // Test empty input
        String password = "";
        String expectedHashedPassword = "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855"; // Expected hash for empty string

        // Call the method
        String hashedPassword = Authenticator.harshPassword(password);

        // Assert that the hashed password matches the expected value
        assertEquals(expectedHashedPassword, hashedPassword, "The hashed password for an empty string should match the expected value.");
    }
}
