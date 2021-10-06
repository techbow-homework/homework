package com.techbow.homework.y2021.m10.Sammy;

import java.util.LinkedList;
import java.util.Queue;

public class LC200NumberOfIslands {
    private static final int[][] DIRECTIONS = {{0,1}, {1,0}, {0,-1}, {-1, 0}};
    public int numIslands(char[][] grid){
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int count = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    bfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    //P.S. Queue可以考虑提到上面因为不用每次做BFS都去new一个。。we can reuse our queue...
    private void bfs(char[][] grid, boolean[][] visited, int i, int j){
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});
        visited[i][j] = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int[] cur = queue.poll();
                for(int[] dir: DIRECTIONS){
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if(x < 0 || x >= row || y < 0 || y >= col || visited[x][y] || grid[x][y] == '0') continue;
                    queue.offer(new int[]{x,y});
                    visited[x][y] = true;
                }
            }
        }
    }
}
