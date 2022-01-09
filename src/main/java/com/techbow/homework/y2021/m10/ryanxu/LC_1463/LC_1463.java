package com.techbow.homework.y2021.m10.ryanxu.LC_1463;

import java.util.Arrays;

public class LC_1463 {
    public int cherryPickup(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[col][col];
        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MIN_VALUE);
        }
        dp[0][col - 1] = grid[0][0] + grid[0][col - 1];
        int res = Integer.MIN_VALUE;
        for (int r = 1; r < row; r++) {
            int[][] temp = copyDp(dp);
            for (int i = 0; i < col; i++) {
                for (int j = 0; j < col; j++) {
                    for (int a = i - 1; a <= i + 1; a++) {
                        for (int b = j - 1; b <= j + 1; b++) {
                            if (a < 0 || a >= col || b < 0 || b >= col) {
                                continue;
                            }
                            if (i != j) {
                                dp[i][j] = Math.max(dp[i][j], temp[a][b] + grid[r][i] + grid[r][j]);
                            } else {
                                dp[i][j] = Math.max(dp[i][j], temp[a][b] + grid[r][i]);
                            }
                            res = Math.max(res, dp[i][j]);
                        }
                    }
                }
            }
        }

        return res;
    }

    private int[][] copyDp(int[][] dp) {

        int row = dp.length;
        int col = dp[0].length;
        int[][] res = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res[i][j] = dp[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC_1463 lc_1463 = new LC_1463();
        int[][] grid = {{1,0,0,0,0,0,1},{2,0,0,0,0,3,0},{2,0,9,0,0,0,0},{0,3,0,5,4,0,0},{1,0,2,3,0,0,6}};
        System.out.println(lc_1463.cherryPickup(grid));
    }
}
