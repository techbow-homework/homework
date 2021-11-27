package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.Deque;
import java.util.LinkedList;

public class LC32LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        int n = s.length();
        if(n == 0) return 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.offerLast(-1);// serve as the last invalid pos
        int max = 0;
        int count = 0;
        for(int i = 0; i < n; i++){
            char cur = s.charAt(i);
            if(cur == '('){
                stack.offerLast(i);
            }else{
                stack.pollLast();//poll '(' pos or last invalid pos
                if(stack.isEmpty()){// replace last invalid pos
                    stack.offerLast(i);
                }else{//calculate len
                    max = Math.max(max, i - stack.peekLast());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()")); //2
        System.out.println(longestValidParentheses(")()())")); //4
    }
}
// time O(n) space O(n)
