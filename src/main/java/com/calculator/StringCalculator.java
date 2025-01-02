package com.calculator;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        // Split the string by commas
        String[] parts = numbers.split(",");
        int sum = 0;
        for (String part : parts) {
            // Convert each part to an integer and add to sum
            sum += Integer.parseInt(part);
        }
        return sum;
    }
}
