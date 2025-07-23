package org.example.fileprocessor;

public class ExpressionEvaluator {
public static String evaluate(String input) {

    String[] tokens = input.split(" ");
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < tokens.length; i++) {
        String current = tokens[i];

        if (isNumeric(current)) {
            if (i + 2 < tokens.length && isOperator(tokens[i + 1]) && isNumeric(tokens[i + 2])) {
                int a = Integer.parseInt(tokens[i]);
                String op = tokens[i + 1];
                int b = Integer.parseInt(tokens[i + 2]);
                int eval = calc(a, op, b);
                result.append(eval).append(" ");
                i += 2;
            } else {
                result.append(current).append(" ");
            }
        } else {
            result.append(current).append(" ");
        }
    }

    return result.toString().trim();
}


    private static boolean isNumeric(String s) {
        return s.matches("-?\\d+");
    }

    private static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private static int calc(int a, String op, int b) {
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> b != 0 ? a / b : 0;
            default -> 0;
        };
    }
}

