package com.techbow.homework.y2021.m09.shengyuan;

import java.util.List;

public class LC_120 {
    int min = Integer.MAX_VALUE;
    public int minimumSum(int[][] matrix) {
        //cc
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        minimumSum(matrix, 0, 0, 0);
        return min;

    }
    //S1: Top-Bottom recursion (DFS), Time = O(2^n)
    private void minimumSum(int[][] matrix, int i, int j, int sum) {
        //base case
        if (i == matrix.length) {
            if (sum < min) {
                min = sum;
            }
            return;
        }
        //dfs
        minimumSum(matrix, i + 1, j, sum + matrix[i][j]);
        minimumSum(matrix, i + 1, j + 1, sum + matrix[i][j]);
    }

    //S2: Bottom-Top Recursion (DFS), Time = O(2^n)
    public int minimumTotal(int[][] matrix) {
        //cc
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        return minimumTotal(matrix, 0, 0);
    }
    private int minimumTotal(int[][] matrix, int i, int j) {
        //base case
        if (i == matrix.length) {
            return 0;
        }
        int left = minimumTotal(matrix, i + 1, j);
        int right = minimumTotal(matrix, i + 1, j + 1);
        return Math.min(left, right) + matrix[i][j];
    }

    //S3: Recursion with DP pruning
    public int minimumTotalDP(int[][] matrix) {
        //cc
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        Integer[][] dp = new Integer[matrix.length][];
        return minimumTotalDP(matrix, 0, 0, dp);
    }

    private int minimumTotalDP(int[][] matrix, int i, int j, Integer[][] dp) {
        //base case
        if (i == matrix.length) {
            return 0;
        }
        if (dp[i] == null) {
            dp[i] = new Integer[matrix[i].length];
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int left = minimumTotalDP(matrix, i + 1, j, dp);
        int right = minimumTotalDP(matrix, i + 1, j + 1, dp);
        dp[i][j] = Math.min(left, right) + matrix[i][j];
        return dp[i][j];
    }

    //S4: DP, Time = O(n ^ 2)
    public int minSum(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[][] dp = new int[len][len];
        //base case 從最後一層開始
        for (int i = 0; i < len; i++) {
            dp[len - 1][i] = triangle.get(len - 1).get(len);            //matrix[i][j]
        }
        for (int i = len - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1] + triangle.get(i).get(j));
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        LC_120 test = new LC_120();
        int[][] matrix = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        int result = test.minimumSum(matrix);
        int result1 = test.minimumTotal(matrix);
        System.out.println(result);
        System.out.println(result1);
    }
}
