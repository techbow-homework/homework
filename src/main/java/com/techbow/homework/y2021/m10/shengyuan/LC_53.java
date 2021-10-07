package com.techbow.homework.y2021.m10.shengyuan;

public class LC_53 {
<<<<<<< HEAD
    public int largestSum(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int len = array.length;
        int dp = array[0];
        int max = dp;
        for (int i = 1; i < len; i++) {
            if (dp > 0) {
                dp += array[i];
                if (dp > max) {
                    max = dp;
                }
            } else {
                dp = array[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }
=======
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
>>>>>>> e712b1360a2a1dfc15a458929f7f885292a30596
}
