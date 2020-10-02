package com.company;

import java.util.Scanner;

public class Main {
    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public double divide(double num1, double num2) {
        return num1 / num2;
    }

    public int subtract(int num1, int num2) {
        return num1 - num2;
    }

    public int plus(int num1, int num2) {
        return num1 + num2;
    }

    public static class ScientificCalculator extends Main {
        public int power(int num1, int num2) {
            return (int)Math.pow(num1, num2);
        }

        public int factorial (int num1) {
            if(num1 <= 1) {
                return 1;
            }
            else
                return num1 * factorial(num1-1);
        }

        public double sqrt (int num1) {
            return Math.sqrt(num1);
        }

        public double log (int num1) {
            return Math.log(num1);
        }

    }

    public static void main(String[] args) {
        int num1,num2;
        String sign;

        Scanner keyboard = new Scanner(System.in);
        Main yourCal = new Main();

        System.out.println("Введите два числа");
        num1 = keyboard.nextInt();
        num2 = keyboard.nextInt();

        System.out.println("Выберите мат. операцию (+, -, * , /)");
        sign = keyboard.next();

        switch (sign) {
            case "+": {
                int num3 = yourCal.plus(num1, num2);
                System.out.println("Ответ: " + num3);
                break;
            }
            case "-": {
                int num3 = yourCal.subtract(num1, num2);
                System.out.println("Ответ: " + num3);
                break;
            }
            case "*": {
                int num3 = yourCal.multiply(num1, num2);
                System.out.println("Ответ: " + num3);
                break;
            }
            case "/":
                try {
                    double num3 = yourCal.divide(num1, num2);
                    System.out.println("Ответ: " + num3);
                } catch (ArithmeticException e) {
                    System.out.println("Деление на ноль");
                }
                break;
            default:
                System.out.println("Недействительный знак");
                break;
        }

        ScientificCalculator ScCalc = new ScientificCalculator();
        int powNum1,powNum2;

        System.out.println("Продвинутая версия калькулятора");
        System.out.println("Возведение в степень (введите число и степень)");
        powNum1 = keyboard.nextInt();
        powNum2 = keyboard.nextInt();

        int powResult = ScCalc.power(powNum1, powNum2);
        System.out.println(powNum1 + " в степени " + powNum2 + ": " + powResult);

        System.out.println("Факториал");
        int factNum = keyboard.nextInt();

        int factResult = ScCalc.factorial(factNum);
        System.out.println("Факториал числа " + factNum + ": " + factResult);

        System.out.println("Квадратный корень");
        int sqrtNum = keyboard.nextInt();

        double sqrtResult = ScCalc.sqrt(sqrtNum);
        System.out.println("Квадратный корень " + sqrtNum + ": " + sqrtResult);

        System.out.println("Натуральный логарифм");
        int logNum = keyboard.nextInt();

        double logResult = ScCalc.log(logNum);
        System.out.println("Логарифм " + logNum + ": " + logResult);
    }
}
