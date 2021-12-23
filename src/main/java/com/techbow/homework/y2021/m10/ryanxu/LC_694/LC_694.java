package com.techbow.homework.y2021.m10.ryanxu.LC_694;

import java.util.HashSet;

public class LC_694 {

    private int row;
    private int col;

    public int numDistinctIslands(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        row = grid.length;
        col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        HashSet<String> res = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    StringBuilder path = new StringBuilder();
                    dfs(grid, i, j, visited, 's', path);
                    res.add(path.toString());
                }
            }
        }

        return res.size();
    }

    private void dfs(int[][] grid, int i, int j, boolean[][] visited, char status, StringBuilder path) {

        if (!inArea(i, j) || visited[i][j] || grid[i][j] != 1) {
            return;
        }

        path.append(status);
        visited[i][j] = true;
        dfs(grid, i - 1, j, visited, 'u', path);
        dfs(grid, i, j - 1, visited, 'l', path);
        dfs(grid, i + 1, j, visited, 'd', path);
        dfs(grid, i, j + 1, visited, 'r', path);
        path.append('e');
    }

    private boolean inArea(int i, int j) {
        return i >= 0 && i < row && j >= 0 && j < col;
    }
}
