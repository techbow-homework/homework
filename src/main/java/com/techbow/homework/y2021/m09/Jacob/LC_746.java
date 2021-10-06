package com.techbow.homework.y2021.m09.Jacob;

import java.io.OptionalDataException;

public class LC_746 {
    public int minCostClimbingStairs(int[] cost)  {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i-1], dp[i-2] + cost[i]);
        }
        return Math.min(dp[n-1], dp[n-2]);
    }
}
//Homework

