package com.techbow.homework.y2021.m11.mengyu;

import java.util.Stack;

public class LC0020ValidParentheses {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char ch : chars) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                if (ch == ')' && stack.pop() != '(') return false;
                if (ch == ']' && stack.pop() != '[') return false;
                if (ch == '}' && stack.pop() != '{') return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String testCase = new String("((((((((())))))))");
        LC0020ValidParentheses test = new LC0020ValidParentheses();
        test.isValid(testCase);
    }
}
