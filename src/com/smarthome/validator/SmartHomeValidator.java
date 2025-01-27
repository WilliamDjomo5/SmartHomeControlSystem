package com.smarthome.validator;

import java.util.Scanner;

public class SmartHomeValidator {

    /**
     * Validates scanner input to ensure it is an integer.
     *
     * @param scanner the Scanner object for user input
     * @return the boolean value of true if valid and false if invalid
     */
    public static boolean validateIntegerInput(Scanner scanner) {
        if (scanner.hasNextInt()) {
            return true;
        } else {
            System.out.println("Invalid input. Please select a number from the list.");
            scanner.next(); // Clear the invalid input
            return false;
        }
    }
    
    /**
     * Validates if the input is within a specified range.
     * @param input the user input
     * @param min the minimum valid value
     * @param max the maximum valid value
     * @return true if the input is within range, false otherwise
     */
    public static boolean validateRangeInput(int input, int min, int max) {
        if (input >= min && input <= max) {
            return true;
        } else {
            System.out.println("Invalid input. Please select a number between " + min + " and " + max + ".");
            return false;
        }
    }
}
