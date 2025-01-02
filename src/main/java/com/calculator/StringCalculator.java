package com.calculator;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        StringBuilder negativeNumbers = new StringBuilder();
        if (numbers.startsWith("//")) {
            String delimiter = numbers.substring(2, numbers.indexOf("\n"));
            numbers = numbers.substring(numbers.indexOf("\n") + 1);
            String[] parts = numbers.split(delimiter);
            int sum = 0;
            for (String part : parts) {
                int num = Integer.parseInt(part);
                if (num < 0) {
                    negativeNumbers.append(part).append(",");
                } else {
                    sum += num;
                }
            }
            if (negativeNumbers.length() > 0) {
                throw new IllegalArgumentException("Negative numbers not allowed: " + negativeNumbers.substring(0, negativeNumbers.length() - 1));
            }
            return sum;
        }
        String[] parts = numbers.split("[,\n]");
        int sum = 0;
        for (String part : parts) {
            int num = Integer.parseInt(part);
            if (num < 0) {
                negativeNumbers.append(part).append(",");
            } else {
                sum += num;
            }
        }
        if (negativeNumbers.length() > 0) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + negativeNumbers.substring(0, negativeNumbers.length() - 1));
        }
        return sum;
    }
}
