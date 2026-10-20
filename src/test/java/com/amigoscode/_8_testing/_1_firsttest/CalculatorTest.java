package com.amigoscode._8_testing._1_firsttest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Exercise: Your First Unit Tests
 *
 * In this exercise you will write your first JUnit 5 tests for the Calculator class.
 * Complete each TODO to practice basic assertions and test lifecycle annotations.
 */
class CalculatorTest {

    // TODO: 1 - Declare a Calculator field and use @BeforeEach to create a fresh
    //  Calculator instance before each test. This ensures tests are independent.
    //  Hint: Write a setUp() method annotated with @BeforeEach that assigns
    //  a new Calculator() to your field.
    private Calculator underTest;
    @BeforeEach
    void setUp(){
        underTest  = new Calculator();
    }



    // TODO: 2 - Write a test for the add method using assertEquals.
    //  Annotate it with @Test and @DisplayName("2 + 3 should equal 5").
    //  Call calculator.add(2, 3) and assert the result equals 5.
    @Test
    @DisplayName("2 + 3 should equal 5")
    void canAddTwoNumbers(){
        int a = 2;
        int b = 3;
        int actual = underTest.add(a, b);
        int expected = 5;
        assertEquals(expected, actual);
    }


    // TODO: 3 - Write a test for the subtract method.
    //  Annotate with @Test and @DisplayName.
    //  Test that calculator.subtract(10, 4) equals 6.
    @Test
    @DisplayName("10 subtrscted by 6 is 4")
    void shouldSubtractNumber(){
        int a = 10;
        int b = 6;
        int actual = underTest.subtract(a, b);
        int expected = 4;
        assertEquals(expected,actual);
    }


    // TODO: 4 - Write a test for the multiply method.
    //  Annotate with @Test and @DisplayName.
    //  Test that calculator.multiply(3, 7) equals 21.
    @Test
    @DisplayName("3 multiplied by 7 is 21")
    void shouldMultiplyTwoNumbers(){
        int a = 3;
        int b = 7;
        int actual = underTest.multiply(a, b);
        int expected = 21;
        assertEquals(expected,actual);
    }




    // TODO: 5 - Write a test that verifies dividing by zero throws ArithmeticException.
    //  Use assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0)).
    //  Add a @DisplayName annotation.
    @Test
    @DisplayName("throw new ArithmeticException")
    void shouldThrowArithmeticException(){
        assertThrows(ArithmeticException.class, () -> underTest.divide(10,0));
    }


    // TODO: 6 - Write a test using assertNotEquals.
    //  Verify that calculator.add(2, 2) is NOT equal to 5.
    //  Add a @DisplayName annotation.
    @Test
    @DisplayName("2 + 2 not equal to 5")
    void shouldNotEqualToFive(){
        int a = 2;
        int b = 2;
        int actual = underTest.add(a, b);
        int expected = 5;
        assertNotEquals(expected,actual);
    }


    // TODO: 7 - Add @DisplayName annotations to ALL of your tests above (if not done already).
    //  Make the display names descriptive, e.g., "Adding 2 and 3 should return 5".
    //  Then write one more test: verify that calculator.divide(10, 2) equals 5.
    @Test
    @DisplayName("verify that calculator.divide(10, 2) equals 5")
    void shouldDivide(){
        int a = 10;
        int b = 2;
        int actual = underTest.divide(10, 2);
        int expected = 5;
        assertEquals(expected,actual);

    }

}
