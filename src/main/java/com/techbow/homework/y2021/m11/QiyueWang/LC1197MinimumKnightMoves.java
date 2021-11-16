package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.LinkedList;
import java.util.Queue;

public class LC1197MinimumKnightMoves {
    public static int minKnightMoves(int x, int y) {
        int a = Math.abs(x);
        int b = Math.abs(y);
        if(a == 0 && b == 0) return 0;
        int res = 1;
        boolean[][] visited = new boolean[a + 5][b + 5];
        int[][] dirs = new int[][]{{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1},{-2,1},{-1,2}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] cur = q.poll();
                for(int[] d : dirs){
                    int xx = cur[0] + d[0];
                    int yy = cur[1] + d[1];
                    if(xx < -2 || yy < -2 || xx >= a + 2 || yy >= b + 2 || visited[xx + 2][yy + 2]) continue;
                    visited[xx + 2][yy + 2] = true;
                    if(xx == a && yy == b){
                        return res;
                    }
                    q.offer(new int[]{xx,yy});
                }
            }
            res ++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minKnightMoves(2,1));//1
        System.out.println(minKnightMoves(5,5));//4
    }
}
