package org.example.SM;

public class StudentDemo {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        // Добавляем тестовых студентов
        manager.addStudent("Иван Петров", 20, 4.5);
        manager.addStudent("Мария Сидорова", 22, 4.8);
        manager.addStudent("Алексей Иванов", 19, 3.9);
        manager.addStudent("Елена Смирнова", 21, 4.2);
        manager.addStudent("Дмитрий Козлов", 23, 4.6);

        System.out.println("=== ВСЕ СТУДЕНТЫ ===");
        manager.printAllStudents();

        System.out.println("\n=== ФИЛЬТРАЦИЯ ПО ВОЗРАСТУ (20-22) ===");
        manager.printStudents(manager.filterByAge(20, 22));

        System.out.printf("\n=== СРЕДНЯЯ ОЦЕНКА: %.2f ===\n", manager.calculateAverageGrade());

        System.out.println("\n=== СОРТИРОВКА ПО ОЦЕНКАМ ===");
        manager.printStudents(manager.sortByGradeDescending());
    }
}