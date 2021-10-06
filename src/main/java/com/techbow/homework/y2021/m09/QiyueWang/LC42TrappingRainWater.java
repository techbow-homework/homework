package com.techbow.homework.y2021.m09.QiyueWang;

import java.util.Deque;
import java.util.LinkedList;

public class LC42TrappingRainWater {
    public static int trap(int[] height) {
        int n = height.length;
        Deque<Integer> stack = new LinkedList<>();
        int res = 0;
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && height[stack.peek()] < height[i]){
                int curH = height[stack.pop()];
                int curW = stack.isEmpty() ? 0 : i - stack.peek() - 1;
                if(curW == 0) continue;
                int difH = Math.min(height[stack.peek()], height[i]) - curH;
                res += difH * curW;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int[] heights1 = new int[]{4,2,0,3,2,5};
        System.out.println(trap(heights)); //expect 6
        System.out.println(trap(heights1)); // expect 9
    }
}
// time O(N) space O(N)