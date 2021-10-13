package com.techbow.homework.y2021.m09.boyuan.小宋小宋;

public class LC_69 {
    public int mySqrt(int x) {
        if (x <= 1) return x;
        long left = 2;
        long right = x/2;
        long mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (mid * mid > x) right = mid - 1;
            else if (mid * mid < x) left = mid + 1;
            else return (int)mid;
        }
        return (int)right;
    }
}
