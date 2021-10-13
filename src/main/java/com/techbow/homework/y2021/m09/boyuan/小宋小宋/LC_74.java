package com.techbow.homework.y2021.m09.boyuan.小宋小宋;

public class LC_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        //corner case
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            int i = mid / cols;
            int j = mid % cols;
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}
