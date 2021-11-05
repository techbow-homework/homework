package com.techbow.homework.y2021.m10.kuixiaosu;

public class MatrixSearch {
    public int[] matrixSearch(int[][] matrix, int target) {
        // corner case
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return new int[] {-1, -1};
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int start = 0;
        int end = rows * cols - 1;
        int mid = 0;

        while (start <= end){
            mid = start + (end - start) / 2;
            int i = mid / cols;
            int j = mid % cols;
            if (matrix[mid] == target) return new int[] {i,j};
            else if (matrix[mid] > target) start = mid + 1;
            else end = mid - 1;
        }
        return new int[] {-1,-1};
    }
}
