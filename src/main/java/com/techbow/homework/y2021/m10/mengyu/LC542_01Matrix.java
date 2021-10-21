package com.techbow.homework.y2021.m10.mengyu;

import java.util.LinkedList;
import java.util.Queue;

public class LC542_01Matrix {
    private static final int[][] DIRECTIONS = {{-1,0},{1,0}, {0,-1},{0,1}};
    public int[][] updateMatrix(int[][] mat) {
        int[][] result = new int[mat.length][mat[0].length];
        Queue<Integer> queue = new LinkedList<>();
        loadAllZeros(mat, queue);
        int col = mat[0].length;
        int row = mat.length;
        int minDistance = 1;

        while(!queue.isEmpty()) {
            int sizeOfCurrentLevel = queue.size();
            while (sizeOfCurrentLevel > 0) {
                int current = queue.poll();
                int i = current / col;
                int j = current % col;
                for (int[] dir : DIRECTIONS) {
                    int ii = i + dir[0];
                    int jj = j + dir[1];
                    if (ii >= 0 && ii < row &&
                        jj >= 0 && jj < col &&
                        result[ii][jj] == 0 && mat[ii][jj] == 1) {
                        queue.offer(ii * col + jj);
                        result[ii][jj] = minDistance;
                    }
                }
                sizeOfCurrentLevel--;
            }
            minDistance++;
        }
        return result;
    }
    private void loadAllZeros(int[][] matrix, Queue<Integer> queue) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(i * col + j);
                }
            }
        }
    }
}
