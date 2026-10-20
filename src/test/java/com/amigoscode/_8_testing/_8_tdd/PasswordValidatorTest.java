package com.amigoscode._8_testing._8_tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Exercise: Test-Driven Development (TDD) - Password Validator
 * <p>
 * In this exercise you practice the TDD cycle: RED -> GREEN -> REFACTOR.
 * <p>
 * Instructions:
 * 1. Write each test FIRST (they will fail - RED phase)
 * 2. Then implement PasswordValidator.isValid() to make each test pass (GREEN phase)
 * 3. Refactor the implementation if needed (REFACTOR phase)
 * <p>
 * Password rules:
 * - Must be at least 8 characters long
 * - Must contain at least one uppercase letter
 * - Must contain at least one lowercase letter
 * - Must contain at least one digit
 * - Must contain at least one special character (!@#$%^&*()_+-=)
 * - Null password should throw IllegalArgumentException
 * - Empty password should return false
 */
@DisplayName("TDD: Password Validator Tests")
class PasswordValidatorTest {

    private PasswordValidator passwordValidator;

    @BeforeEach
    void setUp() {
        passwordValidator = new PasswordValidator();
    }

    // TODO: 1 - Write a test: password must be at least 8 characters long.
    //  Assert that isValid("Ab1!xyz") returns false (only 7 chars).
    //  Assert that isValid("Ab1!xyzw") returns true (8 chars, meets all rules).
    //  Then implement the length check in PasswordValidator.
    @ParameterizedTest
    @CsvSource({
            "Ab1!xyz, false",
            "Ab1!xyzw, true"
    })
    void canCheckIfPasswordContains8Chars(String password, boolean expected) {
        assertThat(passwordValidator.isValid(password)).isEqualTo(expected);
    }


    // TODO: 2 - Write a test: password must contain at least one uppercase letter.
    //  Assert that isValid("abcdefg1!") returns false (no uppercase).
    //  Then update PasswordValidator to check for uppercase letters.
    @Test
    void canPasswordContainAtLeastOneUpperCaseLetter() {
        String password = "abcdefg1!";

        boolean actual = passwordValidator.isValid(password);
        assertFalse(actual);
    }


    // TODO: 3 - Write a test: password must contain at least one lowercase letter.
    //  Assert that isValid("ABCDEFG1!") returns false (no lowercase).
    //  Then update PasswordValidator to check for lowercase letters.
    @Test
    void canPasswordContainAtLeastOneLowerCaseLetter() {
        String password = "ABCDEFG1!";

        boolean actual = passwordValidator.isValid(password);
        assertFalse(actual);
    }


    // TODO: 4 - Write a test: password must contain at least one digit.
    //  Assert that isValid("Abcdefgh!") returns false (no digit).
    //  Then update PasswordValidator to check for digits.
    @Test
    void canPasswordContainAtLeastOneDigit() {
        String password = "Abcdefgh!";

        boolean actual = passwordValidator.isValid(password);
        assertFalse(actual);
    }


    // TODO: 5 - Write a test: password must contain at least one special character.
    //  Assert that isValid("Abcdefg1") returns false (no special char).
    //  Then update PasswordValidator to check for special characters.
    @Test
    void canPasswordContainAtLeastOneSpecialChar() {
        String password = "Abcdefg1";

        boolean actual = passwordValidator.isValid(password);
        assertFalse(actual);
    }


    // TODO: 6 - Write a test: null password should throw IllegalArgumentException.
    //  Use assertThrows(IllegalArgumentException.class,
    //      () -> passwordValidator.isValid(null));
    //  Then update PasswordValidator to handle null input.
    @Test
    void canNullPasswordThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> passwordValidator.isValid(null));
    }


    // TODO: 7 - Write a test: empty password should return false.
    //  Assert that isValid("") returns false.
    //  This should already pass if length check is implemented correctly.
    @Test
    void canEmptyPasswordReturnFalse() {
        String password = "";

        boolean actual = passwordValidator.isValid(password);
        assertFalse(actual);
    }


    // TODO: 8 - Write a test: a fully valid password should return true.
    //  Test several valid passwords:
    //  "Password1!" -> true
    //  "Str0ng@Pass" -> true
    //  "MyP@ssw0rd" -> true
    //  Use assertAll to group these assertions.
   @Test
    void fullyValidPasswordCheck(){
        assertAll(
                () -> assertTrue(passwordValidator.isValid("Password1!")),
                () -> assertTrue(passwordValidator.isValid("Str0ng@Pass")),
                () -> assertTrue(passwordValidator.isValid("MyP@ssw0rd"))
        );
    }

        }
