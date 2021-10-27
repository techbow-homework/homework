package com.techbow.homework.y2021.m10.rantao;

public class matrix2DSearch {
    public static boolean searchMatrix1(int[][] matrix, int target) {
        int i = 0;
        for (int k = 0; k < matrix.length; k++) {
            if (target <= matrix[k][matrix[k].length - 1]) {
                i = k;
                break;
            }
        }
        int l = 0;
        int r = matrix[i].length;
        while (l < r) {
            int m = (l + r) / 2;
            if (matrix[i][m] == target) return true;
            else if (matrix[i][m] < target) {
                l = m + 1;
            } else
                r = m;
        }
        return false;
    }

    public static boolean searchMatrix2(int[][] matrix, int target) {
        int l = 0;
        int h = matrix.length * matrix[0].length;
        int index = -1;
        while (l < h) {
            int m = (l + h) / 2;
            int value = getMatrixValue(matrix, m);
            if (target == value) return true;
            else if (target > value) {
                l = m + 1;
            } else {
                h = m;
            }
        }
        return false;
    }

    public static int getMatrixValue(int[][] matrix, int index) {
        int column = matrix[0].length;
        int row = index / column;
        int col = index % column;
        return matrix[row][col];
    }
}
