package com.techbow.homework.y2021.m10.QiyueWang;

import java.util.Arrays;

public class LC2033MinimumOperationsToMakeAUniValuedGrid {
    public static int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int[] temp = new int[m * n];
        int res = 0;
        int prev = grid[0][0];
        for (int i = 0; i < n * m; i++) {
            int cur = grid[i / n][i % n];
            if (i > 0 && (cur - prev) % x != 0) return -1;
            temp[i] = cur;
            prev = temp[i];
        }
        Arrays.sort(temp);
        int median = temp[m * n / 2];
        for (int i : temp) {
            res += Math.abs(i - median) / x;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,5},{2,3}};
        int[][] grid2 = new int[][]{{1,2},{3,4}};
        int[][] grid3 = new int[][]{{2,4},{6,8}};
        System.out.println(minOperations(grid,1)); // 5
        System.out.println(minOperations(grid2,2)); // -1
        System.out.println(minOperations(grid3,2)); // 4
    }
}
