package org.example.SM;

import org.example.StudentManager;

public class StudentDemo {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        // Добавляем тестовых студентов
        manager.addStudent(1,"Иван Петров", 20, 4.5);
        manager.addStudent(2,"Мария Сидорова", 22, 4.8);
        manager.addStudent(3,"Алексей Иванов", 19, 3.9);
        manager.addStudent(4,"Елена Смирнова", 21, 4.2);
        manager.addStudent(5,"Дмитрий Козлов", 23, 4.6);

        System.out.println("=== ВСЕ СТУДЕНТЫ ===");
        manager.printAllStudents();

        System.out.println("\n=== ФИЛЬТРАЦИЯ ПО ВОЗРАСТУ (20-22) ===");
        manager.printStudents(manager.filterByAge(20, 22));

        System.out.printf("\n=== СРЕДНЯЯ ОЦЕНКА: %.2f ===\n", manager.calculateAverageGrade());

        System.out.println("\n=== СОРТИРОВКА ПО ОЦЕНКАМ ===");
        manager.printStudents(manager.sortByGradeDescending());
    }
}