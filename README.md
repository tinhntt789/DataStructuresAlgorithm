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
