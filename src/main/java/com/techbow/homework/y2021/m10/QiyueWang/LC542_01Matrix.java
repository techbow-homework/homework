package com.techbow.homework.y2021.m10.QiyueWang;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC542_01Matrix {
    public static int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        //int[][] res = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    q.offer(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int[] cur = q.poll();
            visited[cur[0]][cur[1]] = true;
            for(int[] d : dirs){
                int newX = cur[0] + d[0];
                int newY = cur[1] + d[1];

                if(newX < 0 || newY < 0 || newX >= m || newY >= n || mat[newX][newY] == 0) continue;
                //System.out.println(newX+"  "+newY + " " + visited[newX][newY]);
                if(visited[newX][newY] && mat[cur[0]][cur[1]] + 1 < mat[newX][newY] || !visited[newX][newY] ){
                    //System.out.println(newX+"  "+newY);
                    mat[newX][newY] = mat[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
        //System.out.println(Arrays.deepToString(visited));
        return mat;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{0,1,0},{0,1,0}};
        int[][] mat2 = new int[][]{{0,0,0},{0,1,0},{1,1,1}};
        System.out.println(Arrays.deepToString(updateMatrix(mat)));//[[0,1,0],[0,1,0]]
        System.out.println(Arrays.deepToString(updateMatrix(mat2)));//[[0,0,0],[0,1,0],[1,1,1]]
    }
}
// time O(mn) space O(mn)