package com.amigoscode._1_beginners;

/**
 * Exercise: Arrays
 *
 * Learn how to declare, initialize, and work with arrays in Java.
 * Arrays are fixed-size containers that hold elements of the same type.
 */
public class _6_ArrayExercises {

    public static void main(String[] args) {

        // TODO: 1 - Declare and initialize an int array called 'numbers' with 5 values
        // Hint: int[] numbers = {value1, value2, value3, value4, value5};
        int[] nums = {1, 2, 3, 4, 5};


        // TODO: 2 - Access and print the first and last elements of the array
        // Hint: Arrays are zero-indexed. First element is numbers[0].
        //       Last element is numbers[numbers.length - 1].
        System.out.println("To Do 2:");
        int firstNum = nums[0];
        int lastNum = nums[nums.length - 1];
        System.out.println(firstNum);
        System.out.println(lastNum);
        System.out.println();

        // TODO: 3 - Change the value of the third element (index 2) to 99 and print it
        // Hint: numbers[2] = 99;
        nums[2] = 99;


        // TODO: 4 - Get the length of the array and print it
        // Hint: Use the .length property (not a method, no parentheses)
        System.out.println("To Do 4:");
        System.out.println(nums.length);
        System.out.println();

        // TODO: 5 - Loop through the array using a standard for loop and print each element
        // Hint: for (int i = 0; i < numbers.length; i++) { ... }
        System.out.println("To Do 5:");
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);

        }
        System.out.println();


        // TODO: 6 - Loop through the array using an enhanced for loop (for-each) and print each element
        // Hint: for (int num : numbers) { ... }
        System.out.println("To Do 6:");
        for (int num : nums){
            System.out.println(num);
        }
        System.out.println();

        // TODO: 7 - Find the sum of all elements in the array and print it
        // Hint: Declare a sum variable, loop through the array, and add each element to sum
        System.out.println("To Do 7:");
        int sum = 0;
        for (int i = 0; i <= nums.length; i++) {
            sum += i;
        }
        System.out.println(sum);
        System.out.println();
    }

}