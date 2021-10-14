package com.techbow.homework.y2021.m10.ryanxu.LC_417;

import java.util.*;

public class LC_417 {

    private int row;
    private int col;

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {

        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null) {
            return res;
        }
        this.row = matrix.length;
        if (this.row == 0) {
            return res;
        }
        this.col = matrix[0].length;

        Queue<Integer> pQueue = new LinkedList<>();
        Queue<Integer> aQueue = new LinkedList<>();
        boolean[][] self = new boolean[row][col];
        boolean[][] another = new boolean[row][col];

        pacific(self, pQueue);
        bfs(pQueue, self, another, res, matrix);
        atlantic(another, aQueue);
        bfs(aQueue, another, self, res, matrix);

        return res;
    }

    private void pacific(boolean[][] self, Queue<Integer> queue) {
        for (int i = 0; i < row; i++) {
            self[i][0] = true;
            queue.add(i * col);
        }
        for (int j = 1; j < col; j++) {
            self[0][j] = true;
            queue.add(j);
        }
    }

    private void atlantic(boolean[][] another, Queue<Integer> queue) {
        for (int i = 0; i < row; i++) {
            another[i][col - 1] = true;
            queue.add(i * col + col - 1);
        }
        for (int j = 0; j < col - 1; j++) {
            another[row - 1][j] = true;
            queue.add((row - 1) * col + j);
        }
    }

    private void bfs(Queue<Integer> queue, boolean[][] self, boolean[][] another, List<List<Integer>> res, int[][] matrix) {

        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int curX = cur / col;
            int curY = cur % col;
            if (another[curX][curY]) {
                res.add(new ArrayList<>(Arrays.asList(curX, curY)));
            }
            for (int d = 0; d < directions.length; d++) {
                int nextX = curX + directions[d][0];
                int nextY = curY + directions[d][1];
                if (inArea(nextX, nextY) && matrix[nextX][nextY] >= matrix[curX][curY] && !self[nextX][nextY]) {
                    self[nextX][nextY] = true;
                    queue.add(nextX * col + nextY);
                }
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }

    public static void main(String[] args) {
        LC_417 lc_417 = new LC_417();
        int[][] matrix = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        System.out.println(lc_417.pacificAtlantic(matrix));
    }
}
