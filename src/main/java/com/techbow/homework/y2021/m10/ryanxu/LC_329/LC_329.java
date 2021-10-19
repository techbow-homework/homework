package com.techbow.homework.y2021.m10.ryanxu.LC_329;

public class LC_329 {

    private int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private int row;
    private int col;

    public int longestIncreasingPath(int[][] matrix) {

        if (matrix == null) {
            return 0;
        }
        this.row = matrix.length;
        if (this.row == 0) {
            return 0;
        }
        this.col = matrix[0].length;
        if (this.col == 0) {
            return 0;
        }

        int res = 0;
        Integer[][] memo = new Integer[this.row][this.col];
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                res = Math.max(res, dfs(matrix, i, j, memo));
            }
        }

        return res;
    }

    // stand at (i, j) the longest path Len
    private int dfs(int[][] matrix, int i, int j, Integer[][] memo) {

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        int res = 1;

        for (int d = 0; d < this.directions.length; d++) {
            int nextI = i + directions[d][0];
            int nextJ = j + directions[d][1];
            if (inArea(nextI, nextJ) && matrix[nextI][nextJ] > matrix[i][j]) {
                res = Math.max(res, dfs(matrix, nextI, nextJ, memo) + 1);
            }
        }

        memo[i][j] = res;
        return res;
    }

    private boolean inArea(int i, int j) {
        return i >= 0 && i < this.row && j >= 0 && j < this.col;
    }
}
