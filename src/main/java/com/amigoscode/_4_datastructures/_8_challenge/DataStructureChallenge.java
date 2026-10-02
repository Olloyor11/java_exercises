package com.amigoscode._4_datastructures._8_challenge;

// Exercise: Data Structure Challenge
// Combine multiple data structures to solve a real-world problem.
// Manage a collection of students, group them, track recently viewed, and generate reports.

import java.util.*;

public class DataStructureChallenge {

    // TODO: 1 - Create a Student record (or class) with three fields:
    //           String name, int grade, String subject
    //           If using a record: record Student(String name, int grade, String subject) {}
    //           If using a class: include constructor, getters, and a toString() method
    record Student(
            String name,
            int grade,
            String subject

    ) {
    }


    public static void main(String[] args) {

        // TODO: 2 - Create a List of 10 students with various names, grades, and subjects
        //           Use at least 3 different subjects (e.g., "Math", "Science", "English")
        //           Example: new Student("Alice", 92, "Math")

        List<Student> students = new ArrayList<>(List.of(
                new Student("Anna", 87, "English"),
                new Student("John", 95, "Math"),
                new Student("Emma", 78, "Science"),
                new Student("Michael", 91, "Math"),
                new Student("Sophia", 84, "English"),
                new Student("Daniel", 69, "Science"),
                new Student("Olivia", 98, "Math"),
                new Student("James", 73, "English"),
                new Student("Isabella", 89, "Science"),
                new Student("Liam", 82, "Math")
        ));


        // TODO: 3 - Use a Map<String, List<Student>> to group students by subject
        //           Iterate through the student list
        //           For each student, use computeIfAbsent() to get or create the list for their subject
        //           Then add the student to that list
        //           Print each subject and its students
        Map<String, List<Student>> group = new HashMap<>();
        for (Student student : students) {
            group.computeIfAbsent(student.subject(), key -> new ArrayList<>()).add(student);
        }

        group.forEach((subject, studentList) -> {
            System.out.println(subject + ":");
            studentList.forEach(System.out::println);
        });


        // TODO: 4 - Use a Set<String> to find all unique subjects
        //           Iterate through the students and add each subject to the set
        //           Print the unique subjects
        Set<String> uniqueSubject = new HashSet<>();
        for (Student student : students) {
            uniqueSubject.add(student.subject);
        }
        System.out.println(uniqueSubject);


        // TODO: 5 - Use a Stack<Student> to track the last 3 students "viewed"
        //           Push any 3 students from the list onto the stack
        //           Then pop and print them to show the viewing history (most recent first)
        Stack<Student> viewed = new Stack<>();
        for (int i = 0; i < 3; i++) {
            viewed.push(students.get(i));
        }
        System.out.println(viewed);
        while (!viewed.isEmpty()) {
            System.out.println(viewed.pop());
        }
        System.out.println();


        // TODO: 6 - Sort the student list by grade in descending order using a Comparator
        //           Use list.sort() with Comparator.comparingInt() and .reversed()
        //           Print the sorted list

        students.sort(Comparator.comparingInt(Student::grade).reversed());

        students.forEach(System.out::println);

        // TODO: 7 - Print a summary report:
        //           - Total number of students
        //           - Number of unique subjects (from the Set)
        //           - Highest grade student (first in sorted list)
        //           - Number of students per subject (from the Map)
        System.out.println("Total number of students: " + students.size());
        System.out.println("Number of unique subjects: " + uniqueSubject.size());
        System.out.println("Highest grade student: " + students.getFirst());
        group.forEach((subject, studentList) -> {
            System.out.println(subject + ":" + studentList.size());
        });
    }
}
