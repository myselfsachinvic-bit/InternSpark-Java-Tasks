import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    private static final ArrayList<Student> students = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        try (scanner) {
            int choice;
            
            do {
                displayMenu();
                
                System.out.print("Enter your choice: ");
                choice = readInt();
                
                switch (choice) {
                    
                    case 1 -> addStudent();
                    
                    case 2 -> viewStudents();
                    
                    case 3 -> searchStudent();
                    
                    case 4 -> updateStudent();
                    
                    case 5 -> deleteStudent();
                    
                    case 6 -> System.out.println("Thank you for using Student Management System.");
                    
                    default -> System.out.println("Invalid choice. Please try again.");
                }
                
            } while (choice != 6);
        }
    }

    private static void displayMenu() {

        System.out.println("\n================================");
        System.out.println("     STUDENT MANAGEMENT SYSTEM");
        System.out.println("================================");
        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Exit");
        System.out.println("================================");
    }

    private static void addStudent() {

        System.out.print("Enter Student ID: ");
        int id = readInt();

        if (findStudent(id) != null) {
            System.out.println("Student ID already exists.");
            return;
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = readInt();

        System.out.print("Enter Course: ");
        String course = scanner.nextLine();

        Student student = new Student(id, name, age, course);

        students.add(student);

        System.out.println("Student added successfully.");
    }

    private static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n----- Student List -----");

        for (Student student : students) {
            student.displayStudent();
        }
    }

    private static void searchStudent() {

        System.out.print("Enter Student ID to search: ");
        int id = readInt();

        Student student = findStudent(id);

        if (student != null) {
            System.out.println("\nStudent Found:");
            student.displayStudent();
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void updateStudent() {

        System.out.print("Enter Student ID to update: ");
        int id = readInt();

        Student student = findStudent(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter new name: ");
        String name = scanner.nextLine();

        System.out.print("Enter new age: ");
        int age = readInt();

        System.out.print("Enter new course: ");
        String course = scanner.nextLine();

        student.setName(name);
        student.setAge(age);
        student.setCourse(course);

        System.out.println("Student updated successfully.");
    }

    private static void deleteStudent() {

        System.out.print("Enter Student ID to delete: ");
        int id = readInt();

        Student student = findStudent(id);

        if (student != null) {
            students.remove(student);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static Student findStudent(int id) {

        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    private static int readInt() {

        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }

        int value = scanner.nextInt();
        scanner.nextLine();

        return value;
    }
}