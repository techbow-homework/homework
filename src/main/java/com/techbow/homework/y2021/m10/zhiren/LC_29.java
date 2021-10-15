package com.techbow.homework.y2021.m10.zhiren;

public class LC_29 {
    public int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        if (dividend == divisor) return 1;

        int negatives = 2;
        if (dividend > 0) {
            negatives--;
            dividend = -dividend;
        }
        if (divisor > 0) {
            negatives--;
            divisor = -divisor;
        }

        int quo = 0;
        while (dividend - divisor <= 0) {
            quo--;
            dividend -= divisor;
        }

        if (negatives != 1) {
            quo = -quo;
        }
        return quo;
    }

    public static void main(String args[]){
        LC_29 lc = new LC_29();
        //int dividend = 10, divisor = 3;

        System.out.println(lc.divide(10,3));
    }
}
