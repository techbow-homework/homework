package com.techbow.homework.y2021.m10.mengyu;

public class LC50_pow {
    public double myPow(double x, int n) {
        /*
        //brutal force
        if (x == 1.0) return 1;
        long N = n;
        if (N < 0) {
            x = 1/x;
            N = -N;
        }
        double ans = 1;
        for (int i = 0; i < N; i++) {
            ans = ans * x;
        }
        return ans;
        */

        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }

    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double halfX = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return halfX * halfX;
        } else {
            return halfX * halfX * x;
        }
    }
}
