package com.techbow.homework.y2021.m11.dijieshuibuxing.算法冲刺.bfs;

/*
Given a 2D array of characters grid of size m x n, you need to find if there exists any cycle consisting of the same value in grid.

A cycle is a path of length 4 or more in the grid that starts and ends at the same cell. From a given cell, you can move to one of the cells adjacent to it - in one of the four directions (up, down, left, or right), if it has the same value of the current cell.

Also, you cannot move to the cell that you visited in your last move. For example, the cycle (1, 1) -> (1, 2) -> (1, 1) is invalid because from (1, 2) we visited (1, 1) which was the last visited cell.

Return true if any cycle of the same value exists in grid, otherwise, return false.



Example 1:



Input: grid = [["a","a","a","a"],["a","b","b","a"],["a","b","b","a"],["a","a","a","a"]]
Output: true
Explanation: There are two valid cycles shown in different colors in the image below:

Example 2:



Input: grid = [["c","c","c","a"],["c","d","c","c"],["c","c","e","c"],["f","c","c","c"]]
Output: true
Explanation: There is only one valid cycle highlighted in the image below:

Example 3:



Input: grid = [["a","b","b"],["b","z","b"],["b","b","a"]]
Output: false
 */


import java.util.LinkedList;
import java.util.Queue;

// 这道题重要的是queue里的元素要记录之前的prev x y 坐标，保证每次不会往回走回头路。
// 建立一个queue，对每个点做bfs，已经visited过的点，就不visit 了； 对每个点都visit是怕漏解
public class LC1559DetectCyclesin2DGrid {
    private static final int[][] DIRECTIONS = {{-1,0},{1,0},{0,-1},{0,1}};
    public static boolean containsCycle(char[][] grid) {
        //cc


        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];

        for(int i = 0 ; i < row; i ++){
            for( int j = 0; j < col; j++){
                if(visited[i][j]) continue;
                queue.offer(new int[]{i,j,-1,-1});
                visited[i][j] = true;

                while(!queue.isEmpty()){
                    int[] cur = queue.poll();
                    int r = cur[0], c = cur[1],pr = cur[2],pc = cur[3];

                    for(int[] dir:DIRECTIONS){
                        int rr = r + dir[0];
                        int cc = c + dir[1];
                        if(rr < 0  || rr >= row || cc < 0 || cc >= col) continue;
                        if(rr == pr && cc == pc) continue;
                        if(grid[rr][cc]!=grid[r][c])continue;

                        if(visited[rr][cc]) return true;

                        queue.offer(new int[]{rr,cc,r,c});
                        visited[rr][cc] = true;
                    }
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        char[][] grid = {{'a', 'b', 'b' }, {'b', 'z', 'b' }, {'b', 'b', 'a' }};
        containsCycle(grid);
    }
}
