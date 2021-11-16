package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法加强.bfs;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 *
 * The distance between two adjacent cells is 1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: [[0,0,0],[0,1,0],[0,0,0]]
 * Example 2:
 *
 *
 * Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
 * Output: [[0,0,0],[0,1,0],[1,2,1]]
 *
 *
 * Constraints:
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * mat[i][j] is either 0 or 1.
 * There is at least one 0 in mat.
 */
public class LC54201Matrix {

    private static final int[][] DIRECTIONS = {{-1,0},{1,0},{0,-1},{0,1}};
    public static int[][] updateMatrix(int[][] mat) {
        if( mat == null || mat.length == 0 || mat[0] == null || mat[0].length == 0){
            return mat;//throw exception
        }

        int rows = mat.length, cols = mat[0].length;
        int[][] dis = new int[rows][cols];
        Queue<Integer> queue = new LinkedList<>();
        loadZeros(queue,mat);
        int minDis = 1;

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                Integer cur = queue.poll();
                int i = cur / cols;
                int j = cur % cols;
                for(int[] dir:DIRECTIONS){
                    int ii = i + dir[0];
                    int jj = j + dir[1];

                    if(ii >=0 && ii < rows && jj >=0 && jj < cols
                        && dis[ii][jj] == 0 && mat[ii][jj] == 1){// 不是门的地方，且在dis里没有更新过； dis初始化后就是全是0
                        dis[ii][jj] = minDis;
                        queue.offer(ii * cols + jj);
                    }
                }
            }
            minDis++;
        }
        return dis;
    }

    private static void loadZeros(Queue<Integer> queue, int[][] mat) {
        int cols = mat[0].length;

        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < cols; j ++){
                if(mat[i][j] == 0){
                    queue.offer(i * cols + j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] mat = {{0,0,0,},{0,1,0},{0,0,0}};
        updateMatrix(mat);
    }
}
