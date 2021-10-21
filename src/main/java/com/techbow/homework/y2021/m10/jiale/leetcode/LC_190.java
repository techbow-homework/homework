package com.techbow.homework.y2021.m10.jiale.leetcode;

/**
 * reverse bit
 * idea: how to get the bit on certain position. right shift 1 and do the or/ and operation with the number.
 */
public class LC_190 {
    public int reverseBits(int n) {
        if (n == 0 || n == -1) {
            return n;
        }

        for (int i = 0; i < 16; i++) {
            if (((n >> i) & 1) != (n >> (31 - i) & 1)) {
                // use xor change the bit
                n ^= 1 << i;
                n ^= 1 << (31 - i);
            }
        }
        return n;
    }
}
