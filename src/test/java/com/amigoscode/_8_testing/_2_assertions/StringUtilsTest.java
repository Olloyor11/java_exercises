package com.amigoscode._8_testing._2_assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Exercise: JUnit 5 Assertions
 * <p>
 * Practice using different JUnit 5 assertion methods to test the StringUtils class.
 * Each TODO requires a different assertion type.
 */
@DisplayName("StringUtils Tests")
class StringUtilsTest {

    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    // TODO: 1 - Test isPalindrome using assertTrue and assertFalse.
    //  Assert that "racecar" is a palindrome (assertTrue).
    //  Assert that "hello" is NOT a palindrome (assertFalse).
    //  Assert that "A man a plan a canal Panama" is a palindrome (assertTrue).
    @Test
    @DisplayName("Is Input Palindrome")
    void canCheckIsPalindrome() {
        String input = "racecar";
        boolean actual = stringUtils.isPalindrome(input);
        assertTrue(actual);
    }

    @Test
    @DisplayName("Is Input not Palindrome")
    void canCheckIsNotPalindrome() {
        String input = "hello";
        boolean actual = stringUtils.isPalindrome(input);
        assertFalse(actual);
    }

    @Test
    @DisplayName("Is Input Palindrome")
    void canCheckIfIsPalindrome() {
        String input = "A man a plan a canal Panama";
        boolean actual = stringUtils.isPalindrome(input);
        assertTrue(actual);
    }


    // TODO: 2 - Test reverse using assertEquals.
    //  Assert that reversing "hello" returns "olleh".
    //  Assert that reversing "Java" returns "avaJ".
    //  Assert that reversing "" (empty string) returns "".
    @ParameterizedTest
    @CsvSource({
            "hello, olleh",
            "Java, avaJ",
            "'', ''"
    })
    void canReverse(String input, String expected) {
        String actual = stringUtils.reverse(input);
        assertEquals(expected, actual);
    }


    // TODO: 3 - Test capitalize using assertEquals.
    //  Assert that capitalizing "hello" returns "Hello".
    //  Assert that capitalizing "java" returns "Java".
    //  Assert that capitalizing "" (empty string) returns "".
    @ParameterizedTest
    @CsvSource({
            "hello, Hello",
            "java, Java",
            "'', ''"
    })
    void canCapitalize(String input, String expected) {
        String actual = stringUtils.capitalize(input);
        assertEquals(expected, actual);
    }


    // TODO: 4 - Test isEmpty with various inputs including a null check.
    //  Assert that isEmpty(null) returns true (assertTrue).
    //  Assert that isEmpty("") returns true.
    //  Assert that isEmpty("   ") returns true (whitespace only).
    //  Assert that isEmpty("hello") returns false (assertFalse).
    @Test
    void canCheckIfNullIsEmpty() {
        String input = null;
        boolean actual = stringUtils.isEmpty(input);
        assertTrue(actual);
    }

    @Test
    void shouldCheckIfEmptyStringIsEmpty() {
        String input = "";
        boolean actual = stringUtils.isEmpty(input);
        assertTrue(actual);
    }

    @Test
    void shouldCheckIfWhiteSpaceIsEmpty() {
        String input = "     ";
        boolean actual = stringUtils.isEmpty(input);
        assertTrue(actual);
    }

    @Test
    void shouldCheckIfStringIsEmpty() {
        String input = "hello";
        boolean actual = stringUtils.isEmpty(input);
        assertFalse(actual);
    }


    // TODO: 5 - Test countVowels using assertEquals.
    //  Assert that countVowels("hello") returns 2.
    //  Assert that countVowels("AEIOU") returns 5.
    //  Assert that countVowels("xyz") returns 0.
    @ParameterizedTest
    @CsvSource({
            "hello, 2",
            "AEIOU, 5",
            "xyz, 0"
    })
    void shouldCountVowels(String input, int expected) {
        int actual = stringUtils.countVowels(input);
        assertEquals(expected, actual);
    }


    // TODO: 6 - Use assertAll to group multiple related assertions together.
    //  Group at least 3 assertions about the reverse method into a single assertAll call.
    //  Example: assertAll(
    //      () -> assertEquals("olleh", stringUtils.reverse("hello")),
    //      () -> assertEquals("avaJ", stringUtils.reverse("Java")),
    //      () -> assertEquals("", stringUtils.reverse(""))
    //  );
    @Test
    void assertingAll() {
        assertAll(() -> assertEquals("olleh", stringUtils.reverse("hello")),
                  () -> assertEquals("avaJ", stringUtils.reverse("Java")),
                  () -> assertEquals("", stringUtils.reverse("")));
    }


    // TODO: 7 - Test that passing null input to methods throws IllegalArgumentException.
    //  Use assertThrows to verify that isPalindrome(null) throws IllegalArgumentException.
    //  Use assertThrows to verify that reverse(null) throws IllegalArgumentException.
    //  Use assertThrows to verify that countVowels(null) throws IllegalArgumentException.
    @Test
    void shouldThrowIllegalArgumentExceptionWhenPassedNullInputToIsPalindrome(){
        assertThrows(IllegalArgumentException.class, () -> stringUtils.isPalindrome(null));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenPassedNullInputToReverse(){
        assertThrows(IllegalArgumentException.class, () -> stringUtils.reverse(null));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenPassedNullInputToCountVowels(){
        assertThrows(IllegalArgumentException.class, () -> stringUtils.countVowels(null));
    }

}
