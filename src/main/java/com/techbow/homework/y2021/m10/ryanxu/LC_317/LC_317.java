package com.techbow.homework.y2021.m10.ryanxu.LC_317;

import java.util.LinkedList;
import java.util.Queue;

public class LC_317 {

    private int row;
    private int col;

    public int shortestDistance(int[][] grid) {

        if (grid == null) {
            return -1;
        }
        this.row = grid.length;
        if (this.row == 0) {
            return -1;
        }
        this.col = grid[0].length;
        if (this.col == 0) {
            return -1;
        }

        // start from each 1 and mark distance between staring point and each valid 0
        int res = Integer.MAX_VALUE;
        int[][] copy = grid.clone();
        int[][] cost = new int[this.row][this.col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (copy[i][j] == 1) {
                    bfs(copy, i, j, cost);
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (copy[i][j] == 0) {
                    res = Math.min(res, cost[i][j]);
                }
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void bfs(int[][] grid, int x, int y, int[][] cost) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(x * this.col + y);
        boolean[][] visited = new boolean[this.row][this.col];
        visited[x][y] = true;
        int distance = 1;
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int cur = queue.poll();
                int curX = cur / this.col;
                int curY = cur % this.col;
                for (int d = 0; d < directions.length; d++) {
                    int nextX = curX + directions[d][0];
                    int nextY = curY + directions[d][1];
                    if (inArea(nextX, nextY) && !visited[nextX][nextY] && grid[nextX][nextY] == 0) {
                        cost[nextX][nextY] += distance;
                        visited[nextX][nextY] = true;
                        queue.add(nextX * this.col + nextY);
                    }
                }
            }
            distance++;
        }

        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    grid[i][j] = 2;
                }
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < this.row && y >= 0 && y < this.col;
    }

    public static void main(String[] args) {
        LC_317 lc_317 = new LC_317();
        int[][] grid = {{1},{0},{1}};
        System.out.println(lc_317.shortestDistance(grid));
    }
}
