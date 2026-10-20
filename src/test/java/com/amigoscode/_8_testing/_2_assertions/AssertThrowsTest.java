package com.amigoscode._8_testing._2_assertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Exercise: Testing Exceptions with assertThrows
 *
 * Practice verifying that code throws the expected exceptions.
 * Learn to check exception types, messages, and the assertDoesNotThrow assertion.
 */
@DisplayName("Exception Assertion Tests")
class AssertThrowsTest {

    // TODO: 1 - Test that Integer.parseInt("abc") throws NumberFormatException.
    //  Use assertThrows(NumberFormatException.class, () -> Integer.parseInt("abc")).
    //  Store the returned exception in a variable.

    @Test
    @DisplayName("Integer.parseInt('abc') throws NumberFormatException")
    void IntegerParseIntThrowsNumberFormatException(){
        assertThrows(NumberFormatException.class, () -> Integer.parseInt("abc"));
    }


    // TODO: 2 - Verify the exception message contains expected text.
    //  Using the exception from TODO 1, call getMessage() on it.
    //  Use assertTrue to check the message contains "abc".
    //  Hint: exception.getMessage().contains("abc")
    @Test
    @DisplayName("NumberFormatException message contains abc")
    void doesNumberFormatExceptionMessageContainsabc(){
        NumberFormatException exception = assertThrows(
                NumberFormatException.class, () ->
                        Integer.parseInt("abc"));
        assertTrue(exception.getMessage().contains("abc"));

        //        assertThatThrownBy(() -> Integer.parseInt("abc"))
//                .isInstanceOf(NumberFormatException.class)
//                .hasMessageContaining("abc");

    }


    // TODO: 3 - Test that dividing by zero throws ArithmeticException.
    //  Use assertThrows to verify that the expression (1 / 0) throws ArithmeticException.
    //  Hint: assertThrows(ArithmeticException.class, () -> { int result = 1 / 0; });
    @Test
    @DisplayName("dividing by zero throws ArithmeticException")
    void divideByZeroThrowsArithmeticException(){
        assertThrows(ArithmeticException.class, () -> {
            int result = 1 / 0;
        });
    }


    // TODO: 4 - Test that a custom exception is thrown.
    //  Create a lambda that throws new IllegalStateException("Invalid state").
    //  Use assertThrows to catch it and verify the message equals "Invalid state".
    //  Hint: assertThrows(IllegalStateException.class, () -> {
    //      throw new IllegalStateException("Invalid state");
    //  });
    @Test
    @DisplayName("custom exception is thrown")
    void canThrowCustomException(){
        assertThrows(IllegalStateException.class, () -> {
            throw new IllegalStateException("Invalid state");
        });
    }


    // TODO: 5 - Use assertDoesNotThrow to verify valid input does NOT throw.
    //  Wrap Integer.parseInt("123") in assertDoesNotThrow.
    //  Wrap Integer.parseInt("0") in assertDoesNotThrow.
    //  Hint: assertDoesNotThrow(() -> Integer.parseInt("123"));
    @Test
    @DisplayName("verify valid input does NOT throw")
    void ValidInputDoesNotThrow(){
        assertDoesNotThrow(() -> Integer.parseInt("123"));
        assertDoesNotThrow(() -> Integer.parseInt("0"));
    }


    // TODO: 6 - Test exception type hierarchy.
    //  NumberFormatException extends IllegalArgumentException.
    //  Verify that Integer.parseInt("abc") can be caught as IllegalArgumentException.
    //  Also verify it can be caught as RuntimeException.
    //  Use assertThrows for each check.
    @Test
    @DisplayName("Integer.parseInt(\"abc\") can be caught as IllegalArgumentException")
    void canBeCaughtAsIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, () -> Integer.parseInt("abc"));

    }


}
