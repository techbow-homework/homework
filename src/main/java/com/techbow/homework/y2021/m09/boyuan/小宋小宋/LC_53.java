package com.techbow.homework.y2021.m09.boyuan.小宋小宋;

public class LC_53 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] result = new int[nums.length];
        result[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (result[i - 1] < 0) {
                result[i] = nums[i];
            } else {
                result[i] = nums[i] + result[i - 1];
            }
            max = Math.max(max, result[i]);
        }
        return max;
    }
}
