package com.techbow.homework.y2021.m10.kuixiaosu;

public class MyPow {
    public long myPow(int x, int n) {
        if (n == 0) return 1;
        long half = myPow(x, n/2);
        return n % 2 == 0 ?  half * half : half * half * x;
    }
}
