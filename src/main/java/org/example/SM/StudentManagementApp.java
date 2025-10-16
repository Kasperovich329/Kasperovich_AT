package org.example.SM;

import java.util.List;
import java.util.Scanner;

public class StudentManagementApp {
    private static StudentManager studentManager = new StudentManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {
        while (true) {
            System.out.println("\n=== СИСТЕМА УПРАВЛЕНИЯ СТУДЕНТАМИ ===");
            System.out.println("1. Добавить студента");
            System.out.println("2. Показать всех студентов");
            System.out.println("3. Фильтровать по возрасту");
            System.out.println("4. Средняя оценка");
            System.out.println("5. Сортировать по оценкам (по убыванию)");
            System.out.println("6. Выход");
            System.out.print("Выберите опцию: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    studentManager.printAllStudents();
                    break;
                case 3:
                    filterByAge();
                    break;
                case 4:
                    showAverageGrade();
                    break;
                case 5:
                    sortByGrade();
                    break;
                case 6:
                    System.out.println("Выход из программы...");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Введите имя студента: ");
        String name = scanner.nextLine();

        System.out.print("Введите возраст студента: ");
        int age = scanner.nextInt();

        System.out.print("Введите оценку студента: ");
        double grade = scanner.nextDouble();

        studentManager.addStudent(name, age, grade);
    }

    private static void filterByAge() {
        System.out.print("Введите минимальный возраст: ");
        int minAge = scanner.nextInt();

        System.out.print("Введите максимальный возраст: ");
        int maxAge = scanner.nextInt();

        List<Student> filteredStudents = studentManager.filterByAge(minAge, maxAge);

        System.out.println("\n=== СТУДЕНТЫ В ВОЗРАСТЕ ОТ " + minAge + " ДО " + maxAge + " ЛЕТ ===");
        studentManager.printStudents(filteredStudents);
    }

    private static void showAverageGrade() {
        double average = studentManager.calculateAverageGrade();
        System.out.printf("\nСредняя оценка всех студентов: %.2f\n", average);
    }

    private static void sortByGrade() {
        List<Student> sortedStudents = studentManager.sortByGradeDescending();

        System.out.println("\n=== СТУДЕНТЫ ОТСОРТИРОВАННЫЕ ПО ОЦЕНКАМ (ПО УБЫВАНИЮ) ===");
        studentManager.printStudents(sortedStudents);
    }
}