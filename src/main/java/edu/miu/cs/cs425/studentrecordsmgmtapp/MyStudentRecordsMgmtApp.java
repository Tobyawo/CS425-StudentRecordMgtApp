package edu.miu.cs.cs425.studentrecordsmgmtapp;


import edu.miu.cs.cs425.studentrecordsmgmtapp.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MyStudentRecordsMgmtApp {
    public static void main(String[] args) {
        Student[] students = {
                new Student(110001, "Dave", Student.parseDate("11/18/1951")),
                new Student(110002, "Anna", Student.parseDate("12/07/1990")),
                new Student(110003, "Erica", Student.parseDate("01/31/1974")),
                new Student(110004, "Carlos", Student.parseDate("08/22/2009")),
                new Student(110005, "Bob", Student.parseDate("08/05/1994"))
        };

        int[] ints = {1,2,5,7,11};
        int secondBiggestNumber = findSecondBiggest(ints);
        System.out.println("Second biggest number is " + secondBiggestNumber);


        printHelloWorld(ints);

        printListOfStudents(students);
        List<Student> platinumAlumniStudents = getListOfPlatinumAlumniStudents(students);
        System.out.println("Platinum Alumni Students:");
        platinumAlumniStudents.forEach(System.out::println);


    }

    public static void printListOfStudents(Student[] students) {
        Arrays.sort(students, Comparator.comparing(Student::getName));
        System.out.println("List of Students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static List<Student> getListOfPlatinumAlumniStudents(Student[] students) {
        List<Student> platinumAlumniStudents = new ArrayList<>();
        LocalDate thirtyYearsAgo = LocalDate.now().minusYears(30);
        for (Student student : students) {
            if (student.getDateOfAdmission().isBefore(thirtyYearsAgo)) {
                platinumAlumniStudents.add(student);
            }
        }
        platinumAlumniStudents.sort(Comparator.comparing(Student::getDateOfAdmission).reversed());
        return platinumAlumniStudents;
    }


    public static void printHelloWorld(int[] numbers) {
        for (int number : numbers) {
            if (number % 5 == 0 && number % 7 == 0) {
                System.out.println("HelloWorld");
            } else if (number % 5 == 0) {
                System.out.println("Hello");
            } else if (number % 7 == 0) {
                System.out.println("World");
            }
        }
    }


    public static int findSecondBiggest(int[] numbers) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int number : numbers) {
            if (number > largest) {
                secondLargest = largest;
                largest = number;
            } else if (number > secondLargest && number != largest) {
                secondLargest = number;
            }
        }
        return secondLargest;
    }


}
