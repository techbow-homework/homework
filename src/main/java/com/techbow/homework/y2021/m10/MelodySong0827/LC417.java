package com.techbow.homework.y2021.m10.MelodySong0827;

import java.util.*;

public class LC417 {

        private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            List<List<Integer>> res = new ArrayList<>();
            if (heights == null || heights.length == 0 || heights[0] == null || heights[0].length == 0) {
                return res;
            }
            int row = heights.length;
            int col = heights[0].length;
            boolean[][] pacifica = new boolean[row][col];
            boolean[][] atlantic = new boolean[row][col];

            Queue<Integer> queue = new LinkedList<>();
            loadPacifica (heights, queue, pacifica);
            bfs(heights, queue, pacifica, atlantic, res);
            loadAtlantic (heights, queue, atlantic);
            bfs(heights, queue, atlantic, pacifica, res);
            return res;
        }

        private void loadPacifica(int[][] matrix, Queue<Integer> queue, boolean[][] pacifica) {
            int row = matrix.length;
            int col = matrix[0].length;
            for (int i = 0; i < row; i++) {
                queue.offer(i * col);
                pacifica[i][0] = true;
            }
            for (int j = 1; j < col; j++) {
                queue.offer(j);
                pacifica[0][j] = true;
            }
        }

        private void loadAtlantic(int[][] matrix, Queue<Integer> queue, boolean[][] atlantic) {
            int row = matrix.length;
            int col = matrix[0].length;
            for (int i = 0; i < row; i++) {
                queue.offer(i * col + (col - 1));
                atlantic[i][col - 1] = true;
            }
            for (int j = 0; j < col - 1; j++) {
                queue.offer((row - 1) * col + j);
                atlantic[row - 1][j] = true;
            }
        }

        private void bfs(int[][] matrix, Queue<Integer> queue, boolean[][] self, boolean[][] others, List<List<Integer>> res) {
            int row = matrix.length;
            int col = matrix[0].length;
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                int i = cur / col;
                int j = cur % col;
                if (others[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
                for (int[] dir : DIRECTIONS) {
                    int ii = i + dir[0];
                    int jj = j + dir[1];
                    if (ii >= 0 && ii < row && jj >= 0 && jj < col && matrix[ii][jj] >= matrix[i][j] && !self[ii][jj]) {
                        queue.offer(ii * col + jj);
                        self[ii][jj] = true;
                    }
                }
            }
        }
}
