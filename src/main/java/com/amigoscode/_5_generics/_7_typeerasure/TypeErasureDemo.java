package com.amigoscode._5_generics._7_typeerasure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Exercise: Type Erasure
 *
 * Java generics use "type erasure" -- the compiler enforces type safety at
 * compile time, then removes (erases) all generic type information at runtime.
 * This means List<String> and List<Integer> are both just List at runtime.
 *
 * This exercise explores the consequences and limitations of type erasure.
 *
 * Complete the TODOs below.
 */
public class TypeErasureDemo {

    public static void main(String[] args) {

        // TODO: 1 - Create a List<String> and a List<Integer>.
        //  Add some elements to each. Then compare their getClass() values
        //  using == and print the result.
        //  Example: System.out.println(stringList.getClass() == intList.getClass());
        //  Are they the same class at runtime? Add a comment explaining why.
        List<Integer> intList = new ArrayList<>(List.of(1,2,3,4,5));
        ArrayList<String> stringList = new ArrayList<>(List.of("1","2","3","4","5"));
        System.out.println(stringList.getClass() == intList.getClass());
        /*
        it is because generics checks only in compile time and after compilation type eraser removes type argument and now both are the same class instances
         */



        // TODO: 2 - Demonstrate that generic type info is lost at runtime.
        //  Print the getClass().getName() of both lists from TODO 1.
        //  Add a comment explaining what you see -- do the class names
        //  include <String> or <Integer>? Why not?
        System.out.println(intList.getClass().getName());
        System.out.println(stringList.getClass().getName());
        /*
        it shows that both are instances of java.util.ArrayList class it is because after compilation type eraser removes type argument and those becomes
        List intList = new ArrayList<>(List.of(1,2,3,4,5));
        List stringList = new ArrayList<>(List.of("1","2","3","4","5"));
        this shape at runtime and jvm has no clue about their reference types
         */


        // TODO: 3 - Show that instanceof works with raw types but NOT with
        //  parameterized types. Uncomment the code below, observe the error,
        //  then comment it back out. Write the correct version using the raw type.
        //
        // if (stringList instanceof ArrayList<String>) { }  // Does this compile?
        //
        //  Write the working version:
        //  if (stringList instanceof ArrayList) { ... }
        //  Add a comment explaining why you cannot use instanceof with generics.
       /*
          instanceof is evaluated by the JVM at runtime, but type erasure removes
          type arguments like <String> from the bytecode. The JVM can only test the
          raw class (ArrayList)
*/

        // TODO: 4 - Show that you cannot create a generic array.
        //  Uncomment the line below and observe the compile error.
        //  Comment it back out and add an explanation.
        //
//         public static <T> T[] createArray(int size) {
//             return new T[size];  // Why doesn't this compile?
//         }
        //
        //  Explain: Since T is erased at runtime, the JVM would not know
        //  what type of array to create. What workaround exists?


        // TODO: 5 - Add a comment below summarizing:
        //  (a) What is type erasure?
        //  (b) When does it happen (compile-time or runtime)?
        //  (c) What are the main limitations it causes?
        //      (List at least 3: instanceof, array creation, and one more)
        //  (d) Why did Java choose type erasure? (Hint: backward compatibility)
        /*
        - Type erasure is a process of which Java compiler removes
          all generic type information and replaces type parameters with their upper bounds
        - It happens at runtime
        - JVM looses info about generic types at runtime and that's why we can not use instanceof keyword
          or create a new instance of generic type
        - When we work raw types compiler gives warning
        - we can not create an array of generic types directly
         */

    }
}
