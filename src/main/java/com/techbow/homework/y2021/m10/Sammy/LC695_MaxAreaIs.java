package com.techbow.homework.y2021.m10.Sammy;

import java.util.LinkedList;
import java.util.Queue;

public class LC695_MaxAreaIs {
    public int maxAreaOfIsland(int[][] grid){
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return -1;
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<>();
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;
                    res = Math.max(res, findCurAreaIsland(grid, queue, visited, row, col));
                }
            }
        }
        return res == Integer.MIN_VALUE ? 0 : res;
    }
    private static final int[][] DIRECTIONS = {{0,1}, {1,0}, {0,-1},{-1,0}};
    private int findCurAreaIsland(int[][] grid, Queue<int[]> queue, boolean[][] visited, int row, int col){
        int area = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int[] cur = queue.poll();
                for(int[] dir: DIRECTIONS){
                    int nextx = cur[0] + dir[0];
                    int nexty = cur[1] + dir[1];
                    if(nextx < 0 || nextx >= row || nexty < 0 || nexty >= col || visited[nextx][nexty] || grid[nextx][nexty] == 0){
                        continue;
                    }
                    queue.offer(new int[]{nextx, nexty});
                    visited[nextx][nexty] = true;
                    area++;
                }
            }
        }
        return area;
    }
}
