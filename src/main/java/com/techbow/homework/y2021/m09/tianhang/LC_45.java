package com.techbow.homework.y2021.m09.tianhang;

public class LC_45 {
    public int jump(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        int result = 0;
        int preMax = 0;
        int curMax = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i > preMax) {
                preMax = curMax;
                result++;
            }
            curMax = Math.max(curMax, i + nums[i]);
            if(curMax >= nums.length - 1) return result + 1;
        }
        return nums.length;
    }
}
