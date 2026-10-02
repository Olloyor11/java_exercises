package com.amigoscode._4_datastructures._7_maps;

// Exercise: Word Frequency Counter using HashMap
// A practical exercise to count word occurrences in a sentence.

import java.util.*;
import java.util.stream.Collectors;

public class HashMapWordCount {

    public static void main(String[] args) {

        String sentence = "the cat sat on the mat and the cat ate the rat on the mat";

        // TODO: 1 - Split the sentence into an array of words using split(" ")
        String[] split = sentence.split(" ");


        // TODO: 2 - Create a HashMap<String, Integer> called 'wordCount'
        //           Iterate through the words array and count the frequency of each word
        //           Hint: use getOrDefault(word, 0) + 1 to increment the count
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : split) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        System.out.println(wordCount);


        // TODO: 3 - Print each word and its count by iterating over the map
        //           Format: "<word>: <count>"
        wordCount.entrySet().forEach(w -> System.out.println("<" + w.getKey() + ">: <" + w.getValue() + ">"));


        // TODO: 4 - Find and print the most frequent word
        //           Iterate through the entrySet and track the entry with the highest value
        Map.Entry<String, Integer> max = null;
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()){
            if (max == null || entry.getValue() > max.getValue()){
                max = entry;
            }
        }
        System.out.println(max);


        // TODO: 5 - Find and print all words that appear only once
        //           Iterate through the entrySet and collect entries where value == 1

        List<String> singles = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() == 1) {
                singles.add(entry.getKey());
            }
        }

        System.out.println(singles);


        // TODO: 6 - Sort the map entries by value (frequency) in descending order and print
        //           Hint: create a List from entrySet(), then sort using a Comparator
        //           that compares entry values in reverse order
       wordCount.entrySet().stream()
               .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
               .forEach(s -> System.out.print(s.getKey() + " - " + s.getValue() + "; "));


    }

}