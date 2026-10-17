package com.amigoscode._7_streams._6_transformations;

import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

/**
 * Exercise: Advanced Reduce
 *
 * Practice more complex reduce operations including building strings,
 * finding extremes, and using the three-argument reduce for parallel streams.
 */
public class ReduceExercise {

    record Order(String product, double price, int quantity) {}

    record Product(String name, double price) {}

    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Laptop", 999.99, 1),
                new Order("Mouse", 29.99, 3),
                new Order("Keyboard", 79.99, 2),
                new Order("Monitor", 449.99, 1),
                new Order("Headset", 59.99, 2)
        );

        List<String> tags = List.of("java", "streams", "functional", "programming", "lambda");

        List<Product> products = List.of(
                new Product("Widget A", 15.99),
                new Product("Widget B", 42.50),
                new Product("Widget C", 8.75),
                new Product("Widget D", 99.99),
                new Product("Widget E", 23.45)
        );

        // TODO: 1 - Use reduce to find the total price of all orders
        //           Total price for each order = price * quantity
        //           Map to total first, then reduce with Double::sum
        //           Print the result
        double reduced = orders.stream().map(order -> order.price * order.quantity).reduce(Double::sum).get();
        System.out.println(reduced);


        // TODO: 2 - Use reduce to build a comma-separated string from 'tags'
        //           Result should be: "java, streams, functional, programming, lambda"
        //           Use the single-argument reduce that returns Optional
        String reduce = tags.stream().reduce((a, b) -> a + ", " + b).get();
        System.out.println(reduce);


        // TODO: 3 - Use reduce to find the most expensive product in 'products'
        //           Compare by price in the accumulator
        //           Print the product name and price
        Product expensiveProduct = products.stream().reduce((a, b) -> a.price > b.price ? a : b).get();
        System.out.println(expensiveProduct.name + " - " + expensiveProduct.price);


        // TODO: 4 - Create a BinaryOperator<Order> variable that picks the order
        //           with the higher total value (price * quantity)
        //           Use this operator in reduce() and print the winning order
        BinaryOperator<Order> higherTotal = (order, order2) -> order.price * order.quantity > order2.price * order2.quantity ? order : order2;
        Order order = orders.stream().reduce(higherTotal).get();
        System.out.println(order);


        // TODO: 5 - Implement a collector-like operation with reduce:
        //           Use the 3-argument reduce(identity, accumulator, combiner)
        //           to sum all order quantities into a single Integer
        //           Identity: 0, Accumulator: (sum, order) -> sum + order.quantity()
        //           Combiner: Integer::sum
        //           Print the total quantity
        Integer sums = orders.stream().reduce(0, (sum, order1) -> sum + order1.quantity(), Integer::sum);
        System.out.println(sums);


        // TODO: 6 - Use reduce with a combiner for a parallel stream:
        //           From 'orders', calculate the total revenue using a parallel stream
        //           Use the 3-argument reduce with identity 0.0,
        //           accumulator that adds price*quantity, and Double::sum as combiner
        //           Print the result
        Double sum = orders.stream()
                .parallel()
                .reduce(0.0, (total, order1) ->
                        total + order1.price * order1.quantity, Double::sum);
        System.out.println(sum);

    }
}
