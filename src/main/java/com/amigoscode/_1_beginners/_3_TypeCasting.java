package com.amigoscode._1_beginners;

/**
 * Exercise: Type Casting
 *
 * Learn how to convert between different data types in Java.
 * Widening (implicit): smaller type -> larger type (e.g., int -> double)
 * Narrowing (explicit): larger type -> smaller type (e.g., double -> int)
 */
public class _3_TypeCasting {

    public static void main(String[] args) {

        // TODO: 1 - Widen an int to a double (implicit casting)
        // Declare an int variable with any value, then assign it to a double variable.
        // Print both variables to see the result.
        System.out.println("To Do 1: ");
        int a = 23;
        double b = a;
        System.out.println(a);
        System.out.println(b);
        System.out.println();


        // TODO: 2 - Narrow a double to an int (explicit casting)
        // Declare a double variable (e.g., 9.78), then cast it to an int.
        // Print both variables to see what happens to the decimal part.
        System.out.println("To Do 2: ");
        double x = 9.78;
        int y = (int)x;
        System.out.println(x);
        System.out.println(y);
        System.out.println();


        // TODO: 3 - Cast an int to a char to get the character it represents
        // Hint: int value 65 corresponds to 'A' in ASCII
        // Print the resulting char.
        System.out.println("To Do 3: ");
        int val = 65;
        char c = (char)val;
        System.out.println(val);
        System.out.println(c);
        System.out.println();


        // TODO: 4 - Cast a char to an int to get its ASCII value
        // Hint: char 'Z' has an ASCII value of 90
        // Print the resulting int.
        System.out.println("To Do 4: ");
        char s = 'Z';
        int num = (int)s;
        System.out.println(s);
        System.out.println(num);
        System.out.println();


        // TODO: 5 - Convert a String "42" to an int using Integer.parseInt()
        // Declare a String variable with the value "42", then parse it to an int.
        // Print the result.
        System.out.println("To Do 5: ");
        String str = "42";
        int n = Integer.parseInt(str);

        System.out.println(n);
        System.out.println();


        // TODO: 6 - Convert an int 42 to a String using String.valueOf()
        // Declare an int variable with the value 42, then convert it to a String.
        // Print the result.
        System.out.println("To Do 6: ");
        int m = 42;
        String st = String.valueOf(m);
        System.out.println(st);
        System.out.println();

    }
}
