import java.util.ArrayList;
import java.util.Scanner;

// Class to represent a student
class Student {
    private String name;
    private int id;
    private int age;
    private String course;

    // Constructor to initialize student details
    public Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    // Display student details
    public void displayStudentDetails() {
        System.out.println("Student ID: " + id);
        System.out.println("Student Name: " + name);
        System.out.println("Student Age: " + age);
        System.out.println("Student Course: " + course);
    }
}

// Main class for the Student Management System
public class StudentManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();  
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            showMenu();
            choice = getValidInt("Enter your choice (1-5):");

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    updateStudent();
                    break;
                case 3:
                    removeStudent();
                    break;
                case 4:
                    viewStudentDetails();
                    break;
                case 5:
                    System.out.println("Exiting the application. Goodbye!");  
                    break;
                default:
                    System.out.println("Invalid choice! Please choose a valid option.");  
            }
        } while (choice != 5);  
    }

    // Display menu options
    private static void showMenu() {
        System.out.println("\n===== Student Management System =====");
        System.out.println("1. Add Student");
        System.out.println("2. Update Student");
        System.out.println("3. Remove Student");
        System.out.println("4. View Student Details");
        System.out.println("5. Exit");
        System.out.println("Please choose an option from the menu above.");
    }

    // Method to add a student record
    private static void addStudent() {
        System.out.println("Adding a new student to the system.");

        System.out.print("Enter student ID: ");
        int id = getValidInt("ID must be a positive integer.");

        System.out.print("Enter student name: ");
        String name = scanner.next();

        System.out.print("Enter student age: ");
        int age = getValidInt("Age must be a positive integer.");

        System.out.print("Enter student course: ");
        String course = scanner.next();

        // Create a new student object and add to the list
        Student student = new Student(id, name, age, course);
        students.add(student);  // Add student to the list
        System.out.println("Student added successfully!");
    }

    // Method to update a student's record
    private static void updateStudent() {
        System.out.println("Updating student details.");

        System.out.print("Enter student ID to update: ");
        int id = getValidInt("ID must be a positive integer.");

        // Find the student by ID
        Student student = findStudentById(id);

        if (student != null) {
            System.out.println("Student found. You can update the details.");

            System.out.print("Enter new name (Leave blank to keep current name): ");
            String name = scanner.next();
            if (!name.isEmpty()) student.setName(name);  

            System.out.print("Enter new age (Enter -1 to keep current age): ");
            int age = getValidInt("Age must be a positive integer.");
            if (age != -1) student.setAge(age);  

            System.out.print("Enter new course (Leave blank to keep current course): ");
            String course = scanner.next();
            if (!course.isEmpty()) student.setCourse(course);  

            System.out.println("Student details updated successfully!");
        } else {
            System.out.println("Student with ID " + id + " not found.");  
        }
    }

    // Method to remove a student record
    private static void removeStudent() {
        System.out.println("Removing a student from the system.");

        System.out.print("Enter student ID to remove: ");
        int id = getValidInt("ID must be a positive integer.");

        // Find the student by ID
        Student student = findStudentById(id);

        if (student != null) {
            students.remove(student);  
            System.out.println("Student removed successfully!");
        } else {
            System.out.println("Student with ID " + id + " not found.");  
        }
    }

    // Method to view student details
    private static void viewStudentDetails() {
        System.out.println("Viewing student details.");

        System.out.print("Enter student ID to view details: ");
        int id = getValidInt("ID must be a positive integer.");

        // Find the student by ID
        Student student = findStudentById(id);

        if (student != null) {
            student.displayStudentDetails();  
        } else {
            System.out.println("Student with ID " + id + " not found.");  
        }
    }

    // Helper method to find a student by ID
    private static Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;  
            }
        }
        return null;  
    }

    // Method to get a valid integer input from the user
    private static int getValidInt(String prompt) {
        System.out.println(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a valid number.");
            scanner.next();  
        }
        return scanner.nextInt();  
    }
}
