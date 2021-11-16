package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.Arrays;

// on a n * n chessboard, determine if coordinates in queries are attacked by queens.
public class AttackedByQueen {
    public static boolean[] attacked(int n, int[][] queens, int[][] queries){
        int m = queens.length;
        int qLen = queries.length;
        boolean[] res = new boolean[qLen];
        int[] horizontal = new int[n];
        int[] vertical = new int[n];
        int[] diag = new int[n + n];
        int[] backDiag = new int[n];

        for(int[] q : queens){
            horizontal[q[1]] = 1;
            vertical[q[0]] = 1;
            diag[q[0] + q[1]] = 1;
            backDiag[Math.abs(q[0] - q[1])] = 1;
        }

        for(int i = 0; i < qLen; i++){
            int x = queries[i][0];
            int y = queries[i][1];
            if(horizontal[y] == 1 || vertical[x] == 1 || diag[x + y] == 1 || backDiag[Math.abs(x - y)] == 1){
                res[i] = true;
            }else{
                res[i] = false;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] queens = new int[][]{{1,1}, {3,2}};
        int[][] queries = new int[][]{{1,1},{0,3},{0,4},{3,4},{2,0},{4,3},{4,0}};
        System.out.println(Arrays.toString(attacked(5, queens, queries))); // t f f t t t f
    }
}
