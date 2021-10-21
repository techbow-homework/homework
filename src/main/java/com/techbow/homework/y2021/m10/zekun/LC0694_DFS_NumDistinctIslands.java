package com.techbow.homework.y2021.m10.zekun;

public class LC0694_DFS_NumDistinctIslands {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1,0}, {0, 1}, {0, -1}};

    public int numDistinctIslands(int[][] grid) {
        //cc
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;

        int nrow = grid.length;
        int ncol = grid[0].length;
        Set<String> res = new HashSet<>();

        for(int x = 0; x < nrow; x++){
            for(int y = 0; y < ncol; y++){
                if(grid[x][y] == 1){
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, sb, x, y, x, y);
                    res.add(sb.toString());
                }
            }
        }
        return res.size();
    }

    private void dfs(int[][] grid, StringBuilder sb, int x, int y, int origin_x, int origin_y){
        int nrow = grid.length;
        int ncol = grid[0].length;
        //success basecase

        if(x >= 0 && x < nrow && y >= 0 && y < ncol && grid[x][y] == 1){
            grid[x][y] = 0;
            sb.append(x - origin_x);
            sb.append(y - origin_y);

            for(int[] dir : DIRECTIONS){
                dfs(grid, sb, x + dir[0], y + dir[1], origin_x, origin_y);
            }
        }else{
            return;
        }
    }
}
