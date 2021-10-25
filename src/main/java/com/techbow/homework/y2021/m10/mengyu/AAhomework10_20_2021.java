package com.techbow.homework.y2021.m10.mengyu;

import java.util.LinkedList;
import java.util.Queue;

public class AAhomework10_20_2021 {
    public int shortestDistance(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][]cost = new int [row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    bfs(grid, i, j, cost);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j] == 0) {
                    min = Math.min(min, cost[i][j]);
                }
            }
        }
        if (min == Integer.MAX_VALUE) return -1;
        return min;
    }
    private static final int[][] DIRECTIONS = {{-1,0},{1,0},{0,1},{0,-1}};
    private void bfs(int[][] matrix, int startingRow, int startingCol, int[][] distance) {
        int row = matrix.length;
        int col = matrix[0].length;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startingRow * col + startingCol);
        boolean[][] visited = new boolean[row][col];
        visited[startingRow][startingCol] = true;
        int minLen = 0;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            while (queueSize-- > 0) {
                int cur = queue.poll();
                int curRow = cur / col, curCol = cur % col;
                distance[curRow][curCol] += minLen;
                for (int[] dir : DIRECTIONS) {
                    int rowIndex = curRow + dir[0], colIndex = curCol + dir[1];
                    if (rowIndex >= 0 && rowIndex < row &&
                            colIndex >= 0 && colIndex < col &&
                            matrix[rowIndex][colIndex] == 0 &&
                            visited[rowIndex][colIndex] == false) {
                        queue.offer(rowIndex * col + colIndex);
                        visited[rowIndex][colIndex] = true;
                    }
                }
            }
            minLen++;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] != 1 && visited[i][j] == false) {
                    matrix[i][j] = 2;
                }
            }
        }
    }
}
