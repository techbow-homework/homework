package com.techbow.homework.y2021.m10.ryanxu.LC_62;

public class LC_62 {
    public int uniquePaths(int m, int n) {

        // dp[i][j]: 在[i, j]位置How many possible unique paths are there，从左上角出发
        // dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        LC_62 lc_62 = new LC_62();
        System.out.println(lc_62.uniquePaths(3, 3));
    }
}
