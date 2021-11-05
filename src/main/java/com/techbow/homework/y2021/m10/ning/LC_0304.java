package com.techbow.homework.y2021.m10.ning;

/*
constraints:
1 <= m,n <= 200
0 <= row1 <= row2 < m
0 <= col1 <= col2 < n
 */
public class LC_0304 {
    // S1: brute force
    // time: O(m*n)
    // space: O(1) -- this.matrix is reference of matrix, not deep copy
//    private int[][] matrix;
//    // constructor
//    public LC_0304(int[][] matrix) {
//        this.matrix = matrix;
//    }
//    public int sumRegion(int row1, int col1, int row2, int col2) {
//        int sum = 0;
//        for (int row = row1; row <= row2; row++) {
//            for (int col = col1; col <= col2; col++) {
//                sum += matrix[row][col];
//            }
//        }
//        return sum;
//    }

    // S2: caching -- pre-processing all possible sub-matrix and compute its sum
    // time: O(1) per query, but O(m^2 * n^2) pre-computation
    // space: O(m^2 * n^2)

    // S3: caching rows -- inspired by 1d array, cumulative sum for each row
    // time: O(m) per query, O(mn) pre-computation
    // space: O(mn)

    // S4: caching regions -- compute cumulative region sum
    // for example, we have origin O at (0,0) and sumRegion A(row1, col1), B(row1, col2),
    // C(row2, col1), D(row2, col2), so
    // Sum(ABCD) = Sum(OD) - Sum(OB) - Sum(OC) + Sum(OA)
    // time: O(1) per query, O(mn) pre-computation
    // space: O(mn)
    private int[][] dp;
    // constructor
    public LC_0304(int[][] matrix) {
        // cc
        int rows = matrix.length;
        int cols = matrix[0].length;
        dp = new int[rows + 1][cols + 1];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                dp[row + 1][col + 1] = dp[row + 1][col] + dp[row][col + 1] + matrix[row][col] - dp[row][col];
            }
        }
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
    }
}
