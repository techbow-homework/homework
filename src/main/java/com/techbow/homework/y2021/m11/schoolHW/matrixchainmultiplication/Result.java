package com.techbow.homework.y2021.m11.schoolHW.matrixchainmultiplication;

import lombok.Data;

@Data
public class Result {
    private int n;
    private int[][] m;
    private int[][] s;
    private int result;

    public Result(int n) {
        this.n = n;
        m = new int[n][n];
        s = new int[n][n];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                m[i][j] = Integer.MAX_VALUE;
            }
        }
    }
}
