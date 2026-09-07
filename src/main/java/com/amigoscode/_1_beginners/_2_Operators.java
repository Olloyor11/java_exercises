package com.amigoscode._1_beginners;

/**
 * Exercise: Operators
 *
 * Learn how to use arithmetic, comparison, logical, and other operators in Java.
 * Operators allow you to perform operations on variables and values.
 */
public class _2_Operators {

    public static void main(String[] args) {

        // TODO: 1 - Use arithmetic operators (+, -, *, /) on two int variables and print the results
        // Declare two int variables (e.g., a = 10, b = 3)
        // Print the result of a + b, a - b, a * b, and a / b
        System.out.println("To Do 1: ");
        int a = 25;
        int b = 5;
        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);
        System.out.println();


        // TODO: 2 - Use the modulus operator (%) to check if a number is even
        System.out.println("To Do 2: ");
        // Declare an int variable called number with any value.
        // Print the result of number % 2
        // Print whether the number is even (result is 0) or odd (result is 1)
        int number = 13;
        System.out.println(number % 2);
        System.out.println();


        // TODO: 3 - Use increment (++) and decrement (--) operators
        // Declare an int variable called counter, set it to 5
        // Use counter++ and print the result, then use counter-- and print the result
        System.out.println("To Do 3: ");
        int counter = 5;
        counter++;
        System.out.println(counter);
        counter--;
        System.out.println(counter);
        System.out.println();


        // TODO: 4 - Use compound assignment operators (+=, -=, *=)
        // Declare an int variable called score, set it to 10
        // Use +=, -=, and *= on score, printing after each operation
        System.out.println("To Do 4: ");
        int score = 10;
        score -= 5;
        System.out.println(score);
        score += 5;
        System.out.println(score);
        score *= 5;
        System.out.println(score);
        score /= 5;
        System.out.println(score);
        System.out.println();


        // TODO: 5 - Use comparison operators (==, !=, >, <, >=, <=) and print the boolean results
        // Declare two int variables (e.g., x = 5, y = 10)
        // Print the result of each comparison, e.g.: System.out.println("x == y: " + (x == y));
        System.out.println("To Do 5: ");
        int x = 15;
        int y = 20;
        System.out.println("X == Y: " + (x == y));
        System.out.println("X != Y: " + (x != y));
        System.out.println("X < Y: " + (x < y));
        System.out.println("X > Y: " + (x > y));
        System.out.println("X <= Y: " + (x <= y));
        System.out.println("X >= Y: " + (x >= y));
        System.out.println();







        // TODO: 6 - Use logical operators (&&, ||, !) to combine conditions
        // Declare two boolean variables (e.g., hasLicense = true, hasInsurance = false)
        // Print the result of: hasLicense && hasInsurance
        // Print the result of: hasLicense || hasInsurance
        // Print the result of: !hasLicense
        System.out.println("To Do 6: ");
        boolean hasLicense = true;
        boolean hasInsurance = false;
        System.out.println("hasLicense && hasInsurance : " + (hasLicense && hasInsurance));
        System.out.println("hasLicense || hasInsurance : " + (hasLicense || hasInsurance));
        System.out.println("!hasLicense : " + !hasLicense);
        System.out.println();


        // TODO: 7 - Use the ternary operator to assign "adult" or "minor" based on age
        // Declare an int variable called age with any value
        // Use the ternary operator: String status = (condition) ? "adult" : "minor";
        // Print the status
        System.out.println("To Do 7: ");
        int age = 23;
        String status = (18 < age) ? "adult" : "minor";
        System.out.println(status);
        System.out.println();

    }
}
