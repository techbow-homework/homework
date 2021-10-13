package com.techbow.homework.y2021.m10.ning;

/*
constraints:
1 <= m,n <= 300
matrix[i][j] is '0' or '1'
 */

public class LC_0221 {
    // S1: primitive - for every possible elements time O((m*n)^2) space O(1)
    // S2: dp[][]
    // time: O(m*n)
    // space: O(m*n)
//    public int maximalSquare(char[][] matrix) {
//        int rows = matrix.length;
//        int cols = matrix[0].length;
//        int[][] dp = new int[rows][cols];
//        int max = 0;
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (i == 0 || j == 0 || matrix[i][j] == '0') {
//                    dp[i][j] = matrix[i][j] == '0' ? 0 : 1;
//                } else {
//                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
//                }
//                max = Math.max(max, dp[i][j]);
//            }
//        }
//
//        return max * max;
//    }

    // S3: dp[]
    // time: O(m*n)
    // space: O(n)
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] dp = new int[cols + 1];
        int max = 0, prev = 0;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], dp[j]), prev) + 1;
                    max = Math.max(max, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return max * max;
    }
}
