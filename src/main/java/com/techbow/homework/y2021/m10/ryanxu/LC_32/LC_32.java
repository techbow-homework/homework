package com.techbow.homework.y2021.m10.ryanxu.LC_32;

import java.util.Stack;

public class LC_32 {

    public int longestValidParentheses(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int strLen = s.length();
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < strLen; i++) {
            char cur = s.charAt(i);
            if (cur == '(') {
                stack.push(i);
            } else {
                if (!stack.empty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                    res = Math.max(res, i - (stack.isEmpty() ? -1 : stack.peek()));
                } else {
                    stack.push(i);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LC_32 lc_32 = new LC_32();
        String s = ")()())";
        System.out.println(lc_32.longestValidParentheses(s));
    }
}
