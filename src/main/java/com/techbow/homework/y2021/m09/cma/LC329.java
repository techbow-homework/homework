package com.techbow.homework.y2021.m09.cma;

public class LC329 {
    class Solution {
        public int longestIncreasingPath(int[][] matrix) {
            if(matrix == null || matrix.length ==0|| matrix[0] == null || matrix[0].length ==0 ){
                return 0;
            }
            int row = matrix.length, col = matrix[0].length;
            int mem[][] = new int[row][col];

            int max = 0;
            for(int i = 0; i < row; i ++){
                for(int j = 0 ; j < col; j ++){
                    max = Math.max(max, dfs(matrix, -1, i,j, mem));
                }
            }
            return max;

        }
        private int dfs(int[][] matrix, int curSum, int i , int j , int[][] mem){
            int row = matrix.length, col = matrix[0].length;
            if(i < 0|| i >= row || j <0 || j>=col || matrix[i][j] <= curSum){
                return 0;
            }

            if(mem[i][j] != 0){
                return mem[i][j];
            }
            int max = 0;
            max = Math.max(max, dfs(matrix, matrix[i][j], i-1,j, mem));
            max = Math.max(max, dfs(matrix, matrix[i][j], i+1,j, mem));
            max = Math.max(max, dfs(matrix, matrix[i][j], i,j-1, mem));
            max = Math.max(max, dfs(matrix, matrix[i][j], i,j+1, mem));
            mem[i][j] = max + 1;
            return max + 1;
        }
    }

}
