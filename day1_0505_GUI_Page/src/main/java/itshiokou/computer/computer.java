package itshiokou.computer;

import java.util.Scanner;

public class computer {

    // 使用枚举类型表示运算符
    enum Operator {
        ADD("+"),
        SUBTRACT("-"),
        MULTIPLY("*"),
        DIVIDE("/"),
        SQRT("sqrt"), // 求平方根
        POW("^");      // 求幂

        private final String symbol;

        Operator(String symbol) {
            this.symbol = symbol;
        }

        public String getSymbol() {
            return symbol;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter an expression (e.g., 3+3, sqrt 9, 2^3):");
        String expression = scanner.nextLine();//读取一行数据

        // 去除所有空格，利用正则表达式进行匹配
        expression = expression.replaceAll("\\s+", "");

        // 查找运算符
        int operatorIndex = -1;
        String operator = "";
        if (expression.contains("+")) {
            operatorIndex = expression.indexOf("+");
            operator = "+";
        } else if (expression.contains("-")) {
            operatorIndex = expression.indexOf("-");
            operator = "-";
        } else if (expression.contains("*")) {
            operatorIndex = expression.indexOf("*");
            operator = "*";
        } else if (expression.contains("/")) {
            operatorIndex = expression.indexOf("/");
            operator = "/";
        } else if (expression.startsWith("sqrt")) { // 处理求平方根
            operator = "sqrt";
            operatorIndex = 4; // "sqrt" 的长度
        } else if (expression.contains("^")) {
            operatorIndex = expression.indexOf("^");
            operator = "^";
        }

        if (operatorIndex == -1) {
            System.out.println("Invalid expression: No operator found.");
            return;
        }

        try {
            double result = 0;
            if (operator.equals("sqrt")) { // 求平方根
                String operandStr = expression.substring(operatorIndex);
                double operand = Double.parseDouble(operandStr);
                result = calculate(operand, operator, 0); // 第二个操作数无意义
            } else { // 其他运算符
                String operand1Str = expression.substring(0, operatorIndex);
                String operand2Str = expression.substring(operatorIndex + 1);
                double operand1 = Double.parseDouble(operand1Str);
                double operand2 = Double.parseDouble(operand2Str);
                result = calculate(operand1, operator, operand2);
            }

            System.out.println("Result: " + result);

        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // 输出自定义的错误信息
        }
    }

    // 将计算逻辑封装成一个单独的方法
    private static double calculate(double operandOne, String operatorSymbol, double operandTwo) {
        double result = 0;

        switch (operatorSymbol) {
            case "+":
                result = operandOne + operandTwo;
                break;
            case "-":
                result = operandOne - operandTwo;
                break;
            case "*":
                result = operandOne * operandTwo;
                break;
            case "/":
                if (operandTwo == 0) {
                    throw new IllegalArgumentException("Division by zero is not allowed!"); // 抛出异常
                }
                result = operandOne / operandTwo;
                break;
            case "sqrt": // 求平方根
                result = Math.sqrt(operandOne);
                break;
            case "^": // 求幂
                result = Math.pow(operandOne, operandTwo);
                break;
            default:
                throw new IllegalArgumentException("Unsupported operator: " + operatorSymbol); // 抛出异常
        }

        return result;
    }
}