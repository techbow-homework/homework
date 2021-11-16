package com.techbow.homework.y2021.m10.qiangzhai;

public class LC231_PowerOfTwo {
    //S1: recursion
    public boolean isPowerOfTwo(int n) {
        //cc
        if (n <= 0) return false;
        //base case
        if (n == 1) return true;
        //提前减枝条件
        if (n % 2 != 0) return false;
        return isPowerOfTwo(n/2);
    }
    //S2: recursion in while loop
    public boolean isPowerOfTwo(int n) {
        //cc
        if (n <= 0) return false;
        //
        while (n > 1) {
            //减枝条件
            if (n % 2 != 0) return false;
            n /= 2;
        }
        return n == 1;
    }

}
