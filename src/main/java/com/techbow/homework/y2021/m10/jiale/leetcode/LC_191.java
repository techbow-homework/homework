package com.techbow.homework.y2021.m10.jiale.leetcode;

public class LC_191 {
    public int hammingWeight(int n) {
        if (n == 0) return 0;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (n == 0) break;
            if (((n >> i) & 1) != 0) {
                count++;
            }
        }
        return count;
    }
}
