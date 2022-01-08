package com.techbow.homework.y2021.m10.ryanxu.LC_1937;

public class LC_1937 {
    public long maxPoints(int[][] points) {

        if (points == null || points.length == 0) {
            return 0;
        }

        int row = points.length;
        int col = points[0].length;
        long res = Long.MIN_VALUE;
        long[][] dp = new long[row][col];
        for (int j = 0; j < col; j++) {
            dp[0][j] = points[0][j];
        }
        for (int i = 1; i < row; i++) {
            Long rollingMax = Long.MIN_VALUE;
            for (int j = col - 1; j >= 0; j--) { //int j = col - 1; j >= 0; j--
                rollingMax = Math.max(rollingMax, dp[i - 1][j] - j);
                dp[i][j] = Math.max(dp[i][j], rollingMax + points[i][j] + j);
                res = Math.max(res, dp[i][j]);
            }
            rollingMax = Long.MIN_VALUE;
            for (int j = 0; j < col; j++) {
                rollingMax = Math.max(rollingMax, dp[i - 1][j] + j);
                dp[i][j] = Math.max(dp[i][j], rollingMax + points[i][j] - j);
                res = Math.max(res, dp[i][j]);
            }

        }

        long temp = Long.MIN_VALUE;
        for (int i = 0; i < col; i++) {
            temp = Math.max(temp, dp[row - 1][i]);
        }

        return temp;
    }

    public static void main(String[] args) {
        LC_1937 lc_1937 = new LC_1937();
        int[][] points = {{1,2,3}, {1,5,1}, {3,1,1}};
        System.out.println(lc_1937.maxPoints(points));
    }
}
