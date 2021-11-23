package com.techbow.homework.y2021.m11.mengyu;

import java.util.LinkedList;
import java.util.Queue;

public class LC200NumberOfIslands {

    static final int[][] DIRECTION = {{0,1},{0,-1},{-1,0},{1,0}};
    public int numIslands(char[][] grid) {
        int islandCount = 0;
        Queue<int[]> islandQueue = new LinkedList<>();
        boolean[][] checkVisited = new boolean[grid.length][grid[0].length];
        islandCount = loadIsland(grid, islandQueue, islandCount, checkVisited);
        return islandCount;
    }
    private void bfs(char[][] grid, Queue<int[]> queue, boolean[][] checkVisited) {
        while (!queue.isEmpty()) {
            int[] island = queue.poll();
            int curRow = island[0];
            int curCol = island[1];
            for (int[] dir : DIRECTION) {
                int nextRow = curRow + dir[0];
                int nextCol = curCol + dir[1];
                if (nextRow >= 0 && nextRow < grid.length &&
                        nextCol >= 0 && nextCol < grid[0].length &&
                        grid[nextRow][nextCol] == '1' && checkVisited[nextRow][nextCol] != true) {
                    queue.offer(new int[] {nextRow, nextCol});
                    checkVisited[nextRow][nextCol] = true;
                }
            }
            grid[curRow][curCol] = '0';
        }
    }
    private int loadIsland(char[][] grid, Queue<int[]> queue, int islandCount, boolean[][] checkVisited) {
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    queue.offer(new int[] {i, j});
                    bfs(grid, queue, checkVisited);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    public static void main(String[] args) {
        char[][] grid = new char[][] {
                {'1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','0','1','0','1','1'},
                {'0','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','0'},
                {'1','0','1','1','1','0','0','1','1','0','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','0','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','0','1','1','1','1','1','1','0','1','1','1','0','1','1','1','0','1','1','1'},
                {'0','1','1','1','1','1','1','1','1','1','1','1','0','1','1','0','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'0','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','0','1','1','1','1','1','1','1','0','1','1','1','1','1','1'},
                {'1','0','1','1','1','1','1','0','1','1','1','0','1','1','1','1','0','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','0'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','0'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'}
        };
        LC200NumberOfIslands test = new LC200NumberOfIslands();
        System.out.println(test.numIslands(grid));
    }
}
