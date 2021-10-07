package com.techbow.homework.y2021.m09.QiyueWang;

import java.util.LinkedList;
import java.util.Queue;

public class LC463IslandPerimeter {
    public static int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int x = 0; // starting point
        int y = 0;
        search:
        {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        x = i;
                        y = j;
                        break search;
                    }
                }
            }
        }
        int[][] dirs = new int[][]{{1, 0},{0, -1},{-1, 0},{0, 1}};
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        while(!q.isEmpty()){
            int[] pos = q.poll();
            visited[pos[0]][pos[1]] = true;
            res += 4;
            for(int[] d : dirs){
                int newX = pos[0] + d[0];
                int newY = pos[1] + d[1];
                if(newX < m  && newX >= 0 && newY < n && newY >= 0 && grid[newX][newY] == 1 ){
                    if(!visited[newX][newY]){
                        q.offer(new int[] {newX, newY});
                        visited[newX][newY] = true;
                    }
                    res -= 1; // two adj squares consumes 2 edges
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,1},{1,1}};
        int[][] grid2 = new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(islandPerimeter(grid)); // 8
        System.out.println(islandPerimeter(grid2)); // 16
    }
}
// time O(mn) space O(mn)
