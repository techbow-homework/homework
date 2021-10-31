package com.techbow.homework.y2021.m10.zekun;

import java.util.LinkedList;
import java.util.Queue;

public class LC0540 {
    private static final int[][] DIRECTIONS = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int[][] updateMatrix(int[][] mat) {
        //cc
        if(mat == null || mat.length == 0 || mat[0] == null || mat[0].length == 0) throw new IllegalArgumentException();

        Queue<Integer> queue = new LinkedList<>();

        int nrow = mat.length, ncol = mat[0].length;
        int[][] result = new int[nrow][ncol];

        addAllZerosToQueue(mat, queue);
        int minLen = 1;

        while(!queue.isEmpty()){
            int qsize = queue.size();
            while(qsize-- > 0){
                int cur = queue.poll();
                int i = cur / ncol, j = cur % ncol;
                for(int[] dir:DIRECTIONS){
                    int ii = i + dir[0], jj = j + dir[1];
                    if(ii >= 0 && ii < nrow && jj >= 0 && jj < ncol && mat[ii][jj] != 0 && result[ii][jj] == 0){//判断ii jj位置的元素是否能放在queue里
                        queue.offer(ii * ncol + jj);
                        result[ii][jj] = minLen;
                    }
                }

            }
            minLen++;
        }

        return result;
    }

    private void addAllZerosToQueue(int[][] mat, Queue<Integer> queue){
        int nrow = mat.length, ncol = mat[0].length;
        for(int i = 0; i < nrow; i++){
            for(int j = 0; j < ncol; j++){
                if(mat[i][j] == 0){
                    queue.offer(i*ncol + j);
                }
            }
        }
    }
}
