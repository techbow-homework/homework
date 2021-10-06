package com.techbow.homework.y2021.m10.boyuan.melodysong1988.LC_417;
import com.techbow.homework.y2021.m10.boyuan.melodysong1988.LC_317;

import java.util.*;
public class PacificaAtlanticWaterFlow {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0] == null || heights[0].length == 0) {
            return res;
        }
        int row = heights.length;
        int col = heights[0].length;

        Queue<Integer> queue = new LinkedList<>();
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        loadPacific(heights, queue, pacific);
        bfs(heights, queue, pacific, atlantic, res);
        loadAtlantic(heights, queue, atlantic);
        bfs(heights, queue, atlantic, pacific, res);
        return res;
    }

    private void loadPacific(int[][] matrix, Queue<Integer> queue, boolean[][] pacific) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            queue.add(i * col + 0);
            pacific[i][0] = true;
        }
        for (int j = 1; j < col; j++) {
            queue.offer(j);
            pacific[0][j] = true;
        }
    }

    private void loadAtlantic(int[][] matrix, Queue<Integer> queue, boolean[][] atlantic) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            queue.add(i * col + (col - 1));
            atlantic[i][col - 1] = true;
        }
        for (int j = 0; j < col - 1; j++) {
            queue.add((row - 1) * col + j);
            atlantic[row - 1][j] = true;
        }
    }

    private void bfs(int[][] matrix, Queue<Integer> queue, boolean[][] self, boolean[][] other, List<List<Integer>> res) {
        int row = matrix.length;;
        int col = matrix[0].length;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int i = cur / col;
            int j = cur % col;
            if (other[i][j]) {
                res.add(Arrays.asList(i, j));
            }
            for (int[] dir : DIRECTIONS) {
                int ii = i + dir[0];
                int jj = j + dir[1];
                if (ii >= 0 && ii < row && jj >= 0 && jj < col && !self[ii][jj] && matrix[i][j] <= matrix[ii][jj]) {
                    queue.offer(ii * col + jj);
                    self[ii][jj] = true;
                }
            }
        }
    }

    public static void main (String[] args) {
        PacificaAtlanticWaterFlow SO = new PacificaAtlanticWaterFlow();

        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        List<List<Integer>> res = SO.pacificAtlantic(heights);

        System.out.println(res);
    }
}
