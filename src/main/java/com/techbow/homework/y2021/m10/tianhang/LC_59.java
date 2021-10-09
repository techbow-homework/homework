package com.techbow.homework.y2021.m10.tianhang;

public class LC_59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        generateMatrix(0, n, n, matrix);
        return matrix;
    }

    private void generateMatrix(int offset, int n, int size, int[][] matrix){
        if(size == 0){
            return;
        }

        if(size == 1){
            matrix[offset][offset] = n * n;
            return;
        }

        matrix[0][0] = 1;
        if(offset > 0){
            matrix[offset][offset] = matrix[offset][offset - 1] + 1;
        }

        for(int i = 1; i < size; i++){
            matrix[offset][offset + i] = matrix[offset][offset + i - 1] + 1;
        }

        for(int i = 1; i < size; i++){
            matrix[offset + i][offset + size - 1] = matrix[offset + i - 1][offset + size - 1] + 1;
        }

        for(int i = 1; i < size; i++){
            matrix[offset + size - 1][offset + size - 1 - i] = matrix[offset + size - 1][offset + size - i] + 1;
        }

        for(int i = 1; i < size - 1; i++){
            matrix[offset + size - 1 - i][offset] = matrix[offset + size - i][offset] + 1;
        }

        generateMatrix(offset + 1, n, size - 2, matrix);
    }
}
