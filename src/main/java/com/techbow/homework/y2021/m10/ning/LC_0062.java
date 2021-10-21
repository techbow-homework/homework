package com.techbow.homework.y2021.m10.ning;

/*
constraints:
1 <= m,n <= 100
path from top left to bottom right
move either down or right
 */

/*
time: O(m*n)
space: O(m*n)
 */
public class LC_0062 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // fill first row
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        // fill first column
        for (int j = 1; j < m; j++) {
            dp[j][0] = 1;
        }
        // fill the rest
        for (int ii = 1; ii < m; ii++) {
            for (int jj = 1; jj < n; jj++) {
                dp[ii][jj] = dp[ii - 1][jj] + dp[ii][jj - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
