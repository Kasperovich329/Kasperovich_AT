package org.example.SM;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentManager {
    private List<Student> students;
    private int nextId;

    public StudentManager() {
        this.students = new ArrayList<>();
        this.nextId = 1;
    }

    // Добавление студента
    public void addStudent(String name, int age, double grade) {
        Student student = new Student(nextId++, name, age, grade);
        students.add(student);
        System.out.println("Студент добавлен: " + student);
    }

    // Фильтрация по возрасту
    public List<Student> filterByAge(int minAge, int maxAge) {
        return students.stream()
                .filter(student -> student.getAge() >= minAge && student.getAge() <= maxAge)
                .collect(Collectors.toList());
    }

    // Подсчет среднего значения оценок
    public double calculateAverageGrade() {
        if (students.isEmpty()) {
            return 0.0;
        }
        return students.stream()
                .mapToDouble(Student::getGrade)
                .average()
                .orElse(0.0);
    }

    // Сортировка по оценкам (по убыванию)
    public List<Student> sortByGradeDescending() {
        return students.stream()
                .sorted(Comparator.comparingDouble(Student::getGrade).reversed())
                .collect(Collectors.toList());
    }

    // Вывод всех студентов
    public void printAllStudents() {
        if (students.isEmpty()) {
            System.out.println("Список студентов пуст.");
            return;
        }
        System.out.println("\n=== СПИСОК ВСЕХ СТУДЕНТОВ ===");
        students.forEach(System.out::println);
    }

    // Вывод отфильтрованного списка
    public void printStudents(List<Student> studentList) {
        if (studentList.isEmpty()) {
            System.out.println("Нет студентов, соответствующих критериям.");
            return;
        }
        studentList.forEach(System.out::println);
    }

    // Геттер для получения всех студентов
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }
}