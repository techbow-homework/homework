package com.techbow.homework.y2021.m10.QiyueWang;

import java.util.Deque;
import java.util.LinkedList;

public class LC224BasicCalculator {
    public static int calculate(String s) {
        int n = s.length();
        int i = 0;
        int preSign = 1; // +- 1 for sign before the bracket
        Deque<Integer> stack = new LinkedList<>(); // stack for signs
        stack.offerLast(1);
        int res = 0;
        while(i < n){
            char cur = s.charAt(i);
            if(cur == ' '){
                i++;
            }else if(cur == '+'){
                preSign = stack.peekLast();
                i++;
            }else if(cur == '-'){
                preSign = - stack.peekLast();
                i++;
            }else if(cur == '('){
                stack.offerLast(preSign); // push the sign before the bracket
                //System.out.println(preSign);
                i++;
            }else if(cur == ')'){
                stack.pollLast(); // bracket over
                i++;
            }else{
                int num = 0;
                while(i < n && Character.isDigit(s.charAt(i))){
                    num = 10 * num + s.charAt(i) - '0';
                    i++;
                }
                res += preSign * num;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s1 = "- (3 + (4 + 5))";
        String s2 = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculate(s1)); // -12
        System.out.println(calculate(s2));// 23
    }
}
