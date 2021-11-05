package com.techbow.homework.y2021.m10.QiyueWang;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC417PacificAtlanticWaterFlow {
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();
        int[][] pac = new int[m][n];
        int[][] atl = new int[m][n];
        int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        Queue<int[]> pacQ = new LinkedList<>();
        Queue<int[]> atlQ = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0) pac[0][j] = 1;
                if(j == 0) pac[i][0] = 1;
                if(i == m - 1) atl[m - 1][j] = 1;
                if(j == n - 1) atl[i][n - 1] = 1;
                if(pac[i][j] == 1) pacQ.offer(new int[]{i, j});
                if(atl[i][j] == 1) atlQ.offer(new int[]{i, j});
            }
        }
        bfs(heights, pac, pacQ, dirs);
        bfs(heights, atl, atlQ, dirs);
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pac[i][j] == 1 && atl[i][j] == 1){
                    List<Integer> cur = new ArrayList<>();
                    cur.add(i);
                    cur.add(j);
                    res.add(cur);
                }
            }
        }
        return res;
    }

    private static void bfs(int[][] heights, int[][] ocean, Queue<int[]> q, int[][] dirs){
        int m = heights.length;
        int n = heights[0].length;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int[] d : dirs){
                int newX = cur[0] + d[0];
                int newY = cur[1] + d[1];
                if(newX < m && newX >= 0 && newY < n && newY >= 0 && ocean[newX][newY] != 1 && heights[newX][newY] >= heights[cur[0]][cur[1]]){
                    ocean[newX][newY] = 1;
                    q.offer(new int[] {newX, newY});
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] heights = new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        System.out.println(pacificAtlantic(heights)); //[[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
    }
}
// time O(N^2) space O(N^2)
