package com.amigoscode._2_developers._5_methods;

/**
 * Method Overloading Exercises
 * <p>
 * Practice creating overloaded methods — multiple methods with the same name
 * but different parameter lists. Java determines which version to call based
 * on the arguments you pass.
 */
public class MethodOverloading {

    // TODO: 1 - Create a method: int add(int a, int b)
    //  Returns the sum of two integers.
    public int add(int a, int b) {
        return a + b;
    }


    // TODO: 2 - Create an overloaded method: int add(int a, int b, int c)
    //  Returns the sum of three integers.
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // TODO: 3 - Create an overloaded method: double add(double a, double b)
    //  Returns the sum of two doubles.
    public double add(double a, double b){
        return a + b;
    }


    // TODO: 4 - Create a method: String format(String value)
    //  Returns the string wrapped in square brackets, e.g., "[hello]".
    public String format(String value){
        return "[" + value + "]";
    }


    // TODO: 5 - Create an overloaded method: String format(int value)
    //  Returns the integer formatted with leading zeros to 5 digits.
    //  Example: format(42) returns "00042".
    //  Hint: use String.format("%05d", value)
    public String format(int value){
        return String.format("%05d", value);
    }


    // TODO: 6 - Create an overloaded method: String format(String label, int value)
    //  Returns "label: value", e.g., format("Score", 95) returns "Score: 95".
    public String format(String label, int value){
        return label + ": " + value;
    }


    public static void main(String[] args) {
        MethodOverloading mo = new MethodOverloading();

        // TODO: 7 - Call each overloaded method and print the results:
        //  - add(2, 3)
        int added = mo.add(2, 3);
        System.out.println("Adding two numbers: "+"\n"+added);
        //  - add(1, 2, 3)
        int added1 = mo.add(1, 2, 3);
        System.out.println("Adding three numbers: "+"\n" + added1);
        //  - add(1.5, 2.5)
        double added2 = mo.add(1.5, 2.5);
        System.out.println("Adding two double: "+"\n" + added2);
        //  - format("hello")
        String f = mo.format("hello");
        System.out.println("Formatting into square brackets: " + "\n" + f);

        //  - format(42)
        String form = mo.format(42);
        System.out.println("Formatted with leading zeros to 5 digits: "+"\n" + form);
        //  - format("Score", 95)
        String format = mo.format("Score", 95);
        System.out.println("Concatenation string and int value: "+"\n" + format);
        //  Print each result with a descriptive label.

    }
}
