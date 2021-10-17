package com.techbow.homework.y2021.m10.mengyu;

import java.util.HashMap;
import java.util.Stack;

public class LC20ValidParentheses {
    /*
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    An input string is valid if:
    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
     */
    public boolean isValid(String s) {
        char chars[] = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char ch : chars) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (ch == ')' && stack.pop() != '(') {
                    return false;
                }

                if (ch == ']' && stack.pop() != '[') {
                    return false;
                }
                if (ch == '}' && stack.pop() != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
