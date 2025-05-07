package com.itshiokou.eg1;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Simple Calculator");
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter operator (+, -, *, /): ");
        String operator = scanner.next();

        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        double result = 0;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    System.out.println("Error: Division by zero!");
                    return;
                }
                result = num1 / num2;
                break;
            default:
                System.out.println("Error: Invalid operator!");
                return;
        }

        System.out.println("Result: " + result);
        scanner.close();
    }
}