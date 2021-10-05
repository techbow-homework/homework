package com.techbow.homework.y2021.m09.QiyueWang;

import java.util.Deque;
import java.util.LinkedList;

public class LC84LargestRectangleInHistogram {
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> stack = new LinkedList<>();
        int res = 0;
        for(int i = 0; i < n; i++){
            while( !stack.isEmpty() && heights[stack.peek()] > heights[i]){
                int idx = stack.pop();
                int height = heights[idx];
                int width = stack.isEmpty()? i : i - stack.peek() - 1; // look at previous pos in the stack and multiply by the height popped
                int curArea = width * height;
                res = Math.max(res, curArea);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int idx = stack.pop();
            int height = heights[idx];
            int width = stack.isEmpty()? n : n - stack.peek() - 1;
            int curArea = width * height;
            res = Math.max(res, curArea);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{2,1,5,6,2,3};
        int[] heights1 = new int[]{4,2,0,3,2,5};
        System.out.println(largestRectangleArea(heights)); //expect 10
        System.out.println(largestRectangleArea(heights1)); // expect 6
    }
}
//time O(N) space O(N)