package com.techbow.homework.y2021.m10.ryanxu;

import java.util.LinkedList;
import java.util.Queue;

public class LC_542 {

    private int row;
    private int col;
    private int[][] directions = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int[][] updateMatrix(int[][] matrix) {

        if (matrix == null) {
            return matrix;
        }
        this.row = matrix.length;
        if (this.row == 0) {
            return matrix;
        }
        this.col = matrix[0].length;
        if (this.col == 0) {
            return matrix;
        }

        // get all start point
        Queue<Integer> queue = getAllZero(matrix);
        int[][] res = new int[this.row][this.col];
        int dis = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int cur = queue.poll();
                int curX = cur / this.col;
                int curY = cur % this.col;
                for (int d = 0; d < this.directions.length; d++) {
                    int nextX = curX + directions[d][0];
                    int nextY = curY + directions[d][1];
                    if (inArea(nextX, nextY) && matrix[nextX][nextY] != 0 && res[nextX][nextY] == 0) {
                        res[nextX][nextY] = dis;
                        queue.add(nextX * this.col + nextY);
                    }
                }
            }
            dis++;
        }

        return res;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < this.row && y >= 0 && y < this.col;
    }

    private Queue<Integer> getAllZero(int[][] matrix) {

        Queue<Integer> res = new LinkedList<>();
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                if (matrix[i][j] == 0) {
                    res.add(i * this.col + j);
                }
            }
        }

        return res;
    }
}
