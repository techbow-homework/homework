package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LC739DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        stack.offerLast(0);
        for(int i = 1; i < n; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peekLast()]){
                int index = stack.pollLast();
                res[index] = i - index;
            }
            stack.offerLast(i);
            //System.out.println(stack);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] temps = new int[]{73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temps)));//[1,1,4,2,1,1,0,0]
    }
}
// time O(n) space O(n)
