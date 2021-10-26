package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法加强.bfs;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given an m x n binary grid grid where each 1 marks the home of one friend, return the minimal total travel distance.
 * <p>
 * The total travel distance is the sum of the distances between the houses of the friends and the meeting point.
 * <p>
 * The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: grid = [[1,0,0,0,1],[0,0,0,0,0],[0,0,1,0,0]]
 * Output: 6
 * Explanation: Given three friends living at (0,0), (0,4), and (2,2).
 * The point (0,2) is an ideal meeting point, as the total travel distance of 2 + 2 + 2 = 6 is minimal.
 * So return 6.
 * Example 2:
 * <p>
 * Input: grid = [[1,1]]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * grid[i][j] is either 0 or 1.
 * There will be at least two friends in the grid.
 */
public class LC296BestMeetingPoint {
    // BFS 超时，需用数学解
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return -1;//throw exception
        }

        int col = grid[0].length, row = grid.length;
        int[][] cost = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    bfs(grid, i, j, cost);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                res = Math.min(cost[i][j], res);
            }
        }
        return res;
    }

    private static void bfs(int[][] grid, int i, int j, int[][] cost) {
        int col = grid[0].length, row = grid.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i * col + j);
        int minDis = 1;//check
        boolean[][] visited = new boolean[row][col];
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int cur = queue.poll();
                int r = cur / col;
                int c = cur % col;
                for (int[] dir : DIRECTIONS) {
                    int ii = r + dir[0];
                    int jj = c + dir[1];
                    if (ii >= 0 && ii < row && jj >= 0 && jj < col
                            && !visited[ii][jj]) {
                        cost[ii][jj] += minDis;
                        visited[ii][jj] = true;
                        queue.offer(ii * col + jj);
                    }
                }
            }
            minDis++;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}};
        minTotalDistance_math(grid);
    }



    // 不超时； rows和cols需要分别统计，因为rows和cols都要递增顺序
    public static int minTotalDistance_math(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return -1;//throw exception
        }

        List<Integer> rows = collectRows(grid);
        List<Integer> cols = collectCols(grid);
        int rowMedian = rows.get(rows.size() / 2);
        int colMedian = cols.get(cols.size() / 2);
        return getDis(rows, rowMedian) + getDis(cols, colMedian);

    }

    private static List<Integer> collectRows(int[][] grid) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res.add(i);
                }
            }
        }
        return res;
    }

    private static List<Integer> collectCols(int[][] grid) {
        List<Integer> res = new ArrayList<>();

        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] == 1) {
                    res.add(j);
                }
            }
        }
        return res;
    }

    private static int getDis(List<Integer> list, int median) {
        int res = 0;
        for (int ele : list) {
            res += Math.abs(ele - median);
        }
        return res;
    }

}
