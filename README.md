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
