package com.techbow.homework.y2021.m11.shengyuan;

public class LC_750 {
    //S1: Brute Force
    public int countCornerRectangles(int[][] grid) {
        //cc
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                for (int p = i + 1; p < m; p++) {
                    if (grid[p][j] == 0) {
                        continue;
                    }
                    for (int q = j + 1; q < n; q++) {
                        if (grid[i][q] == 1 && grid[p][q] == 1) {
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }
    //S2: Optimized without DP
    public int countCornerRectangles1(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m - 1; i++) {
            for (int p = i + 1; p < m; p++) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1 && grid[p][j] == 1) {
                        count++;
                    }
                }
                res += count * (count - 1) / 2;
            }
        }
        return res;
    }
    //S3: DP
    public int countCornerRectangles2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        int[][] dp = new int[m][m];
        for (int i = 0; i < m - 1; i++) {
            for (int p = i + 1; p < m; p++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1 && grid[p][j] == 1) {
                        res += dp[i][p];
                        dp[i][p]++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC_750 test = new LC_750();
        int[][] input = {{1, 0, 0, 1, 0}, {0, 0, 1, 0, 1},{0, 0, 0, 1, 0}, {1, 0, 1, 0, 1}};
        int result = test.countCornerRectangles(input);
        System.out.println(result);
    }
}
