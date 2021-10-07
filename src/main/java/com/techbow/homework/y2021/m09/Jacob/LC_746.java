package com.techbow.homework.y2021.m09.Jacob;

/*
public class LC_746 {
    public void minCostClimbingStairs(int[] a) {
        int n = a.length;
        int[] dp = new int[n];
//<<<<<<<HEAD
        dp[0] = a[0];
        dp[1] = a[1];
        for (int i = 2; i < a.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2] + a(i));
//=======
            dp[0] = a[0];
            dp[1] = a[1];
            for (int i = 2; i < a.length; i++) {
//<<<<<<< main
                //         dp[i] = Math.min(dp[i-1], dp[i-2] + cost(i));
//=======
                dp[i] = Math.min(dp[i - 1], dp[i - 2] + a[i]);
//>>>>>>> main
            }
            // return Math.min(dp[n-1], dp[n-2]);
        }
    }
}

//Homework
*/


