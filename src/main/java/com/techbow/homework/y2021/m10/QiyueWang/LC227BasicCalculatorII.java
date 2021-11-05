package com.techbow.homework.y2021.m10.QiyueWang;

import java.util.Deque;
import java.util.LinkedList;

public class LC227BasicCalculatorII {
    public static int calculate(String s) {
        int n = s.length();
        Deque<Integer> stack = new LinkedList<>();
        int preSign = 1;
        char op = ' ';
        int i = 0;
        while(i < n){
            char c = s.charAt(i);
            if(c == ' ') i++;
            else if(c == '+' || c == '*' || c == '/') {
                op = c;
                i++;
            }
            else if(c == '-'){
                op = c;
                preSign = -1;
                i++;
            }else{
                int num = 0;
                while(i < n && Character.isDigit(s.charAt(i))){
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                //System.out.println(i+" "+op);
                if(op == '*'){
                    stack.offerLast(stack.pollLast() * num);
                }else if(op == '/'){
                    //System.out.println(stack.toString());
                    stack.offerLast(stack.pollLast() / num);
                }else{
                    stack.offerLast(preSign * num);
                    preSign = 1;
                }
            }
        }
        int res = 0;
        while(!stack.isEmpty()){
            res += stack.pollLast();
        }
        return res;
    }

    public static void main(String[] args) {
        String s1 = "3+2*2";
        String s2 = " 3/2 ";
        String s3 = " 3+5 /2 ";
        System.out.println(calculate(s1));//7
        System.out.println(calculate(s2));//1
        System.out.println(calculate(s3));//5
    }
}
