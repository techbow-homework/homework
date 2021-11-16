package com.techbow.homework.y2021.m10.shengyuan;

public class LC_53 {
    //Method 1: Brute Force
    public int largestSubarray(int[] array) {
        if (array.length == 1) {
            return array[0];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i; j < array.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += array[k];
                }
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    //Method 2: DP
    public int largestSubarray1(int[] array) {
        if (array.length == 1) {
            return array[0];
        }
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] + currentSum >= array[i]) {
                currentSum += array[i];
            } else {
                currentSum = array[i];
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        return maxSum;
    }
    //如果題目要求只要得出最大的長度
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
    public static void main(String[] args) {
        LC_53 test = new LC_53();
        int[] array = {2, -3, 5, -3, 7, 1};
        int result = test.largestSubarray(array);
        System.out.println(result);
    }
}
