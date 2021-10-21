package com.techbow.homework.y2021.m10.ning;

public class LC_0304 {
    // S1: brute force
    // time: O(m*n)
    // space: O(1) -- this.matrix is reference of matrix, not deep copy
    private int[][] matrix;
    public LC_0304(int[][] matrix) {
        this.matrix = matrix;
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int row = row1; row <= row2; row++) {
            for (int col = col1; col <= col2; col++) {
                sum += matrix[row][col];
            }
        }
        return sum;
    }

    // S2:
}
