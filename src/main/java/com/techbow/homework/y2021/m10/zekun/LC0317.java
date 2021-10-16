package LC;

import java.util.*;
public class LC0317 {
    private static final int[][] DIRECTIONS = {{1,0}, {-1,0}, {0,1},{0,-1}};

    public void main(String[] args){
        int[][] grid = {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};

    }

    public int shortestDistance(int[][] grid) {
        //cc
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) throw new IllegalArgumentException();
        int nrow = grid.length, ncol = grid[0].length;
        int cost[][] = new int[nrow][ncol];
        for(int i = 0; i < nrow; i++){
            for(int j = 0; j < ncol; j++){
                if(grid[i][j] == 1){
                    bfs(grid, i , j, cost);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nrow; i++){
            for(int j = 0; j < ncol; j++){
                if(grid[i][j] == 0){
                    min = Math.min(min, cost[i][j]);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void bfs(int[][] matrix, int x, int y, int[][] cost){
        Queue<Integer> queue = new LinkedList<>();
        int nrow = matrix.length, ncol = matrix[0].length;
        boolean[][] visited = new boolean[nrow][ncol];
        queue.offer(x * ncol + y);
        int minLen = 0;

        while(!queue.isEmpty()){
            int size  = queue.size();
            while(size-- > 0){
                int cur = queue.poll();
                int i = cur/ncol, j = cur % ncol;
                for(int[] dir:DIRECTIONS){
                    int ii = i + dir[0], jj = j + dir[1];
                    if(ii >=  0 && ii < nrow && jj >= 0 && jj < ncol && visited[ii][jj] && matrix[ii][jj] == 0){
                        queue.offer(ii*ncol + jj);
                        visited[ii][jj] = true;
                        cost[ii][jj] = minLen;
                    }
                }
                minLen++;
            }
        }

        for(int i = 0; i < nrow; i++){
            for(int j = 0; j < ncol; j++){
                if(matrix[i][j] == 0 && visited[i][j] == false){
                    matrix[i][j] = 2;
                }
            }
        }
    }
}
