package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法加强.bfs;


import java.util.*;

/**
 * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
 *
 * The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
 *
 * The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.
 *
 * Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
 * Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 * Example 2:
 *
 * Input: heights = [[2,1],[1,2]]
 * Output: [[0,0],[0,1],[1,0],[1,1]]
 *
 *
 * Constraints:
 *
 * m == heights.length
 * n == heights[r].length
 * 1 <= m, n <= 200
 * 0 <= heights[r][c] <= 105
 */

//从两个海的终点分别出发，两次m*n的bfs；每次bfs用一个查重的盘子，第二次bfs时候直接找两个盘子都是true的 就是结果
//load入海点的时候不要overlap corner points
// bfs dfs都能做
public class LC417PacificAtlanticWaterFlow {

    private static final int[][] DIRECTIONS = {{-1,0},{1,0},{0,-1},{0,1}};

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        //cc
        int row = heights.length, col = heights[0].length;
        Queue<Integer> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];

        //pacific
        loadPacificToQueue(heights,queue,pacific);
        findIslands(heights,pacific,atlantic,res,queue);
        loadAtlanticToQueue(heights,queue,atlantic);
        findIslands(heights,atlantic,pacific,res,queue);
        return res;
    }

    private static void loadPacificToQueue(int[][] heights, Queue<Integer> queue, boolean[][] pacificBoard) {
        int cols = heights[0].length,rows = heights.length;
        for(int i = 0 ; i < rows; i ++){
             queue.offer(i * cols + 0);
             pacificBoard[i][0] = true;
        }

        for(int j = 1; j < cols; j++){ //不要重复load左上角的island
            queue.offer(0 * cols + j);
            pacificBoard[0][j] = true;
        }
    }

    private static void loadAtlanticToQueue(int[][] heights, Queue<Integer> queue, boolean[][] atlanticBoard) {
        int cols = heights[0].length,rows = heights.length;
        for(int i = 0 ; i < rows; i ++){
            queue.offer(i * cols + cols-1);
            atlanticBoard[i][cols-1] = true;
        }

        for(int j = 0; j < cols-1; j++){ //不要重复load右下角的island
            queue.offer((rows-1) * cols + j);
            atlanticBoard[rows-1][j] = true;
        }
    }

    private static void findIslands(int[][] heights, boolean[][] thisBoard, boolean[][] thatBoard, List<List<Integer>> res, Queue<Integer> queue) {
        int cols = heights[0].length,rows = heights.length;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            int i = cur / cols;
            int j = cur % cols;
            if(thatBoard[i][j]){ // 加入res里，因为海岸线入queue时候是在别的方法里，所以不能在入queue时候做对比，不然那些就miss了；只能在从queue poll出来的时候做对比
                res.add(Arrays.asList(i,j));
            }
            for(int[] dir: DIRECTIONS){
                int ii = i + dir[0];
                int jj = j + dir[1];
                if(ii >= 0 && ii < rows && jj >= 0 && jj < cols
                    && heights[i][j] <= heights[ii][jj] && !thisBoard[ii][jj]
                ){
                    queue.offer(ii * cols + jj);
                    thisBoard[ii][jj] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        pacificAtlantic(grid);

    }
}
