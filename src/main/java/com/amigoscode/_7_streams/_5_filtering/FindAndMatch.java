package com.amigoscode._7_streams._5_filtering;

import java.util.List;
import java.util.Optional;

/**
 * Exercise: Find and Match Operations
 *
 * Learn how to use findFirst(), findAny(), allMatch(), anyMatch(),
 * and noneMatch() - short-circuiting terminal operations that don't
 * need to process all elements.
 */
public class FindAndMatch {

    record Product(String name, double price, String category) {}

    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 4, 6, 8, 10, 11, 12, 14);
        List<String> names = List.of("Alice", "Bob", "Charlie", "Diana", "Eve");
        List<Product> products = List.of(
                new Product("Laptop", 999.99, "Electronics"),
                new Product("Mouse", 29.99, "Electronics"),
                new Product("Desk", 299.99, "Furniture"),
                new Product("Chair", 199.99, "Furniture"),
                new Product("Monitor", 449.99, "Electronics"),
                new Product("Lamp", 49.99, "Furniture")
        );
        List<Integer> evenNumbers = List.of(2, 4, 6, 8, 10);

        // TODO: 1 - Use findFirst() to find the first number greater than 7 in 'numbers'
        //           Print the result
        Integer i = numbers.stream().filter(num -> num > 7).findFirst().get();
        System.out.println(i);


        // TODO: 2 - Use findAny() on a parallel stream of 'names' to find any name
        //           starting with a vowel (A, E, I, O, U)
        //           Print the result (may vary between runs due to parallelism)
        String string = names.stream().filter(name -> name.matches("^(?i)[aeiou].*")).findAny().get();
        System.out.println(string);


        // TODO: 3 - Use allMatch() to check if all elements in 'evenNumbers' are even
        //           Print true or false
        boolean b = evenNumbers.stream().allMatch(n -> n % 2 == 0);
        System.out.println(b);


        // TODO: 4 - Use anyMatch() to check if at least one product in 'products'
        //           has a price over 500
        //           Print true or false
        boolean b1 = products.stream().anyMatch(product -> product.price > 500);
        System.out.println(b1);

        // TODO: 5 - Use noneMatch() to check that no product in 'products'
        //           has a negative price
        //           Print true or false
        boolean b2 = products.stream().noneMatch(product -> product.price < 0);
        System.out.println(b2);


        // TODO: 6 - Handle the Optional from findFirst() properly:
        //           Find the first product in "Furniture" category
        //           Use ifPresentOrElse to print the product name or "Not found"
        products.stream()
                .filter(product -> product.category.equalsIgnoreCase("Furniture"))
                .findFirst()
                .ifPresentOrElse(product -> {
                    System.out.println(product.name);
                },
                        () -> System.out.println("Not Found"));


        // TODO: 7 - Combine filter + findFirst to search for a specific product:
        //           Find the first product with price between 100 and 300
        //           Use map to extract just the name, then orElse("Not found")
        //           Print the result
        String string1 = products.stream()
                .filter(product -> product.price > 100 && product.price < 300)
                .findFirst()
                .map(product -> product.name)
                .orElse("Not Found");
        System.out.println(string1);

    }
}
