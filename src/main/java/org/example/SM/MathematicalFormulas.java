package org.example.SM;

import java.util.Scanner;

public class MathematicalFormulas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод переменных a и b с клавиатуры
        System.out.println("=== Ввод данных ===");
        System.out.print("Введите значение a: ");
        double a = scanner.nextDouble();

        System.out.print("Введите значение b: ");
        double b = scanner.nextDouble();

        // Вычисление n в зависимости от условий
        double n;
        if (a >= b) {
            // n = ∛(a-b) - кубический корень
            n = Math.cbrt(a - b);
            System.out.printf("Условие: a (%.2f) ≥ b (%.2f)%n", a, b);
            System.out.printf("n = ∛(%.2f - %.2f) = ∛(%.2f) = %.4f%n", a, b, a - b, n);
        } else {
            // n = (a*a) + ((a-b)/sin(a-b))
            double sinValue = Math.sin(a - b);
            // Проверка деления на ноль
            if (Math.abs(sinValue) < 1e-10) {
                System.out.println("Ошибка: деление на ноль (sin(a-b) = 0)");
                scanner.close();
                return;
            }
            n = (a * a) + ((a - b) / sinValue);
            System.out.printf("Условие: a (%.2f) < b (%.2f)%n", a, b);
            System.out.printf("n = (%.2f)² + ((%.2f - %.2f) / sin(%.2f)) = %.2f + (%.2f / %.4f) = %.4f%n",
                    a, a, b, a - b, a * a, a - b, sinValue, n);
        }

        // Вычисление m в зависимости от условий с n
        double m;
        System.out.println("\n=== Вычисление m ===");

        if (n < b) {
            // m = ((n+a)/-b) + √sin(a*a) - cos(n)
            double term1 = (n + a) / -b;
            double term2 = Math.sqrt(Math.sin(a * a));
            double term3 = Math.cos(n);
            m = term1 + term2 - term3;

            System.out.printf("Условие: n (%.4f) < b (%.2f)%n", n, b);
            System.out.printf("m = ((%.4f + %.2f) / -%.2f) + √sin(%.2f²) - cos(%.4f)%n", n, a, b, a, n);
            System.out.printf("m = (%.4f / %.2f) + √sin(%.2f) - cos(%.4f)%n", n + a, -b, a * a, n);
            System.out.printf("m = %.4f + √%.4f - %.4f%n", term1, Math.sin(a * a), term3);
            System.out.printf("m = %.4f + %.4f - %.4f = %.4f%n", term1, term2, term3, m);

        } else if (n == b) {
            // m = (b*b) - tan(n*a)
            double term1 = b * b;
            double term2 = Math.tan(n * a);
            m = term1 - term2;

            System.out.printf("Условие: n (%.4f) = b (%.2f)%n", n, b);
            System.out.printf("m = (%.2f)² - tan(%.4f * %.2f)%n", b, n, a);
            System.out.printf("m = %.4f - tan(%.4f)%n", term1, n * a);
            System.out.printf("m = %.4f - %.4f = %.4f%n", term1, term2, m);

        } else { // n > b
            // m = (b*b*b) + n*(a*a)
            double term1 = b * b * b;
            double term2 = n * (a * a);
            m = term1 + term2;

            System.out.printf("Условие: n (%.4f) > b (%.2f)%n", n, b);
            System.out.printf("m = (%.2f)³ + %.4f * (%.2f)²%n", b, n, a);
            System.out.printf("m = %.4f + %.4f * %.4f%n", term1, n, a * a);
            System.out.printf("m = %.4f + %.4f = %.4f%n", term1, term2, m);
        }

        // Итоговый вывод результатов
        System.out.println("\n=== Итоговые результаты ===");
        System.out.printf("Исходные данные: a = %.2f, b = %.2f%n", a, b);
        System.out.printf("Вычисленные значения: n = %.4f, m = %.4f%n", n, m);

        scanner.close();
    }
}

