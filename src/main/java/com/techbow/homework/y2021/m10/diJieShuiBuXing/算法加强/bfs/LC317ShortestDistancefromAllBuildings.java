package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法加强.bfs;


import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an m x n grid grid of values 0, 1, or 2, where:
 * <p>
 * each 0 marks an empty land that you can pass by freely,
 * each 1 marks a building that you cannot pass through, and
 * each 2 marks an obstacle that you cannot pass through.
 * You want to build a house on an empty land that reaches all buildings in the shortest total travel distance. You can only move up, down, left, and right.
 * <p>
 * Return the shortest travel distance for such a house. If it is not possible to build such a house according to the above rules, return -1.
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
 * Input: grid = [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
 * Output: 7
 * Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2).
 * The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal.
 * So return 7.
 * Example 2:
 * <p>
 * Input: grid = [[1,0]]
 * Output: 1
 * Example 3:
 * <p>
 * Input: grid = [[1]]
 * Output: -1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] is either 0, 1, or 2.
 * There will be at least one building in the grid.
 * Accepted
 * 110,125
 * Submissions
 * 251,856
 */


// 关键点是要判断这个grid上为0的空地是不是能到达所有的building。
//
//做法是每次bfs完后看一下哪些是grid 0的位置，却没有被visited，将他们设置为grid[i][j] = 2;
//
//在最后找res的时候 查找有效空地条件是grid[i][j] ==0；就将这些点排除了；

//因为是要计算从0到每个1的距离加和，所以要从1出发，到每个0去标记距离；对于多个1来说，就要在别的1走过的cost的基础上，加上+=minDis 这样 cost matrix的值，就是每个1走过这个0点的加和
//然后在cost上找对应grid上原本0的位置上，现在的cost是多少，找出最小值
// 为什么从1出发不从0出发？ 因为从0出发，虽然可以到1，但是还要反向回去标记0出发时候的位置，去给它的出发点赋值，很麻烦
// 在bfs里的input需要传入1所在的ij坐标
public class LC317ShortestDistancefromAllBuildings {

    private static int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return -1; // throw exception
        }

        int cols = grid[0].length, rows = grid.length;
        int[][] cost = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    findCost(grid, i, j, cost);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0 && cost[i][j] != 0) { // grid[i][j] == 0 就排除了那些已经被人为标记为2的有些不能到达的点，cost！=0 表示这个点不是building和障碍物
                    res = Math.min(res, cost[i][j]);
                }
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private static void findCost(int[][] grid, int i, int j, int[][] cost) {
        int cols = grid[0].length, rows = grid.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i * cols + j);
        int minDis = 1; // minDis的初始值决定于他是出queue时候赋值，还是covert后入queue时候赋值。如果是出queue时候赋值，则是0，convert之后入queue是1
        boolean[][] visited = new boolean[rows][cols];

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int cur = queue.poll();
                int r = cur / cols;
                int c = cur % cols;
                for (int[] dir : DIRECTIONS) {
                    int ii = r + dir[0];
                    int jj = c + dir[1];
                    if (ii >= 0 && ii < rows && jj >= 0 && jj < cols
                            && grid[ii][jj] == 0 && !visited[ii][jj]) {
                        cost[ii][jj] += minDis;  //cost 需要累加 +=
                        queue.offer(ii * cols + jj);
                        visited[ii][jj] = true;
                    }
                }
            }
            minDis++;
        }
//重点，将其实是空地，但是没有被visited到的地方 标记为2。这些地方是某个building无法到达的点
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0 && !visited[r][c]) {
                    grid[r][c] = 2;
                }
            }
        }
    }

}
