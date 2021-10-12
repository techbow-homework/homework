package com.techbow.homework.y2021.m10.shengyuan;

public class LC_53 {
    public int lengthOfSubarray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] dp = new int[array.length];
        dp[0] = 1;
        int max = dp[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i]> array[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
