package com.techbow.homework.y2021.m10.Sammy;

import java.util.LinkedList;
import java.util.Queue;

public class LC542_01Matrix {
    public int[][] updateMatrix(int[][] mat){
        if(mat == null || mat.length == 0 || mat[0] == null || mat[0].length == 0) return new int[][] {{-1,-1}};
        int row = mat.length;
        int col = mat[0].length;

        int[][] res = new int[row][col];
        Queue<int[]> queue = new LinkedList<>();
        loadAllZeroes(queue, row, col, mat);

        return findNearDis(queue, row, col, mat, res);

    }
    private void loadAllZeroes(Queue<int[]> queue, int row, int col, int[][] mat){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(mat[i][j] == 0){
                    queue.offer(new int[]{i,j});
                }
            }
        }
    }
    private static final int[][] DIRECTIONS = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    private int[][] findNearDis(Queue<int[]> queue, int row, int col, int[][] mat, int[][] res){
        int distance = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                for(int[] dir: DIRECTIONS){
                    int xx = x + dir[0];
                    int yy = y + dir[1];
                    if(xx < 0 || xx >= row || yy < 0 || yy >= col || mat[xx][yy] == 0 || res[xx][yy] != 0) continue;
                    queue.offer(new int[]{xx,yy});
                    res[xx][yy] = distance + 1;
                }
            }
            distance++;
        }
        return res;
    }
}
