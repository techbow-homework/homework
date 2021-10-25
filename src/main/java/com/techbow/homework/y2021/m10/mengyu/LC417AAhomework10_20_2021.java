package com.techbow.homework.y2021.m10.mengyu;
import java.util.*;

public class LC417AAhomework10_20_2021 {

    private static final int[][] DIR = {{-1,0},{1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pacificVisited = new boolean[rows][cols];
        boolean[][] atlanticVisited = new boolean[rows][cols];

        Queue<Integer> pacificQueue = new LinkedList<>();
        Queue<Integer> atlanticQueue = new LinkedList<>();
        loadOcean(heights, pacificQueue, atlanticQueue);

        bfs(heights, pacificVisited, atlanticVisited, result, pacificQueue);
        bfs(heights, atlanticVisited, pacificVisited, result, atlanticQueue);

        return result;
    }
    private void bfs(int[][] heights, boolean[][] visited1, boolean[][] visited2, List<List<Integer>> result, Queue<Integer> queue) {
        int row = heights.length;
        int col = heights[0].length;
        for (int i : queue) {
            int iRow = i / col;
            int iCol = i % col;
            visited1[iRow][iCol] = true;
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int curRow = cur / col;
            int curCol = cur % col;
            if (visited2[curRow][curCol] == true) {
                result.add(Arrays.asList(curRow, curCol));
            }
            for (int[] dir : DIR) {
                int nextRow = curRow + dir[0];
                int nextCol = curCol + dir[1];
                if (nextRow >= 0 && nextRow < row &&
                        nextCol >= 0 && nextCol < col &&
                        heights[curRow][curCol] <= heights[nextRow][nextCol] &&
                        visited1[nextRow][nextCol] == false) {
                    queue.offer(nextRow * col + nextCol);
                    visited1[nextRow][nextCol] = true;
                }
            }
        }
    }
    private void loadOcean(int[][] heights, Queue<Integer> pacificQueue, Queue<Integer> atlanticQueue) {
        int rows = heights.length;
        int cols = heights[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0) {
                    pacificQueue.offer(i * cols + j);
                }
                if (j == 0) {
                    if (i != 0) {
                        pacificQueue.offer(i * cols + j);
                    }
                }
                if (i == rows - 1) {
                    atlanticQueue.offer(i * cols + j);
                }
                if (j == cols - 1) {
                    if (i != rows - 1) {
                        atlanticQueue.offer(i * cols + j);
                    }
                }
            }
        }
    }
}
