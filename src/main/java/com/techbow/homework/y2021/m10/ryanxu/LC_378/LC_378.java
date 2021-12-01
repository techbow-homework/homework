package com.techbow.homework.y2021.m10.ryanxu.LC_378;

public class LC_378 {
    public int kthSmallest(int[][] matrix, int k) {

        if (matrix == null) {
            return 0;
        }

        int n = matrix.length;
        int start = matrix[0][0];
        int end = matrix[n - 1][n - 1];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (lessEqualCount(matrix, mid) < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }

    private int lessEqualCount(int[][] matrix, int val) {

        int n = matrix.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += lessEqualRowCount(matrix[i], val, n);
        }

        return count;
    }

    private int lessEqualRowCount(int[] row, int val, int n) {

        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (row[mid] <= val) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return end + 1;
    }
}
