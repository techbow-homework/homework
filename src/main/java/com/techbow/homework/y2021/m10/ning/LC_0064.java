package com.techbow.homework.y2021.m10.ning;

/*
constraints:
non-negative numbers
1 <= m,n <= 200
path from top left to bottom right
move only down and right
单值问题，暗示可以考虑dp
 */

/*
time: O(m*n)
space: O(m*n)
 */
public class LC_0064 {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];

        // fill first row
        for (int i = 1; i < cols; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        // fill first column
        for (int j = 1; j < rows; j++) {
            dp[j][0] = dp[j-1][0] + grid[j][0];
        }
        // fill the rest of dp matrix
        for (int ii = 1; ii < rows; ii++) {
            for (int jj = 1; jj < cols; jj++) {
                dp[ii][jj] = Math.min(dp[ii - 1][jj], dp[ii][jj - 1]) + grid[ii][jj];
            }
        }

        return dp[rows - 1][cols - 1];
    }
}
