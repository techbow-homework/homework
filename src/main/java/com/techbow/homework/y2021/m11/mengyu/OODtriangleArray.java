package com.techbow.homework.y2021.m11.mengyu;

public class OODtriangleArray {
    public int[][] createTriangle (int n) {
        /*
        n = 4
        0
        0 0
        0 0 0
        0 0 0 0
         */
        if (n <= 0) return null;
        int[][] res = new int[n][];
        for (int i = 0; i < n; i++) {
            res[i] = new int[i + 1];
        }
        return res;
    }
}
