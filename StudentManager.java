package com.Tinhntt.AssignmentStudent;

import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();
    private HashMap<String, Student> studentMap = new HashMap<>();
    private List<String> logs = new ArrayList<>();

    // Add a new student
    public void addStudent(String id, String name, double score) {
        if (studentMap.containsKey(id)) {
            System.out.println("Student ID already exists.");
            return;
        }
        Student student = new Student(id, name, score);
        students.add(student);
        studentMap.put(id, student);
        System.out.println("Student added successfully.");
        logs.add("Added student: " + name + " (ID: " + id + "), Score: " + score);
    }

    // Delete a student by ID
    public void deleteStudent(String id) {
        Student student = studentMap.remove(id);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        students.remove(student);
        System.out.println("Student deleted successfully.");
        logs.add("Deleted student with ID: " + id);
    }

    // Edit an existing student's data
    public void editStudent(String id, String name, double score) {
        Student student = studentMap.get(id);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        student.name = name;
        student.score = score;
        System.out.println("Student updated successfully.");
        logs.add("Updated student: " + name + " (ID: " + id + "), New Score: " + score);
    }

    // View student ranking (sorted by score descending)
    public void viewRanking() {
        students.sort(Comparator.comparingDouble(s -> -s.score));
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Search for a student by ID
    public void searchStudent(String id) {
        Student student = studentMap.get(id);
        if (student == null) {
            System.out.println("Student not found.");
        } else {
            System.out.println(student);
            logs.add("Searched for student with ID: " + id);
        }
    }

    // Export report to a text file
    public void exportReport() {
        try (FileWriter writer = new FileWriter("report.txt")) {
            writer.write("=== Student Report ===\n");
            writer.write("Generated at: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n\n");

            writer.write("1. Student List (Original Order):\n");
            for (Student student : students) {
                writer.write("• " + student.name + ": " + student.score + " (" + student.getRank() + ")\n");
            }

            students.sort(Comparator.comparingDouble(s -> -s.score));
            writer.write("\n2. Student List (Sorted by Score):\n");
            for (Student student : students) {
                writer.write("• " + student.name + ": " + student.score + " (" + student.getRank() + ")\n");
            }

            writer.write("\n3. Activity Logs:\n");
            for (String log : logs) {
                writer.write("• " + log + "\n");
            }

            writer.write("\nReport successfully exported to 'report.txt'\n");
        } catch (IOException e) {
            System.out.println("Error writing report: " + e.getMessage());
        }
    }

    // Export student list to CSV file
    public void exportToCSV() {
        try (FileWriter writer = new FileWriter("students.csv")) {
            writer.write("ID,Name,Score,Rank\n");
            for (Student student : students) {
                writer.write(student.id + "," + student.name + "," + student.score + "," + student.getRank() + "\n");
            }
            System.out.println("CSV file 'students.csv' exported successfully.");
            logs.add("Exported student list to CSV file.");
        } catch (IOException e) {
            System.out.println("Error exporting CSV: " + e.getMessage());
        }
    }
}

