package com.techbow.homework.y2021.m10.ryanxu.LC_790;

public class LC_790 {
    public int numTilings(int n) {

        int M = (int) 1e9 + 7;
        long[][] dp = new long[n + 1][2];
        dp[0][0] = 1;
        dp[1][0] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 2][0] + dp[i - 1][1] * 2) % M;
            dp[i][1] = (dp[i - 1][1] + dp[i - 2][0]) % M;
        }

        return (int) dp[n][0];
    }
}
