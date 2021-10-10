package com.techbow.homework.y2021.m10.tianhang;

import java.util.ArrayList;
import java.util.List;

public class LC_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return result;

        int m = matrix[0].length;
        int n = matrix.length;

        spiralOrder(0, m, n, matrix, result);
        return result;
    }

    private void spiralOrder(int offset, int colSize, int rowSize, int[][] matrix, List<Integer> result){
        if(rowSize == 0 || colSize == 0){
            return;
        }

        if(rowSize == 1){
            for(int i = 0; i < colSize; i++){
                result.add(matrix[offset][offset + i]);
            }
            return;
        }

        if(colSize == 1){
            for(int i = 0; i < rowSize; i++){
                result.add(matrix[offset + i][offset]);
            }
            return;
        }

        for(int i = 0; i < colSize - 1; i++){
            result.add(matrix[offset][offset + i]);
        }

        for(int i = 0; i < rowSize - 1; i++){
            result.add(matrix[offset + i][offset + colSize - 1]);
        }

        for(int i = 0; i < colSize - 1; i++){
            result.add(matrix[offset + rowSize - 1][offset + colSize - 1 - i]);
        }

        for(int i = 0; i < rowSize - 1; i++){
            result.add(matrix[offset + rowSize - 1 - i][offset]);
        }

        spiralOrder(offset + 1, colSize - 2, rowSize -2, matrix, result);
    }
}
