package com.techbow.homework.y2021.m10.ning;

public class LC_0059 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return result;

        int rowStart = 0, colStart = 0;
        int rowEnd = matrix.length - 1, colEnd = matrix[0].length - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // traverse right
            for (int i = colStart; i <= colEnd; i++) {
                result.add(matrix[rowStart][i]);
            }
            rowStart++;

            // traverse down
            for (int i = rowStart; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            colEnd--;

            // traverse left
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    result.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }

            // traverse up
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    result.add(matrix[i][colStart]);
                }
                colStart++;
            }
        }
        return result;
    }
}
