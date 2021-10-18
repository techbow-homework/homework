package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法加强.stack;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string contains only non-negative integers, '+', '-', '*', '/' operators, and open '(' and closing parentheses ')'. The integer division should truncate toward zero.
 * <p>
 * You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
 * <p>
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "1+1"
 * Output: 2
 * Example 2:
 * <p>
 * Input: s = "6-4/2"
 * Output: 4
 * Example 3:
 * <p>
 * Input: s = "2*(5+5*2)/3+(6/2+8)"
 * Output: 21
 * Example 4:
 * <p>
 * Input: s = "(2+6*3+5-(3*14/7+2)*5)+3"
 * Output: -12
 * Example 5:
 * <p>
 * Input: s = "0"
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s <= 104
 * s consists of digits, '+', '-', '*', '/', '(', and ')'.
 * s is a valid expression.
 */

//用两个stack，一个存数字，一个存符号
// 一个map 用来存 operator和优先级
// 左右两边都要加括号来post precessing 保证stack里的数字都会被运算完
//addOpt()这个方法里包含了弹出的逻辑和运算的逻辑
    //注意： 在用while loop时候因为i和stack都是不停变化的，不能提前将这些cache出来判断，这些条件必须用动态的i和动态的stack 含在while loop里
public class LC772BasicCalculatorIII {

    static Map<Character, Integer> map = new HashMap<>();

    public static int calculate(String s) {
        if (s == null) {
            throw new IllegalArgumentException("input cannot be null");
        }

        Stack<Integer> numStack = new Stack<>();
        Stack<Character> signStack = new Stack<>();
        signStack.push('(');

        map.put('-', 1);
        map.put('+', 1);
        map.put('*', 2);
        map.put('/', 2);


        int i = 0; //需要用while loop 因为内部condition 还有需要改变i来凑数的，所以i不是每次loop都+1
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int val = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {    //注意： 在用while loop时候因为i和stack都是不停变化的，不能提前将这些cache出来判断，这些条件必须用动态的i和动态的stack 含在while loop里
                    val = 10 * val + s.charAt(i) - '0';
                    i++;
                }
                numStack.push(val);
            } else if (map.containsKey(c) || c == '(' || c == ')') {
                addSign(c, numStack, signStack);
                i++;
            } else {
                throw new RuntimeException("not supported chars");
            }
        }
        addSign(')', numStack, signStack);
        return numStack.pop();
    }

    private static void addSign(char c, Stack<Integer> numStack, Stack<Character> signStack) {
        if (c == '(') {
            signStack.push(c);
        } else if (c == ')') {
            while (!signStack.isEmpty() && signStack.peek() != '(') {
                doCalculate(numStack, signStack);
            }
            signStack.pop();
        } else {// operators
            //注意： 在用while loop时候因为i和stack都是不停变化的，不能提前将这些cache出来判断，这些条件必须用动态的i和动态的stack 含在while loop里
            while (!signStack.isEmpty() && map.containsKey(signStack.peek()) && map.get(signStack.peek()) >= map.get(c)) {
                doCalculate(numStack, signStack);
            }
            signStack.push(c);
        }
    }

    private static void doCalculate(Stack<Integer> numStack, Stack<Character> signStack) {
        int num2 = numStack.pop();
        int num1 = numStack.pop();
        char sign = signStack.pop();
        int res = 0;
        if (sign == '-') {
            res = num1 - num2;
        } else if (sign == '+') {
            res = num1 + num2;
        } else if (sign == '*') {
            res = num1 * num2;
        } else if (sign == '/') {
            res = num1 / num2;
        }

        numStack.push(res);
    }

    public static void main(String[] args) {
        calculate("2*(5+5*2)/3+(6/2+8)");
    }
}
