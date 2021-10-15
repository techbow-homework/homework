package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法加强.stack;

import java.util.Stack;

//从右往左扫，一个stack。不放进去 ？ ： 和 问好左边的判断符号
// 遇到？停下看看左边的元素是什么，pop出stack里的两个，如果左边是t，塞回去t 如果是f 塞回去f，
public class LC439TernaryExpressionParser {
    public static String parseTernary(String expression) {
        if(expression == null || expression.length() <5){
            return expression;
        }

        Stack<Character> stack = new Stack<>();

        int length = expression.length();

        int i = length -1;
        while(i >0){
           char ch = expression.charAt(i);
            if(ch != '?' && ch != ':'){
                stack.push(ch);
                i--;
            }else {
                if (ch == '?') {
                    i--;
                    char c = expression.charAt(i);
                    char t = stack.pop();
                    char f = stack.pop();
                    if (c == 't') {
                        stack.push(t);
                    } else {
                        stack.push(f);
                    }
                    i--;
                } else{
                    i--;
                }

            }
        }
        return  String.valueOf( stack.pop());
    }

    public static void main(String[] args) {
        String str =
                "F?1:T?4:5";
        parseTernary(str);
    }

}
