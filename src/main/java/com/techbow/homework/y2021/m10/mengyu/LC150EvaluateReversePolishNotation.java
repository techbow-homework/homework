package com.techbow.homework.y2021.m10.mengyu;

import java.util.Stack;

public class LC150EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (!"+-*/".contains(token)) {
                stack.push(Integer.valueOf(token));
                continue;
            }

            int num1 = stack.pop();
            int num2 = stack.pop();
            int result = 0;
            switch (token) {
                case "+":
                    result = num2 + num1;
                    break;
                case "-":
                    result = num2 - num1;
                    break;
                case "*":
                    result = num2 * num1;
                    break;
                case "/":
                    result = num2 / num1;
                    break;
            }
            stack.push(result);
        }
        return stack.pop();
    }
}
