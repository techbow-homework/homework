package com.techbow.homework.y2021.m11.shengyuan;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC_394 {
    //S1: One stack
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ']') {
                stack.offerLast(s.charAt(i));
            } else {
                List<Character> list = new ArrayList<>();
                while (stack.peekLast() != '[') {
                    list.add(stack.pollLast());
                }
                //pop [ from the stack
                stack.pollLast();
                //handle the number
                int base = 1;
                int k = 0;
                while (!stack.isEmpty() && Character.isDigit(stack.peekLast())) {
                    k += (stack.pollLast() - '0') * base;               //character -'0' = digit
                    base *= 10;
                }
                //decode k[string] by pushing k times into stack
                while (k != 0) {
                    for (int j = list.size() - 1; j >= 0; j--) {
                        stack.offerLast(list.get(j));
                    }
                    k--;
                }
            }
        }
        //get the result from the Stack
        char[] result = new char[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pollLast();
        }
        return new String(result);
    }
    //S2: Two stacks
    public String decodeString1(String s) {
        //cc
        if (s == null || s.length() == 0) {
            return s;
        }
        Deque<Integer> countStack = new LinkedList<>();
        Deque<StringBuilder> stringStack = new LinkedList<>();
        stringStack.offerLast(new StringBuilder());             //先放空的stringbuilder進去，避免NPE
        int num = 0;
        for (char ch : s.toCharArray()) {
            //case 1: if digit
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {                  //'['
                countStack.offerLast(num);
                stringStack.offerLast(new StringBuilder());
                num = 0;
            } else if (Character.isLetter(ch)) {                  //letters
                stringStack.peekLast().append(ch);
            } else if (ch == ']') {                  //']'
                int count = countStack.pollLast();
                StringBuilder sb = new StringBuilder();
                StringBuilder str = stringStack.pollLast();
                for (int i = count; i > 0; i--) {
                    sb.append(str);
                }
                stringStack.peekLast().append(sb);
            } else {                        //throw exception
                throw new RuntimeException("come up with an unknown letter");
            }
        }
        return stringStack.pollLast().toString();
    }
    //S3: one path
    public String decodeString2(String s) {
        //cc
        if (s == null || s.length() == 0) {
            return s;
        }
        int[] pos = {0};
        return decodeString2(s, pos);
    }
    private String decodeString2(String s, int[] pos) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for (int i = pos[0]; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            } else if (ch == '[') {
                pos[0] = i + 1;
                String next = decodeString2(s, pos);
                for (int n = num; n > 0; n--) {
                    sb.append(next);
                }
                num = 0;
                i = pos[0];
            } else if (Character.isLetter(ch)) {
                sb.append(ch);
            } else if (s.charAt(i) == ']') {
                pos[0] = i;
                return sb.toString();
            } else {
                throw new IllegalArgumentException("come up with an unknown letter");
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        LC_394 test = new LC_394();
        String str = "3[a]2[bc]";
        String res = test.decodeString2(str);        //aaabcbc
        System.out.println(res);
    }
}