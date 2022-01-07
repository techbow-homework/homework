package com.techbow.homework.y2021.m10.ryanxu.LC_221;

public class LC_221 {
    public int maximalSquare(char[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int maxLen = 0;
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                maxLen = Math.max(maxLen, dp[i][0]);
            }
        }
        for (int j = 0; j < col; j++) {
            if (matrix[0][j] == '1') {
                dp[0][j] = 1;
                maxLen = Math.max(maxLen, dp[0][j]);
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }

        return maxLen * maxLen;
    }
}
