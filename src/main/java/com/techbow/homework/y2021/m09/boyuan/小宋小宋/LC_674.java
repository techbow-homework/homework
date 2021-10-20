package com.techbow.homework.y2021.m09.boyuan.小宋小宋;

public class LC_674 {
    public int findLengthOfLCIS(int[] nums) {
        int result = 0;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i-1] >= nums[i]) temp = i;
            result = Math.max(result, i - temp + 1);
        }
        return result;
    }
}
