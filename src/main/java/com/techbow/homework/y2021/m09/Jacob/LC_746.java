package com.techbow.homework.y2021.m09.Jacob;

import java.io.OptionalDataException;

public class LC_746 {
    public int minCostClimbingStairs(int[] a)  {
        int n = a.length;
        int[] dp = new int[n];
        dp[0] = a[0];
        dp[1] = a[1];
        for (int i = 2; i < a.length; i++) {
            dp[i] = Math.min(dp[i-1], dp[i-2] + a(i));
        }
        return Math.min(dp[n-1], dp[n-2]);
    }
}
//Homework

