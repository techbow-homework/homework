package com.techbow.homework.y2021.m10.QiyueWang;

import java.util.LinkedList;
import java.util.Queue;

public class LC994RottingOranges {
    public static int orangesRotting(int[][] grid) {
        int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }
        int res = 0;

        while(!q.isEmpty()){
            int size = q.size();
            boolean changed = false;// whether new orange get rotted this round
            for(int i = 0; i < size; i++){
                int[] cur = q.poll();

                for(int[] d : dirs){
                    int x = cur[0] + d[0];
                    int y = cur[1] + d[1];
                    if(x < 0 || y < 0 || x >= m || y >= n || visited[x][y] || grid[x][y] == 0){
                        continue;
                    }
                    if(grid[x][y] == 1){
                        q.offer(new int[]{x,y});
                        grid[x][y] = 2;
                        visited[x][y] = true;
                        changed = true;
                        //System.out.println(x+" "+y);
                    }
                }
            }
            if(!changed) break;
            res++;
            changed = false;
            //System.out.println(Arrays.toString(q.peek()) + "  " + Arrays.deepToString(grid));
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        int[][] grid2 = new int[][]{{2,1,1},{0,1,1},{1,0,1}};
        System.out.println(orangesRotting(grid));// 4
        System.out.println(orangesRotting(grid2));// -1
    }
}
// time O(mn) space O(mn)
