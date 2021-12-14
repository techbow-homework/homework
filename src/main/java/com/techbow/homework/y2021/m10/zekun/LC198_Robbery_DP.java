package com.techbow.homework.y2021.m10.zekun;

public class LC198_Robbery_DP {
    public int rob(int[] nums) {
        //cc
        if(nums.length == 1){
            return nums[0];
        }else if(nums.length <= 2){
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}
