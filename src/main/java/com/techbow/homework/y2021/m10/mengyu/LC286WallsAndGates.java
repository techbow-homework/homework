package com.techbow.homework.y2021.m10.mengyu;

import java.util.LinkedList;
import java.util.Queue;

public class LC286WallsAndGates {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void wallsAndGates(int[][] rooms) {
        //TODO: corner cases

        Queue<Integer> queue = new LinkedList<>();
        loadAllGates(rooms, queue);//load index which are gates into the queue
        int minDistance = 1;
        int row = rooms.length;
        int col = rooms[0].length;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int cur = queue.poll();
                int i = cur / col; //row index
                int j = cur % col; //col index

                for (int[] dir : DIRECTIONS) {
                    int ii = i + dir[0];
                    int jj = j + dir[1];
                    if (ii >= 0 && ii < row && jj >= 0 && jj < col && rooms[ii][jj] == Integer.MAX_VALUE) {
                        queue.offer(ii * col + jj);
                        rooms[ii][jj] = minDistance;
                    }
                }
            }
            minDistance++;
        }
    }

    private void loadAllGates(int[][] matrix, Queue<Integer> queue) {
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
