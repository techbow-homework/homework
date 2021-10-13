package com.techbow.homework.y2021.m10.zekun;

import java.util.*;

public class LC0417_BFS {

    public static void main(String[] args){
        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        LC0417_BFS sol = new LC0417_BFS();
        List<List<Integer>> res = sol.pacificAtlantic(heights);
        System.out.println(res);
    }



    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        //cc
        if(heights == null || heights.length == 0 || heights[0] == null || heights[0].length == 0) return new ArrayList<>();

        int nrow = heights.length;
        int ncol = heights[0].length;
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] pacificVisited = new boolean[nrow][ncol];
        boolean[][] atlanticVisited = new boolean[nrow][ncol];
        List<List<Integer>> result = new ArrayList<>();

        loadPacific(heights, queue, pacificVisited);
        //bfs
        bfs(heights, queue, result, pacificVisited, atlanticVisited);

        loadAtlantic(heights, queue, atlanticVisited);
        //bfs
        bfs(heights, queue, result, atlanticVisited, pacificVisited);

        return result;
    }

    private void bfs(int[][] matrix, Queue<Integer> que, List<List<Integer>> res, boolean[][] self, boolean[][] other){
        int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        int nrow = matrix.length, ncol = matrix[0].length;
        while(!que.isEmpty()){
            int size = que.size();

            for(int k = 0; k < size; k++){
                int cur = que.poll();
                int i = cur / ncol;
                int j = cur % ncol;

                if(other[i][j]) res.add(Arrays.asList(i,j));

                for(int dir[] : DIRECTIONS){
                    int ii = i + dir[0];
                    int jj = j + dir[1];

                    if(ii >= 0 && ii < nrow && jj >= 0 && jj < ncol && !self[ii][jj] && matrix[i][j] <= matrix[ii][jj]){
                        que.offer(ii * ncol + jj);
                        self[ii][jj] = true;
                    }
                }
            }
        }
    }


    private void loadPacific(int[][] matrix, Queue<Integer> que, boolean[][] visited){
        int nrow = matrix.length, ncol = matrix[0].length;

        for(int j = 0; j < ncol; j++){
            que.offer(0 * ncol+ j);
            visited[0][j] = true;
        }
        for(int i = 1; i< nrow; i++){
            que.offer(i* ncol + 0);
            visited[i][0] = true;
        }
    }

    private void loadAtlantic(int[][] matrix, Queue<Integer> que, boolean[][] visited){
        int nrow = matrix.length, ncol = matrix[0].length;
        for(int j = 0; j < ncol - 1; j++){
            que.offer((nrow - 1) * ncol + j);
            visited[nrow - 1][j] = true;
        }
        for(int i = 0; i < nrow; i++){
            que.offer(i * ncol + (ncol - 1));
            visited[i][ncol - 1] = true;
        }
    }
}
