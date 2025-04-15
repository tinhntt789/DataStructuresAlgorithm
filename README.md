ID: BC00466
 Name: Nguyen Trung Tri Tinh
 Class: Data Structure and Algorthm
 Courses: SE07201# DataStructures-Algorithms
# AssignmentStudent - Student Class in Java
##  Project Description

This Java project defines a simple `Student` class to store student information such as ID, name, and score. It also provides a method to rank the student based on their score. The project demonstrates basic object-oriented programming (OOP) concepts.

---

##  Project Structure

---

## Features

- Store student ID, name, and score.
- Automatically determine the student's academic rank based on score:
  - `>= 9.0` → Excellent
  - `>= 8.0` → Very Good
  - `>= 7.0` → Good
  - `>= 5.0` → Average
  - `< 5.0`  → Poor
- Override `toString()` to display full student details.

---

##  Student.java Preview

```java
package com.Tinhntt.AssignmentStudent;

public class Student {
    public String id;
    public String name;
    public double score;

    public Student(String id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public String getRank() {
        if (score >= 9.0) {
            return "Excellent";
        } else if (score >= 8.0) {
            return "Very Good";
        } else if (score >= 7.0) {
            return "Good";
        } else if (score >= 5.0) {
            return "Average";
        } else {
            return "Poor";
        }
    }

    @Override
    public String toString() {
        return "ID: " + id +
               ", Name: " + name +
               ", Score: " + score +
               ", Rank: " + getRank();
    }
}
 How to Compile and Run
1. Compile the Student class:
javac -d out src/com/Tinhntt/AssignmentStudent/Student.java
2. Create a Main.java to test the class:
import com.Tinhntt.AssignmentStudent.Student;
public class Main {
    public static void main(String[] args) {
        Student student = new Student("BC00466", "Nguyen Trung Tri Tinh", 8.5);
        System.out.println(student);
    }
}
3. Compile and run the main program:
javac -cp out -d out Main.java
java -cp out Main
 Sample Output:
ID: BC00466, Name: Nguyen Trung Tri Tinh, Score: 8.5, Rank: Very Good
 Purpose
This project helps practice basic Java syntax and apply object-oriented programming concepts such as constructors, methods, and overriding toString().
 Author:
Nguyen Trung Tri Tinh
Course: SE07201 - Data Structures and Algorithms


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

##  Student Manager - Java Application

##  Introduction
**Student Manager** is a simple Java application that allows you to:
- Add, edit, and delete student records
-  Search for students by ID
-  View student rankings based on scores
-  Export reports to a `.txt` file
-  Export student list to a `.csv` file

The application uses `ArrayList` and `HashMap` for efficient data management and retrieval.

---

## How to Use (Method Examples)

```java
addStudent("S001", "Nguyen Van A", 8.5);       // Add a student
deleteStudent("S001");                         // Delete a student
editStudent("S001", "Nguyen Van B", 9.0);      // Edit student info
viewRanking();                                 // View ranking (descending by score)
searchStudent("S001");                         // Search by student ID
exportReport();                                // Export report.txt
exportToCSV();                                 // Export students.csv
 Class Structure
 StudentManager
Contains all logic: add, edit, delete, search, sort, and export.

## Student:
Fields:
.String id
.String name
.double score
## Method:
public String getRank(); // Returns academic level: Excellent, Good, Average, etc.
## Requirements:
. Java Development Kit (JDK) 8 or higher
. Any Java IDE (e.g., IntelliJ, Eclipse, VSCode)
## Notes:
. All student data is stored in memory during runtime.
. When exporting, current data will be saved to report.txt and students.csv.
## Author:
Nguyen Trung Tri Tinh – BC00466
---

Let me know if you also want a **short CLI usage guide**, or if you'd like to include instructions for creating a `.jar` file or running the app from the terminal.


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


## Student Management System – Java Console Application

##  Introduction
This is a simple **Java console application** that allows users to manage student data efficiently. With a user-friendly menu, you can:

- Add new students  
-  Edit student information  
-  Delete students by ID  
-  View student rankings by score  
-  Search students by ID  
-  Export a report to a `.txt` file  
-  Export the student list to a `.csv` file  

All data is stored in memory and managed using `ArrayList` and `HashMap` for optimal performance.

---

## Features
| Function                       | Description                                      |
|-------------------------------|--------------------------------------------------|
| Add Student                   | Enter ID, name, and score                        |
| Edit Student                  | Modify name or score by student ID              |
| Delete Student                | Remove student by ID                             |
| View Ranking                  | Show sorted list of students (descending score)  |
| Search Student                | Look up a student by ID                          |
| Export Report                 | Save data and logs to `report.txt`               |
| Export CSV                    | Save student data to `students.csv`              |

---

##  Class Structure

### `StudentManager`
Handles all student operations:
- `addStudent(String id, String name, double score)`
- `editStudent(String id, String name, double score)`
- `deleteStudent(String id)`
- `viewRanking()`
- `searchStudent(String id)`
- `exportReport()` – Generates `report.txt`
- `exportToCSV()` – Generates `students.csv`

### `Student`
Basic model containing:
```java
String id;
String name;
double score;

public String getRank(); // Returns academic rank based on score

StudentMain
Console-based menu application that allows users to interactively perform all operations.

## How to Run
 Run from IDE:
1. Clone or download the project
2. Open in your favorite Java IDE (IntelliJ, Eclipse, VSCode, etc.)
3. Run StudentMain.java
 Run from Command Line:
1. Compile:
javac com/Tinhntt/AssignmentStudent/*.java
2. Run:
java com.Tinhntt.AssignmentStudent.StudentMain
 ## Example Menu Output:
=== Student Management System ===
1. Add Student
2. Edit Student
3. Delete Student
4. View Student Ranking
5. Search Student by ID
6. Export Report to TXT File
7. Export Student List to CSV
8. Exit
Choose an option (1-8):
## Output Files:
. report.txt
Includes original and sorted student lists, with logs of all actions taken.
. students.csv
Clean student list in CSV format: ID, Name, Score, Rank
## Requirements:
. Java 8 or higher
. No external libraries required
. Optional: IDE for easier development
## Author:
Nguyen Trung Tri Tinh
Student ID: BC00466
