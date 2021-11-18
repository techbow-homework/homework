package com.techbow.homework.y2021.m11.mengyu;

public class LC29 {
    public int divide(int dividend, int divisor) {
        // 10 2

        int negative = 2;
        if (dividend < 0) {
            dividend = -dividend;
            negative--;
        }
        if (divisor < 0) {
            divisor = -divisor;
            negative--;
        }
        if (divisor == 1) {
            return dividend;
        } else if (divisor == -1) {
            return -dividend;
        }
        int res = 0;
        while (dividend - divisor >= 0) {
            res++;
            dividend -= divisor;
        }
        if (negative == 1) {
            return -res;
        } else {
            return res;
        }
    }
}
