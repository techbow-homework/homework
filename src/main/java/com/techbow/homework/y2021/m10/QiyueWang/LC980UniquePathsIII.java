package com.techbow.homework.y2021.m10.QiyueWang;

public class LC980UniquePathsIII {
    private static int res = 0;
    public static int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] start = new int[2];
        int totalStep = 1;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    start[0] = i;
                    start[1] = j;
                }else if(grid[i][j] == 0){
                    totalStep++;
                }
            }
        }
        dfs(grid, start[0], start[1], totalStep, visited);
        return res;
    }
    private static void dfs(int[][] grid, int x, int y, int steps, boolean[][] visited){
        if(x < 0 || y <0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1 || visited[x][y]){
            return;
        }
        if(steps == 0 && grid[x][y] == 2){
            res++;
            return;
        }
        visited[x][y] = true;
        dfs(grid, x + 1, y, steps - 1, visited);
        dfs(grid, x, y + 1, steps - 1, visited);
        dfs(grid, x - 1, y, steps - 1, visited);
        dfs(grid, x, y - 1, steps - 1, visited);
        visited[x][y] = false;
    }

    public static void main(String[] args) {
        int[][] grid1 = new int[][]{{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
        int[][] grid2 = new int[][]{{1,0,0,0},{0,0,0,0},{0,0,0,2}};
        int[][] grid3 = new int[][]{{0,1},{2,0}};
        System.out.println(uniquePathsIII(grid1));//2
        res = 0;
        System.out.println(uniquePathsIII(grid2));//4
        res = 0;
        System.out.println(uniquePathsIII(grid3));//0
    }
}
// time O(4^(mn)) space O(mn)
