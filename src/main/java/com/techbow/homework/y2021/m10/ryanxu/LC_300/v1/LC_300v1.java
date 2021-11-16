package com.techbow.homework.y2021.m10.ryanxu.LC_300.v1;

public class LC_300v1 {
    public int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int res = 0;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
