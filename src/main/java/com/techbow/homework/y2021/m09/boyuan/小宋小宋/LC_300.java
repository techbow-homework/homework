package com.techbow.homework.y2021.m09.boyuan.小宋小宋;

public class LC_300 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res,1);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    res[i] = Math.max(res[i], res[j] + 1);
                }
            }
        }
        int largest = 0;
        for (int k : res) {
            largest = Math.max(largest, k);
        }
        return largest;
    }
}
