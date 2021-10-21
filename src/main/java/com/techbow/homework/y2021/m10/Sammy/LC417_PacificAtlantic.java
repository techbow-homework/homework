package com.techbow.homework.y2021.m10.Sammy;

import java.util.*;

public class LC417_PacificAtlantic {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if(heights == null || heights.length == 0 || heights[0] == null || heights[0].length == 0) return res;
        int row = heights.length;
        int col = heights[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<>();
        loadAllPacific(row, col, pacific, queue);
        //bfs
        findAlldistance(heights, row, col, pacific, atlantic, res, queue);

        loadAllAtlantic(row, col, atlantic, queue);
        //bfs
        findAlldistance(heights, row, col, atlantic,pacific, res, queue);
        return res;
    }
    private void loadAllPacific(int row, int col, boolean[][] pacific, Queue<int[]> queue){
        for(int i = 0; i < row; i++){
            queue.offer(new int[]{i,0});
            pacific[i][0] = true;
        }
        for(int j = 0; j < col; j++){
            queue.offer(new int[]{0,j});
            pacific[0][j] = true;
        }
    }
    private void loadAllAtlantic(int row, int col, boolean[][] atlantic, Queue<int[]> queue){
        for(int j = 0; j < col - 1; j++){
            queue.offer(new int[]{row - 1, j});
            atlantic[row - 1][j] = true;
        }
        for(int i = 0; i < row; i++){
            queue.offer(new int[]{i, col - 1});
            atlantic[i][col-1] = true;
        }
    }
    private static final int[][] DIRECTIONS = {{1,0}, {0,1},{0,-1}, {-1,0}};
    private void findAlldistance(int[][] heights, int row, int col, boolean[][] selfMatrix, boolean[][] otherMatrix, List<List<Integer>> res, Queue<int[]> queue){
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                if(otherMatrix[x][y]){
                    res.add(Arrays.asList(x,y));
                }
                for(int[] dir: DIRECTIONS){
                    int ii = x + dir[0];
                    int jj = y + dir[1];
                    if(ii < 0 || ii >= row || jj < 0 || jj >= col || selfMatrix[ii][jj] || heights[x][y] > heights[ii][jj]) continue;
                    queue.offer(new int[]{ii,jj});
                    selfMatrix[ii][jj] = true;
                }
            }
        }

    }
}
