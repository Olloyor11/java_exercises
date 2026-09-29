package com.amigoscode._5_generics._1_classcastexception;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercise: ClassCastException Problem
 * <p>
 * This exercise demonstrates why Java generics were introduced.
 * Before generics, collections used raw types and stored Objects,
 * which led to ClassCastException at runtime.
 * <p>
 * Complete the TODOs below to see the problem firsthand.
 */
public class ClassCastProblem {

    public static void main(String[] args) {

        // TODO: 1 - Create a raw (non-generic) ArrayList without any type parameter.
        //  Hint: List list = new ArrayList();
        List list = new ArrayList<>();


        // TODO: 2 - Add a String "Hello" and an Integer 42 to the raw list.
        //  This compiles fine because raw lists accept any Object.
        list.add("Hello");
        list.add(42);

        // TODO: 3 - Iterate through the list and try to cast every element to String.
        //  Use a for loop: for (int i = 0; i < list.size(); i++)
        //  Inside the loop, cast list.get(i) to String and print it.
        //  This will compile, but will throw ClassCastException at runtime
        //  when it reaches the Integer element.
        for (int i = 0; i < list.size(); i++) {
            try {
                String cast = (String) list.get(i);
                System.out.println(cast);

            }catch (ClassCastException e){
                System.out.println(e.getMessage());
            }
        }

        // TODO: 4 - Wrap the casting code from TODO 3 in a try-catch block
        //  that catches ClassCastException. Print the exception message
        //  so you can see what went wrong.



        // TODO: 5 - Add a comment below explaining:
        //  (a) Why did the ClassCastException occur?
        //  (b) How do generics (e.g., List<String>) prevent this problem?
        //  (c) At what stage (compile-time or runtime) do generics catch type errors?
        /*
        - class cast exception happened because we tried to cast integer to string
        - Generics will prevent this problem on compile time by saying expected Type
         */

    }
}
