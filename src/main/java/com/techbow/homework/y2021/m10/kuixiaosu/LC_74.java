package com.techbow.homework.y2021.m10.kuixiaosu;

public class LC_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        //corner case
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int m = matrix[0].length;
        int n = matrix.length;
        int start = 0;
        int end = m * n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int i = mid / m;
            int j = mid % m;
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] > target) end = mid - 1;
            else start = mid + 1;
        }
        return false;
    }
}
