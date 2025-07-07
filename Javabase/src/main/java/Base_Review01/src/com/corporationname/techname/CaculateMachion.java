package com.corporationname.techname;
import java.util.Scanner;


public class CaculateMachion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continueCalculation = true;

        while (continueCalculation) {
            System.out.println("请输入一个简单的算术表达式:");
            String input = sc.nextLine();

            try {
                double result = evaluateExpression(input);
                System.out.println("结果: " + result);
            } catch (IllegalArgumentException e) {
                System.out.println("无效的表达式: " + e.getMessage());
            }

            System.out.println("是否继续计算? (y/n)");
            char continueChoice = sc.next().charAt(0);
            sc.nextLine(); // 消耗换行符
            if (continueChoice != 'y' && continueChoice != 'Y') {
                continueCalculation = false;
            }
        }

        sc.close();
        System.out.println("计算器已关闭");
    }

    public static double evaluateExpression(String expression) {
        // 使用正则表达式解析表达式
        String[] parts = expression.split("(?<=[+-/*])|(?=[+-/*])");

        if (parts.length != 3) {
            throw new IllegalArgumentException("表达式格式不正确");
        }

        double num1;
        double num2;
        char operator;

        try {
            num1 = Double.parseDouble(parts[0].trim());
            operator = parts[1].charAt(0);
            num2 = Double.parseDouble(parts[2].trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("无效的数字");
        }

        switch (operator) {
            case '+':
                return add(num1, num2);
            case '-':
                return subtract(num1, num2);
            case '*':
                return multiply(num1, num2);
            case '/':
                return divide(num1, num2);
            default:
                throw new IllegalArgumentException("无效的运算符");
        }
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("除数不能为零");
        }
        return a / b;
    }
}
