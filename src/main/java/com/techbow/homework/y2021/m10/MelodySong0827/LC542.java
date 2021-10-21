package com.techbow.homework.y2021.m10.MelodySong0827;

import java.util.LinkedList;
import java.util.Queue;

public class LC542 {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0] == null || mat[0].length == 0) {
            return mat;
        }

        int row = mat.length;
        int col = mat[0].length;
        int[][] dis = new int[row][col];
        int distance = 1;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(i * col + j);
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int cur = queue.poll();
                int i = cur / col;
                int j = cur % col;
                for (int[] dir : DIRECTIONS) {
                    int ii = i + dir[0];
                    int jj = j + dir[1];
                    if (ii >= 0 && ii < row && jj >= 0 && jj < col && mat[ii][jj] == 1 && dis[ii][jj] == 0) {
                        dis[ii][jj] = distance;
                        queue.offer(ii * col + jj);
                    }
                }
            }
            distance++;
        }
        return dis;
    }
}
