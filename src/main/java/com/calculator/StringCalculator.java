package com.calculator;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiterPattern = "[,\n ]"; // Default delimiter is comma or newline.

        // Check for custom delimiter
        if (numbers.startsWith("//")) {
            int delimiterEndIndex = numbers.indexOf("\n");
            String delimiter = numbers.substring(2, delimiterEndIndex); // Custom delimiter
            delimiterPattern = "[\n" + delimiter + "]"; // Make the delimiter pattern to handle custom delimiters and newlines
            numbers = numbers.substring(delimiterEndIndex + 1); // Remaining numbers after delimiter
        }

        // Split numbers by the delimiter pattern
        String[] tokens = numbers.split(delimiterPattern);
        int sum = 0;
        StringBuilder negativeNumbers = new StringBuilder();

        for (String token : tokens) {
            token = token.trim(); // Remove any leading/trailing spaces
            if (!token.isEmpty()) { // Prevent empty tokens
                int num = Integer.parseInt(token); // Parse number
                if (num < 0) {
                    if (negativeNumbers.length() > 0) {
                        negativeNumbers.append(",");
                    }
                    negativeNumbers.append(num);
                } else {
                    sum += num;
                }
            }
        }

        if (negativeNumbers.length() > 0) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + negativeNumbers.toString());
        }

        return sum;
    }
}
