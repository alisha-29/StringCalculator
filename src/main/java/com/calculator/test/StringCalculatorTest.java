package com.calculator.test;

import com.calculator.StringCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {

    @Test
    public void testEmptyString() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void testSingleNumber() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(1, calculator.add("1"));
    }

    @Test
    public void testTwoNumbers() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("1,5"));
    }

    @Test
    public void testNewLineDelimiter() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test
    public void testCustomDelimiter() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.add("//;\n1;2"));
    }

    @Test
    public void testNegativeNumbers() {
        StringCalculator calculator = new StringCalculator();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("1,-2,3,-4");
        });
        assertEquals("Negative numbers not allowed: -2,-4", exception.getMessage());
    }

    @Test
    public void testMultipleNumbers() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(15, calculator.add("1,2,3,4,5"));
    }

    @Test
    public void testCustomDelimiterAndNewLine() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("//;\n1;2\n3"));
    }

    @Test
    public void testCustomDelimiterWithMultipleNumbers() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(10, calculator.add("//;\n1;2;3;4"));
    }

    @Test
    public void testNegativeNumbersMultiple() {
        StringCalculator calculator = new StringCalculator();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("-1,-5,-6");
        });
        assertEquals("Negative numbers not allowed: -1,-5,-6", exception.getMessage());
    }

    @Test
    public void testNewlineAndCommaDelimiters() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test
    public void testCustomDelimiterWithDifferentCharacters() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(10, calculator.add("//[***]\n1***2***3***4"));
    }

    @Test
    public void testMultipleCustomDelimiters() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("//[;][|]\n1;2|3"));
    }

    @Test
    public void testMultipleNumbersWithCustomDelimiterAndNewline() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(15, calculator.add("//;\n1;2\n3;4\n5"));
    }

    @Test
    public void testSingleLargeNumber() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(1000, calculator.add("1000"));
    }

    @Test
    public void testEmptyAfterDelimiterLine() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add("//;\n"));
    }

    @Test
    public void testSingleNegativeNumber() {
        StringCalculator calculator = new StringCalculator();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("-1");
        });
        assertEquals("Negative numbers not allowed: -1", exception.getMessage());
    }

    @Test
    public void testDelimitersWithSpecialCharacters() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(10, calculator.add("//[$]\n1$2$3$4"));
    }

    @Test
    public void testNoDelimiterInInput() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(15, calculator.add("1,2,3,4,5"));
    }

    @Test
    public void testCustomDelimiterWithEmptyNumbers() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add("//;\n"));
    }

    @Test
    public void testEmptyStringAfterDelimiterLine() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add("//;\n"));
    }

    @Test
    public void testCustomDelimiterWithLongNumbers() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(123, calculator.add("//;\n10;20;30;63"));
    }

    @Test
    public void testNumberLargerThanMaxInt() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(Integer.MAX_VALUE, calculator.add(String.valueOf(Integer.MAX_VALUE)));
    }

    @Test
    public void testLargeNumberWithCustomDelimiter() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(10005, calculator.add("//;\n10000;5"));
    }

/*    @Test
    public void testMultipleLinesWithCustomDelimiters() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(30, calculator.add("//;\n1;2\n3;4\n5;6"));
    }*/

    @Test
    public void testVeryLargeInput() {
        StringCalculator calculator = new StringCalculator();
        String input = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20";
        assertEquals(210, calculator.add(input));
    }

}
