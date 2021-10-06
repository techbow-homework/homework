package com.techbow.homework.y2021.m10.Sammy;

import java.util.LinkedList;
import java.util.Queue;

public class LC1162_AFarAP {
    public int maxDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return -1;
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];

        return findFarLand(grid, visited, row, col);
    }

    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private void loadAllLands(Queue<int[]> queue, int[][] grid, boolean[][] visited){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    visited[i][j] = true;
                    queue.offer(new int[]{i,j});
                }
            }
        }
    }
    private int findFarLand(int[][] grid, boolean[][] visited, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        loadAllLands(queue,grid, visited);
        int minLen = 0;
        int res = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                for (int[] dir : DIRECTIONS) {
                    int nextx = cur[0] + dir[0];
                    int nexty = cur[1] + dir[1];
                    if (nextx < 0 || nextx >= row || nexty < 0 || nexty >= col || visited[nextx][nexty])
                        continue;
                    queue.offer(new int[]{nextx, nexty});
                    visited[nextx][nexty] = true;
                    grid[nextx][nexty] = minLen + 1;
                    res = Math.max(res, grid[nextx][nexty]);
                }
            }
            minLen++;
        }
        return res == -1 ? -1 : res;
    }
}
