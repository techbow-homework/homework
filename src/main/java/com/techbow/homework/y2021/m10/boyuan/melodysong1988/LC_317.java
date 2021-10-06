package com.techbow.homework.y2021.m10.boyuan.melodysong1988;

import java.util.*;

public class LC_317 {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[][] cost = new int[row][col];
        for (int i = 0; i < row; i++ ) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    bfs(grid, cost, i, j);
                }
            }
        }
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0 && cost[i][j] != 0) {
                    minDistance = Math.min(minDistance, cost[i][j]);
                }
            }
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    private void bfs(int[][] matrix, int[][] cost, int x, int y) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;

        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                cost[cur[0]][cur[1]] += distance;
                for (int[] dir : DIRECTIONS) {
                    int rowIdx = cur[0] + dir[0];
                    int colIdx = cur[1] + dir[1];
                    if (rowIdx < row && rowIdx >= 0 && colIdx < col && colIdx >= 0 && matrix[rowIdx][colIdx] == 0 && !visited[rowIdx][colIdx]) {
                        queue.offer(new int[] {rowIdx, colIdx});
                        visited[rowIdx][colIdx] = true;
                    }
                }
            }
            distance++;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0 && !visited[i][j]) {
                    matrix[i][j] = 2;
                }
            }
        }

    }


    public static void main (String[] args) {
        LC_317 SO = new LC_317();

        int[][] grid = {
                {1, 0, 2, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0}
        };
        int res = SO.shortestDistance(grid);

        System.out.println(res);
    }
}
