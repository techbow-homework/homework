package com.techbow.homework.y2021.m09.QiyueWang;

import java.util.*;

public class LC1197MinKnightMoves { // modified from LC1197, have an enemy bishop, and limited board size n. The last step within bishop's attack is allowed.

    public static int minMoves(int n, int sRow, int sCol, int eRow, int eCol, int bishopRow, int bishopCol){
        int[][] moves = new int[][] {{1,2}, {2,1}, {2,-1}, {1,-2}, {-1,-2}, {-2,-1}, {-2,1}, {-1,2}};
        Queue<int[]> q = new LinkedList<>();
        Set<List<Integer>> visited = new HashSet<>();
        Set<List<Integer>> attacked = new HashSet<>();
        int count = 0;
        // add attack path
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == bishopRow && j ==bishopCol) continue; // skip bishop initial pos
                if(i + j == bishopRow + bishopCol || i - j == bishopRow - bishopCol){
                    attacked.add(new ArrayList<Integer>(Arrays.asList(i,j)));
                }
            }
        }
        q.offer(new int[] {sRow, sCol, 0}); // 0 for bishop not killed on current path
        visited.add(new ArrayList<Integer>(){
            {
                add(sRow);
                add(sCol);
            }
        });
        //System.out.println(attacked.toString());
        while (!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++) {
                List<Integer> cur = new ArrayList<>();
                int[] pos = q.poll();
                cur.add(pos[0]);
                cur.add(pos[1]);
                visited.add(cur);

                for (int[] step : moves) {
                    int nextX = pos[0] + step[0];
                    int nextY = pos[1] + step[1];
                    int bishopKilled = pos[2];
                    if(nextX == eRow && nextY == eCol){
                        return count + 1;
                    }
                    List<Integer> next = new ArrayList<>();
                    next.add(nextX);
                    next.add(nextY);
                    if (visited.contains(next) || nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) continue;
                    if (bishopKilled == 0) {
                        if (attacked.contains(next)) continue;
                        if (nextX == bishopRow && nextY == bishopCol) bishopKilled = 1;
                    }
                    q.offer(new int[]{nextX, nextY, bishopKilled});

                }
            }
            count++;
        }
        return -1;
    }

    public static void main(String[] args) {
        //int res = minMoves(6,0,0,0,2,0,1); // expect 2
        //int res2 = minMoves(6,5,1,0,5,2,3); // expect 3
        int res3 = minMoves(8,4,2,2,6,2,3); // expect 4
        int res4 = minMoves(8,4,2,2,6,3,4); // expect 2
        //System.out.println(res);
        //System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);

//        double d = 10.0/ -0;
//        if(d == Double.POSITIVE_INFINITY){
//            System.out.println("P");
//        }else{
//            System.out.println("N");
//        }
    }
}
