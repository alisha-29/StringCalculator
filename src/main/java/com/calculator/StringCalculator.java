package com.calculator;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiterPattern = "[,\n]";
        if (numbers.startsWith("//")) {
            int delimiterEndIndex = numbers.indexOf("\n");
            String delimiter = numbers.substring(2, delimiterEndIndex);
            delimiterPattern = delimiter;
            numbers = numbers.substring(delimiterEndIndex + 1);
        }

        String[] tokens = numbers.split(delimiterPattern);
        int sum = 0;
        StringBuilder negativeNumbers = new StringBuilder();

        for (String token : tokens) {
            int num = Integer.parseInt(token);
            if (num < 0) {
                if (negativeNumbers.length() > 0) {
                    negativeNumbers.append(",");
                }
                negativeNumbers.append(num);
            } else {
                sum += num;
            }
        }

        if (negativeNumbers.length() > 0) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + negativeNumbers.toString());
        }

        return sum;
    }
}

