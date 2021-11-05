package com.techbow.homework.y2021.m11.dijieshuibuxing.算法冲刺.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
You are given an m x n integer matrix grid where each cell is either 0 (empty) or 1 (obstacle). You can move up, down, left, or right from and to an empty cell in one step.

Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1) given that you can eliminate at most k obstacles. If it is not possible to find such walk return -1.



Example 1:


Input: grid = [[0,0,0],[1,1,0],[0,0,0],[0,1,1],[0,0,0]], k = 1
Output: 6
Explanation:
The shortest path without eliminating any obstacle is 10.
The shortest path with one obstacle elimination at position (3,2) is 6. Such path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
Example 2:


Input: grid = [[0,1,1],[1,1,1],[1,0,0]], k = 1
Output: -1
Explanation: We need to eliminate at least two obstacles to find such a walk.


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 40
1 <= k <= m * n
grid[i][j] is either 0 or 1.
grid[0][0] == grid[m - 1][n - 1] == 0
 */

//这个题主要考虑的是要有visited[m][n][k+1]来分别对 炸和不炸的情况做标记，因为有的时候不炸此处比炸还短。不然无法看出最短路径
public class LC1293ShortestPathinaGridwithObstaclesElimination {


    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int shortestPath(int[][] grid, int k) {
//cc
        int row = grid.length, col = grid[0].length;

        // 优化： 如果k比最短路径（没有障碍时候是m+n-1，除去起点终点，m+n-3）还多，则就炸掉最短路径所有的墙，再减去重点，m+n-1-1 就是最短路径
        //        if(k >= row+col-3) return row+ col -2;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[row][col][k+1];
        queue.offer(new int[]{0, 0, k});
        visited[0][0][k] = true;
        int res = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1], r = cur[2];
                if (x == row - 1 && y == col - 1) {
                    return res;
                }

                for (int[] dir : DIRECTIONS) {
                    int ii = x + dir[0];
                    int jj = y + dir[1];
                    if (ii < 0 || ii >= row || jj < 0 || jj >= col) continue;
                    if (grid[ii][jj] == 1) { // obstacle
                        if (r == 0) continue; // 炸弹用完了
                        if (visited[ii][jj][r - 1]) continue; //visit 过了
                        queue.offer(new int[]{ii, jj, r - 1}); //没有visited过，炸弹还有剩余，就更新剩余炸弹为r-1
                        visited[ii][jj][r - 1] = true;
                    } else {            // 空地
                        if (visited[ii][jj][r]) continue;//visit 过了
                        queue.offer(new int[]{ii, jj, r});
                        visited[ii][jj][r] = true;//visit 过了
                    }

                }

            }
            res++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}};
      System.out.println(  shortestPath(grid,1));
    }

}
