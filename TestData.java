package com.practise;

import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider(name = "registrationData")
    public static Object[][] getRegistrationData() {
        return new Object[][] {
                {"John", "Doe", "john.doe@example.com", "password123", "20", "Aug", "2000", "Male"},
                {"Jane", "Smith", "jane.smith@example.com", "password456", "15", "Sep", "1995", "Female"},
                {"Alice", "Johnson", "alice.johnson@example.com", "password789", "10", "Oct", "1990", "Female"},
                {"Bob", "Brown", "bob.brown@example.com", "passwordabc", "25", "Nov", "1985", "Male"},
                {"Emily", "Davis", "emily.davis@example.com", "passwordxyz", "5", "Dec", "1980", "Female"}
        };
    }
}