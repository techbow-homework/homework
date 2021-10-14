package com.techbow.homework.y2021.m10.Jacob;

public class LC_45 {
    public int jump(int[] nums) {
        int curMax = 0;
        int max = 0;
        int step = 0;

        for(int i = 0; i < nums.length -1; i++) {
            max = Math.max(max, nums[i] + i);
            if (curMax == i) {
                step++;
                curMax = max;
            }
        }
        return step;
    }
}
