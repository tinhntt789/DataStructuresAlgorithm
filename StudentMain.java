package com.Tinhntt.AssignmentStudent;

import java.util.Scanner;

public class StudentMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. View Student Ranking");
            System.out.println("5. Search Student by ID");
            System.out.println("6. Export Report to TXT File");
            System.out.println("7. Export Student List to CSV");
            System.out.println("8. Exit");
            System.out.print("Choose an option (1-8): ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 8.");
                continue;
            }

            String id, name;
            double score;

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    id = scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    name = scanner.nextLine();
                    try {
                        System.out.print("Enter Student Score: ");
                        score = Double.parseDouble(scanner.nextLine().replace(",", "."));
                        manager.addStudent(id, name, score);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid score input! Please enter a valid number (e.g., 8.5)");
                    }
                    break;

                case 2:
                    System.out.print("Enter Student ID to Edit: ");
                    id = scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    name = scanner.nextLine();
                    try {
                        System.out.print("Enter New Score: ");
                        score = Double.parseDouble(scanner.nextLine().replace(",", "."));
                        manager.editStudent(id, name, score);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid score input! Please enter a valid number (e.g., 8.5)");
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID to Delete: ");
                    id = scanner.nextLine();
                    manager.deleteStudent(id);
                    break;

                case 4:
                    System.out.println("\n=== Student Ranking (Sorted by Score) ===");
                    manager.viewRanking();
                    break;

                case 5:
                    System.out.print("Enter Student ID to Search: ");
                    id = scanner.nextLine();
                    manager.searchStudent(id);
                    break;

                case 6:
                    manager.exportReport();
                    System.out.println("Report has been successfully exported to 'report.txt'.");
                    break;

                case 7:
                    manager.exportToCSV();
                    System.out.println("Student list has been successfully exported to 'students.csv'.");
                    break;

                case 8:
                    System.out.println("Exiting program... Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option. Please select a number from 1 to 8.");
                    break;
            }
        }
    }
}

