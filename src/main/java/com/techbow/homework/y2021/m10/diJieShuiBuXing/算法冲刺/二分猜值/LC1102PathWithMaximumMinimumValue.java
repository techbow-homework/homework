package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法冲刺.二分猜值;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an m x n integer matrix grid, return the maximum score of a path starting at (0, 0) and ending at (m - 1, n - 1) moving in the 4 cardinal directions.
 *
 * The score of a path is the minimum value in that path.
 *
 * For example, the score of the path 8 → 4 → 5 → 9 is 4.
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[5,4,5],[1,2,6],[7,4,6]]
 * Output: 4
 * Explanation: The path with the maximum score is highlighted in yellow.
 * Example 2:
 *
 *
 * Input: grid = [[2,2,1,2,2,2],[1,2,2,2,1,2]]
 * Output: 2
 * Example 3:
 *
 *
 * Input: grid = [[3,4,6,3,4],[0,2,1,1,7],[8,8,3,2,7],[3,2,4,9,8],[4,1,2,0,0],[4,6,5,4,3]]
 * Output: 3
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * 0 <= grid[i][j] <= 109
 */
public class LC1102PathWithMaximumMinimumValue {
    private static final int[][] DIRECTION = {{0,1},{0,-1},{1,0},{-1,0}};

    public int maximumMinimumPath(int[][] grid) {
        //cc

        int l = 0, r = (int) 1e9;

        while( l <= r){
            int mid = l + ( r - l)/2;
            if(helper(grid,mid)){
                l = mid + 1;
            }else{
                r = mid + 1;
            }
        }
        return r;
    }

    private boolean helper(int[][] grid, int t){
        int m = grid.length,n = grid[0].length;
        if(grid[0][0] < t) return false;

        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(0);
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;

        while(!queue.isEmpty()){
            int cur = queue.poll();
            int i = cur / n, j = cur % n;

            if(i == m - 1 && j == n - 1){
                return  true;
            }

            for(int[] dir : DIRECTION){
                int ii = i + dir[0];
                int jj = j + dir[1];

                if(ii >= 0  && ii < m && jj >= 0 && jj < n && !visited[ii][jj]
                && grid[ii][jj] >= t){
                    queue.offer(ii * n + jj);
                    visited[ii][jj] = true;
                }
            }

        }
        return false;
    }
}
