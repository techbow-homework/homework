package com.techbow.homework.y2021.m10.yeboyr;



public class searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0)
            return false;
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;
        int midIdx, midElement;

        while (left <= right) {

            midIdx = left + (right - left) / 2;
            midElement = matrix[midIdx / n][midIdx % n];

            if (midElement == target)
                return true;
            else {
                if (midElement < target)
                    left = midIdx + 1;
                else
                    right = midIdx - 1;
            }
        }
        return false;
    }
}