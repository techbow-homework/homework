package com.techbow.homework.y2021.m10.mengyu;

public class LC326_PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n == 0) return false;
        if (n == 1) return true;
        if (n % 3 != 0) return false;
        return isPowerOfThree(n / 3);
    }
}
