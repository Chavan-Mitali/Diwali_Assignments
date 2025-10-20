package com.demo.test;

import com.demo.java_student.*;
import java.io.*;
import java.util.*;

public class StudentTest {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student(1, "Mitali", "Java", 85.0, 92.0));
        students.add(new Student(2, "Rushi", "Python", 58.0, 88.0));
        students.add(new Student(3, "Gayatri", "C++", 72.0, 76.0));
        students.add(new Student(4, "Vaishnavi", "UI/UX", 90.0, 81.0));
        students.add(new Student(5, "Anita", "Database", 63.0, 65.0));
        students.add(new Student(6, "Rohit", "AWS", 45.0, 70.0));
        students.add(new Student(7, "Karan", "HTML", 78.0, 89.0));
        students.add(new Student(8, "Ranjeet", "CSS", 82.0, 59.0));
        students.add(new Student(9, "Vasudha", "C#", 95.0, 95.0));

       
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.ser"))) {
            for (Student s : students) {
                oos.writeObject(s);
            }
            System.out.println("10 Student objects serialized successfully.\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        students.sort((s1, s2) -> Double.compare(s2.getAttendancePercentage(), s1.getAttendancePercentage()));

        System.out.println("Students sorted by decreasing attendance:\n");
        for (Student s : students) {
            System.out.println(s);
            try {
                System.out.println("Grade: " + s.calculateGrade());
            } catch (LowAttendanceException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("--------------------------------");
        }
    }
}
