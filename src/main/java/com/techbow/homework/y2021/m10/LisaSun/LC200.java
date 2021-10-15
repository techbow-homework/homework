package com.techbow.homework.y2021.m10.LisaSun;

public class LC200 {
    private static final int[][] DIRECTIONS = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    dfs (grid, i, j);
                    count++;
                }
            }
        }
        return count;

    }

    private void dfs (char[][] grid, int row, int col) {
        //failure case
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != '1') {
            return;
        }
        grid[row][col] = '2';

        for (int[] dir:DIRECTIONS) {
            int ii = row + dir[0];
            int jj = col + dir[1];
            if (ii >= 0 && ii < grid.length && jj >= 0 && jj <grid[0].length && grid[ii][jj] == '1') {
                dfs(grid, ii, jj);
            }
        }

    }
}
