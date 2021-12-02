package com.techbow.homework.y2021.m11.QiyueWang;

public class LC198HouseRobber {
// public int rob(int[] nums) {
    //     int n = nums.length;
    //     if(n == 1) return nums[0];
    //     int[][] dp = new int[n][2];
    //     dp[0][1] = nums[0];
    //     dp[0][0] = 0;
    //     dp[1][0] = nums[0];
    //     dp[1][1] = nums[1];
    //     for(int i = 2; i < n; i++){
    //         dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
    //         dp[i][1] = Math.max(dp[i - 1][0] + nums[i], dp[i - 2][1] + nums[i]);
    //     }
    //     return Math.max(dp[n - 1][0], dp[n - 1][1]);
    // }

//     public int rob(int[] nums) {
//         int n = nums.length;
//         if(n == 1) return nums[0];
//         int[] dp = new int[n];
//         dp[0] = nums[0];
//         dp[1] = Math.max(nums[0], nums[1]);

//         for(int i = 2; i < n; i++){
//             dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
//         }
//         return dp[n - 1];
//     }

    public static int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int beforePrev = nums[0];
        int prev = Math.max(nums[0], nums[1]);

        for(int i = 2; i < n; i++){
            int cur = Math.max(prev, beforePrev + nums[i]);
            beforePrev = prev;
            prev = cur;
        }
        return prev;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        System.out.println(rob(nums)); // 4
        int[] nums2 = new int[]{2,1,9,33,1};
        System.out.println(rob(nums2));// 35
    }
}
