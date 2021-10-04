package com.techbow.homework.y2021.m10.mengyu;

public class LC342_PowerOfFour {
    public boolean isPowerOfFour(int n) {
        if (n == 0) return false;
        if (n == 1) return true;
        if (n % 4 != 0) return false;
        return isPowerOfFour(n / 4);
    }
}
