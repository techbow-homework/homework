package com.techbow.homework.y2021.m10.qiangzhai;

public class LC20_ValidParentheses {
    public boolean isValid(String s) {
        //cc
        if (s == null || s.length() == 0) return true;

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()){//string convert to char array
            if (isLeft(c)){
                stack.push(c);
            } else if (isRight(c)){
                if (stack.isEmpty()) return false;
                if (!isMatch(stack.pop(),c)) return false;
            }
        }
        return stack.isEmpty();//说明pop出去抵消完全，为true
    }

    private boolean isLeft(char c) {
        return (c == '(' || c == '{' || c == '[');
    }

    private boolean isRight(char c) {
        return (c == ')' || c == '}' || c == ']');
    }

    private boolean isMatch(char c1, char c2){
        return (c1 == '(' && c2 == ')') ||
                (c1 == '[' && c2 == ']') ||
                (c1 == '{' && c2 == '}');
    }
}
