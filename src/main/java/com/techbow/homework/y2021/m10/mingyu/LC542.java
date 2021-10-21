package com.techbow.homework.y2021.m10.mingyu;

import java.util.LinkedList;
import java.util.Queue;

public class LC542 {
    public int[][] updateMatrix(int[][] matrix){
        //corner case
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return null;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int res[][] = new int[row][col];
        Queue<Integer> queue = new LinkedList<>();
        int dis = 1;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (matrix[i][j] == 0){
                    queue.offer(i * col + j);
                }
            }
        }
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0){
                int cur = queue.poll();
                int[][] directions = {{-1, 0}{1, 0}{0, -1}{0, 1}};
                for (int[] dir : directions){
                    int r = cur / col + dir[0];
                    int c = cur % col + dir[1];
                    if(r >= 0 && r < row && c >= 0 && c < col && matrix[r][c] == 1 && res[r][c] == 0){
                        res[r][c] = dis;
                        queue.offer(r * col + c);
                    }
                }
            }
            dis++;
        }
        return res;
    }
}
