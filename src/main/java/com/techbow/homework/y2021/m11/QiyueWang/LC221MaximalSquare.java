package com.techbow.homework.y2021.m11.QiyueWang;

public class LC221MaximalSquare {
    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int res = 0;
        for(int i = 0; i < m; i++){
            if(matrix[i][0] == '1'){
                dp[i][0] = 1;
                res = 1;
            }
        }
        for(int j = 0; j < n; j++){
            if(matrix[0][j] == '1'){
                dp[0][j] = 1;
                res = 1;
            }
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res * res;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1','1','1','0','0'},{'1','1','0','0','0'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalSquare(matrix)); //4
    }
}
//time O(mn) space O(mn)
