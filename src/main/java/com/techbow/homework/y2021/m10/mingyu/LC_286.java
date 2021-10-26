package com.techbow.homework.y2021.m10.mingyu;

import java.util.LinkedList;

public class LC_286 {
    private static final int[][] DIRECTIONS = {{-1, 0},{1, 0},{0, -1},{0, 1}}; // up,down,left,right
    //corner case
    public static int[][] wallsAndGates(int[][] rooms){
        if (rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0){
            throw new IllegalArgumentException();
        }
        int row = rooms.length;
        int col = rooms[0].length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (rooms[i][j] == 0){
                    queue.add(i * col + j);
                }
            }
        }
        int minLen = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0){
                int cur = queue.poll();
                int i = cur / col;
                int j = cur % col;
                for (int[] dir : DIRECTIONS) {
                    int ii = i + dir[0];
                    int jj = j + dir[1];
                    if (ii >= 0 && ii < row && jj >= 0 && jj < col && rooms[ii][jj] == Integer.MAX_VALUE){
                        queue.offer(ii * col + jj);
                        rooms[ii][jj] = minLen;
                    }
                }
            }
            minLen++;
        }
        return rooms;
    }
}
