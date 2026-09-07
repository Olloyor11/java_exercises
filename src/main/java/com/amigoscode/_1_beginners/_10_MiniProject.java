package com.amigoscode._1_beginners;

import java.util.Scanner;

/**
 * Mini Project: Simple Calculator
 * <p>
 * Put together everything you have learned so far to build a simple calculator.
 * The calculator should display a menu, read the user's choice and two numbers,
 * perform the chosen operation, and print the result.
 */
public class _10_MiniProject {

    public static void main(String[] args) {

        // TODO: 1 - Create a Scanner for user input
        Scanner scanner = new Scanner(System.in);


        // TODO: 2 - Display a menu with the following options:
        // Print:
        //   "=== Simple Calculator ==="
        //   "1. Add"
        //   "2. Subtract"
        //   "3. Multiply"
        //   "4. Divide"
        //   "Choose an operation (1-4): "
        System.out.println("=== Simple Calculator ===");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.print("Chose an operation (1-4): ");

        // TODO: 3 - Read the user's choice into an int variable
        int input = scanner.nextInt();

        // TODO: 4 - Prompt and read two double numbers from the user
        // Print "Enter first number: " and read it.
        // Print "Enter second number: " and read it.
        System.out.print("Enter first number: ");
        int first = scanner.nextInt();
        System.out.print("Enter second number: ");
        int second = scanner.nextInt();


        // TODO: 5 - Use a switch statement to perform the chosen operation and print the result
        // Case 1: Print "Result: " + (num1 + num2)
        // Case 2: Print "Result: " + (num1 - num2)
        // Case 3: Print "Result: " + (num1 * num2)
        // Case 4: Perform division (but handle division by zero first - see TODO 6)
        // Default: Print "Invalid choice"
        switch (input) {
            case 1:
                System.out.println("Result: " + (first + second));
                break;
            case 2:
                System.out.println("Result: " + (first - second));
                break;
            case 3:
                System.out.println("Result: " + (first * second));
                break;
            case 4:
                if (second == 0) {
                    System.out.println("Error: Can not divide by zero");
                } else {
                    System.out.println("Result: " + (first / second));
                    break;
                }
        }

        // TODO: 6 - Inside case 4, handle division by zero with an if statement
        // If the second number is 0, print "Error: Cannot divide by zero"
        // Otherwise, print the result of the division

    }
}
