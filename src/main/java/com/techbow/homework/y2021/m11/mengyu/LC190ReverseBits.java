package com.techbow.homework.y2021.m11.mengyu;

public class LC190ReverseBits {
    public int reverseBit (int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int temp = (n >> i) & 1;
            result |= temp << (31 - i);
        }
        return result;
    }
    public int swap (int n) {
        for (int i = 0; i < 32; i++) {
            int right = (n >> i) & 1;
            int left = (n >> 31 - i) & 1;
            if (right != left) {
                n = n ^ (1 << i);
                n = n ^ (1 << 31 - i);
            }
        }

    }
}
