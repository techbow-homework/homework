package com.techbow.homework.y2021.m11.mengyu;

public class LC931 {
    int minSum = Integer.MAX_VALUE;
    public int minFallingPathSum(int[][] matrix) {
        Integer[][] dupHolder = new Integer[matrix.length][matrix[0].length];
        for (int start = 0; start < matrix[0].length; start++) {
            int sum = dfs(matrix, 0, start, dupHolder);
            minSum = sum < minSum ? sum : minSum;
        }
        return minSum;
    }

    private int dfs(int[][] matrix, int i, int j, Integer[][] dupHolder) {
        if (i == matrix.length) {
            return 0;
        }
        if (j < 0 || j >= matrix[0].length) {
            return Integer.MAX_VALUE;
        }
        if (dupHolder[i][j] != null) {
            return dupHolder[i][j];
        }
        int left = dfs(matrix, i + 1, j - 1, dupHolder);
        int mid = dfs(matrix, i + 1, j, dupHolder);
        int right = dfs(matrix, i + 1, j + 1, dupHolder);
        int lowerLayerMin = Math.min(Math.min(left, mid), right);
        dupHolder[i][j] = matrix[i][j] + lowerLayerMin;
        return matrix[i][j] + lowerLayerMin;
    }
}
