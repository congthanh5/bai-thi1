package exam2;

import java.io.*;
import java.util.*;

public class StudentManager {
    private static List<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int option;
        do {
            System.out.println("\n1. Add New Student");
            System.out.println("2. Save Students");
            System.out.println("3. Display All Students");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (option) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    saveStudents();
                    break;
                case 3:
                    displayStudents();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 4);
    }

    private static void addStudent() {
        System.out.print("Enter Enrol ID: ");
        String enrolID = scanner.nextLine();
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // clear buffer
        Student student = new Student(enrolID, firstName, lastName, age);
        students.add(student);
        System.out.println("Student added successfully!");
    }

    private static void saveStudents() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("students.dat"))) {
            out.writeObject(students);
            System.out.println("Students saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving students: " + e.getMessage());
        }
    }

    private static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            System.out.println(String.format("%-10s %-20s %-20s %s", "EnrolID", "First Name Last Name", "Age"));
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}
