package com.techbow.homework.y2021.m09.QiyueWang;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC407TrappingRainWaterII {
    public static int trapRainWater(int[][] heightMap) {
        int m =  heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> minHeap = new PriorityQueue<>(new Comparator<>(){ //always start with min height
            @Override
            public int compare(int[] a, int[] b){
                return a[2] - b[2];
            }
        });
        // initialize from outer stages
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0 || i == m - 1 || j == n - 1){
                    minHeap.offer(new int[] {i, j, heightMap[i][j]});
                    visited[i][j] = true;
                }
            }
        }
        int[][] dir = new int[][] {{1, 0}, {0,1}, {-1, 0}, {0, -1}};
        int res = 0;
        while(!minHeap.isEmpty()){
            int[] cur = minHeap.poll();

            for(int[] d : dir){
                int newX = cur[0] + d[0];
                int newY = cur[1] + d[1];

                if(newX < 0 || newX >= m || newY < 0 || newY >= n || visited[newX][newY]){
                    continue;
                }
                int newH = heightMap[newX][newY];
                if(cur[2] > newH){ // if newH lower than min height from outer stages, it can be filled
                    res += cur[2] - newH;
                }
                visited[newX][newY] = true;
                minHeap.offer(new int[]{newX, newY, Math.max(cur[2], newH)});// offer the height after filling or original higher height
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] hMap = {{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};
        int[][] hMap2 = {{3,3,3,3,3},{3,2,2,2,3},{3,2,1,2,3},{3,2,2,2,3},{3,3,3,3,3}};
        int[][] hMap3 = {{3,10,8,12,2,7,9},{7,1,11,3,8,1,10},{9,7,3,10,2,5,6},{7,11,1,4,6,11,9},{4,5,8,12,3,4,2},{12,2,12,1,5,9,6},{6,5,8,12,4,11,10}};
        System.out.println(trapRainWater(hMap)); //expect 4
        System.out.println(trapRainWater(hMap2)); //expect 10
        System.out.println(trapRainWater(hMap3)); //expect 39
    }
}
// time O(mn log(mn)) space O(mn)