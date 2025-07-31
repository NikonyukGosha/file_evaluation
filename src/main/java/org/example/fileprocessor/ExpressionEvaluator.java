package org.example.fileprocessor;

import java.util.*;

public class ExpressionEvaluator {

    public static String evaluate(String input) {
        List<String> tokens = tokenize(input);
        StringBuilder result = new StringBuilder();
        List<String> exprBuffer = new ArrayList<>();

        for (String token : tokens) {
            if (isNumeric(token) || isOperator(token) || token.equals("(") || token.equals(")")) {
                exprBuffer.add(token);
            } else {
                if (!exprBuffer.isEmpty()) {
                    result.append(evalExpression(exprBuffer)).append(" ");
                    exprBuffer.clear();
                }
                result.append(token).append(" ");
            }
        }
        if (!exprBuffer.isEmpty()) {
            result.append(evalExpression(exprBuffer)).append(" ");
        }

        return result.toString().trim();
    }

    // Вычисление выражения
    private static int evalExpression(List<String> tokens) {
        List<String> rpn = toRPN(tokens);
        return evalRPN(rpn);
    }

    // Преобразование в ОПЗ
    private static List<String> toRPN(List<String> tokens) {
        List<String> output = new ArrayList<>();
        Deque<String> ops = new ArrayDeque<>();

        for (String token : tokens) {
            if (isNumeric(token)) {
                output.add(token);
            } else if (isOperator(token)) {
                while (!ops.isEmpty() && isOperator(ops.peek())
                        && precedence(ops.peek()) >= precedence(token)) {
                    output.add(ops.pop());
                }
                ops.push(token);
            } else if (token.equals("(")) {
                ops.push(token);
            } else if (token.equals(")")) {
                while (!ops.isEmpty() && !ops.peek().equals("(")) {
                    output.add(ops.pop());
                }
                if (ops.isEmpty()) {
                    throw new IllegalArgumentException("Несогласованные скобки");
                }
                ops.pop(); // удаляем '('
            }
        }
        while (!ops.isEmpty()) {
            String op = ops.pop();
            if (op.equals("(") || op.equals(")")) {
                throw new IllegalArgumentException("Несогласованные скобки");
            }
            output.add(op);
        }
        return output;
    }

    // Вычисление ОПЗ
    private static int evalRPN(List<String> rpn) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : rpn) {
            if (isNumeric(token)) {
                stack.push(Integer.parseInt(token));
            } else if (isOperator(token)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(calc(a, token, b));
            }
        }
        return stack.pop();
    }

    // --- Вспомогательные методы ---
    private static int precedence(String op) {
        return (op.equals("*") || op.equals("/")) ? 2 : 1;
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

    private static List<String> tokenize(String s) {
        List<String> tokens = new ArrayList<>();
        int n = s.length();
        int i = 0;
        String prevToken = null;

        while (i < n) {
            char c = s.charAt(i);

            if (Character.isWhitespace(c)) {
                i++;
                continue;
            }

            if (c == '(' || c == ')') {
                tokens.add(String.valueOf(c));
                prevToken = String.valueOf(c);
                i++;
                continue;
            }

            if (c == '+' || c == '-' || c == '*' || c == '/') {
                // ищем несколько подряд идущих минусов
                if (c == '+' || c == '-') {
                    int j = i;
                    int minusCount = 0;
                    while (j < n && (s.charAt(j) == '+' || s.charAt(j) == '-')) {
                        if (s.charAt(j) == '-') minusCount++;
                        j++;
                    }
                    String finalSign = (minusCount % 2 == 0) ? "+" : "-";
                    // Если знак унарный (начало выражения или после оператора/скобки)
                    if ((prevToken == null || isOperator(prevToken) || prevToken.equals("("))
                            && j < n && Character.isDigit(s.charAt(j))) {
                        int k = j;
                        while (k < n && Character.isDigit(s.charAt(k))) k++;
                        tokens.add(finalSign + s.substring(j, k));
                        prevToken = tokens.get(tokens.size() - 1);
                        i = k;
                    } else {
                        tokens.add(finalSign);
                        prevToken = finalSign;
                        i = j;
                    }
                } else {
                    tokens.add(String.valueOf(c));
                    prevToken = String.valueOf(c);
                    i++;
                }
                continue;
            }

            if (Character.isDigit(c)) {
                int j = i;
                while (j < n && Character.isDigit(s.charAt(j))) j++;
                tokens.add(s.substring(i, j));
                prevToken = tokens.get(tokens.size() - 1);
                i = j;
                continue;
            }

            int j = i;
            while (j < n && !Character.isWhitespace(s.charAt(j))
                    && "+-*/()".indexOf(s.charAt(j)) == -1) {
                j++;
            }
            tokens.add(s.substring(i, j));
            prevToken = tokens.get(tokens.size() - 1);
            i = j;
        }
        return tokens;
    }
}
