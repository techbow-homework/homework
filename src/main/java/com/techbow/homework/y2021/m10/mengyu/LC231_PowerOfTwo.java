package com.techbow.homework.y2021.m10.mengyu;

public class LC231_PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        /*
        2 4 8 16 32
        */
        if (n == 0) return false;
        if (n == 1) return true;
        if (n % 2 != 0) return false;
        return isPowerOfTwo(n / 2);
    }
}
