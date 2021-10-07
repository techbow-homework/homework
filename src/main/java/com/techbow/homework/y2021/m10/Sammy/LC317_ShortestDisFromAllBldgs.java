package com.techbow.homework.y2021.m10.Sammy;

import java.util.LinkedList;
import java.util.Queue;

public class LC317_ShortestDisFromAllBldgs {
    public int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int[][] sumDistance = new int[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1 ){
                    queue.offer(new int[]{i,j});
                    curBldgDis(grid, queue, row, col, sumDistance);
                }
            }
        }
        int res = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 0 ){
                    res = Math.min(sumDistance[i][j], res);
                }
            }
        }
        return res;
    }
    private static final int[][] DIRECTIONS = {{0,1},{1,0},{0,-1},{-1,0}};
    private void curBldgDis(int[][] grid, Queue<int[]> queue, int row, int col, int[][] sum ){
        int len = 1;
        boolean[][] visited = new boolean [row][col];
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0) {
                int[] cur = queue.poll();
                for(int[] dir: DIRECTIONS){
                    int nextx = cur[0] + dir[0];
                    int nexty = cur[1] + dir[1];
                    if(nextx < 0 || nextx >= row || nexty < 0 || nexty >= col || visited[nextx][nexty] || grid[nextx][nexty] == 2) continue;
                    queue.offer(new int[]{nextx, nexty});
                    visited[nextx][nexty] = true;
                    sum[nextx][nexty] += len;
                }
            }
            len++;
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 0 && !visited[i][j]){
                    grid[i][j] = 2;
                }
            }
        }
    }
}
