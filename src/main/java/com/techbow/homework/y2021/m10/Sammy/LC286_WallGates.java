package com.techbow.homework.y2021.m10.Sammy;

import java.util.LinkedList;
import java.util.Queue;

public class LC286_WallGates {
    public void wallsAndGates(int[][] rooms){
        if(rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0) return;
        int row = rooms.length;
        int col = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();

        loadAllGates(queue, rooms, row, col);
        fillEroomWdis(queue, rooms, row, col);
    }
    private static final int[][] DIRECTIONS = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    private void fillEroomWdis(Queue<int[]> queue , int[][] rooms, int row, int col){
        int minLen = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int[] cur = queue.poll();
                for(int[] dir: DIRECTIONS){
                    int nextx = cur[0] + dir[0];
                    int nexty = cur[1] + dir[1];
                    if(nextx < 0 || nextx >= row || nexty < 0 || nexty >= col || rooms[nextx][nexty] != Integer.MAX_VALUE) continue;
                    queue.offer(new int[]{nextx, nexty});
                    rooms[nextx][nexty] = minLen + 1;
                }
            }
            minLen++;
        }
    }
    private void loadAllGates(Queue<int[]> queue, int[][] rooms, int row, int col){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(rooms[i][j] == 0){
                    queue.offer(new int[]{i,j});
                }
            }
        }
    }
}
