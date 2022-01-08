package com.techbow.homework.y2021.m10.ryanxu.LC_1594;

public class LC_1594 {
    public int maxProductPath(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        long[][] dp1 = new long[row][col]; // max
        long[][] dp2 = new long[row][col]; // min
        int M = (int) 1e9 + 7;
        dp1[0][0] = grid[0][0];
        dp2[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            dp1[i][0] = dp1[i - 1][0] * grid[i][0];
            dp2[i][0] = dp1[i - 1][0] * grid[i][0];
        }
        for (int j = 1; j < col; j++) {
            dp1[0][j] = dp1[0][j - 1] * grid[0][j];
            dp2[0][j] = dp1[0][j - 1] * grid[0][j];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp1[i][j] = Math.max(Math.max(dp1[i - 1][j] * grid[i][j], dp2[i - 1][j] * grid[i][j]),
                        Math.max(dp1[i][j - 1] * grid[i][j], dp2[i][j - 1] * grid[i][j]));
                dp2[i][j] = Math.min(Math.min(dp1[i - 1][j] * grid[i][j], dp2[i - 1][j] * grid[i][j]),
                        Math.min(dp1[i][j - 1] * grid[i][j], dp2[i][j - 1] * grid[i][j]));
            }
        }

        return dp1[row - 1][col - 1] < 0 ? -1 : (int) (dp1[row - 1][col - 1] % M);
    }

    public static void main(String[] args) {
        LC_1594 lc_1594 = new LC_1594();
        int[][] grid = {{1,-2,1},{1,-2,1},{3,-4,1}};
        System.out.println(lc_1594.maxProductPath(grid));
    }
}
