package com.techbow.homework.y2021.m11.mengyu;

public class LC231PowerOfTwo {
    public boolean powerOfTwo (int n) {
        //corner case
        if (n <= 0) return false;
        //base case
        if (n == 1) return true;
        //
        if (n % 2 != 0 ) return false;

        return powerOfTwo(n / 2);
    }
    public boolean powerOfTwoWhileLoop (int n) {
        while (n> 1) {
            if (n % 2 != 0) return false;
            n /= 2;
        }
        return true;
    }
    public boolean powerOfTwoBinarySearch (int n) {
        int start = 1;
        while (start < n) {
            start *= 2;
        }
        return start == n;
    }
    public boolean powerOfTwoBit (int n) {
        return n > 0 && (n & (n-1)) == 0;
    }

    public static void main(String[] args) {
        int a = 1;
        LC231PowerOfTwo test = new LC231PowerOfTwo();
        System.out.println(test.powerOfTwoBinarySearch(a));
    }
}
