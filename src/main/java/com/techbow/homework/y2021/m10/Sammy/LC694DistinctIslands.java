package com.techbow.homework.y2021.m10.Sammy;

import java.util.HashSet;

public class LC694DistinctIslands {
    public int numDistinctIslands(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        HashSet<String> shape = new HashSet<>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1){
                    StringBuilder sb = new StringBuilder();
                    findDistinctIsland(grid, row, col, i, j, "S", sb);
                    shape.add(sb.toString());
                }
            }
        }
        return shape.size();
    }
    private void findDistinctIsland(int[][] grid, int row, int col, int i, int j, String path, StringBuilder sb){
        if(i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == 0) return;
        //change number onboard in order to set it to be visited...no need to have a boolean visited board.
        grid[i][j] = 0;
        sb.append(path);
        findDistinctIsland(grid, row, col, i + 1, j, "d", sb);
        findDistinctIsland(grid, row, col, i - 1, j, "u", sb);
        findDistinctIsland(grid, row, col, i, j + 1, "r", sb);
        findDistinctIsland(grid, row, col, i, j - 1, "l", sb);
        sb.append("E");
    }
}
