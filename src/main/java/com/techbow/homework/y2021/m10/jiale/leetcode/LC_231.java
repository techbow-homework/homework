package com.techbow.homework.y2021.m10.jiale.leetcode;

/**
 * Power of two
 * Given an Integer, write a function to determine if it is a power of two;
 */
public class LC_231 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        int count = 0;
        for (int i = 0; i < 31; i++) {
            count += (n >> i) & 1;
        }
        return count == 1;
    }
}
