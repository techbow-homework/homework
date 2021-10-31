package com.techbow.homework.y2021.m10.kuixiaosu;

public class LC_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Corner case
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int i = m - 1;
        int j = 0;

        while (i >= 0 && j <= n-1) {
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] > target) i--;
            else j++;
        }
        return false;
    }
}
