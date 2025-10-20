package org.example.SM;

import org.example.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentManager {
    private List<Student> students = new ArrayList<>();

    public void addStudent(int id, String name, int age, double grade) {
        students.add(new Student(id, name, age, grade));
    }

    public List<Student> filterByAge(int minAge, int maxAge) {
        return students.stream()
                .filter(student -> student.getAge() >= minAge && student.getAge() <= maxAge)
                .collect(Collectors.toList());
    }

    public List<Student> sortByGradeDescending() {
        return students.stream()
                .sorted(Comparator.comparingDouble(Student::getGrade))
                .collect(Collectors.toList());
    }

    public double calculateAverageGrade() {
        return students.stream()
                .mapToDouble(Student::getGrade)
                .average()
                .orElse(0.0);
    }

    public void printStudents(List<Student> students) {
        System.out.println(students.stream().map(student -> student.getStudentString() + "\n"));
    }

    public void printAllStudents() {
        for(Student student : students) {
            System.out.println(student.getStudentString());
        }
    }
}