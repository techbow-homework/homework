package com.techbow.homework.y2021.m10.yeboyr.Nov06;

class BinarySearch {
    public int[] matrixSearch(int[][] matrix, int target) {
        //{}			{null, ......}               {{}, ...}
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return new int[] {-1, -1};
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int start = 0, end = rows * cols - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int i = mid / cols;
            int j = mid % cols;
            if (matrix[i][j] == target) {
                return new int[] {i, j};
            } else  if (matrix[i][j] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return new int[] {-1, -1};
    }
    //Log（m*n）

}
