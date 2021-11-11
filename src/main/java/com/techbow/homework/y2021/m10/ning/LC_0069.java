package com.techbow.homework.y2021.m10.ning;

public class LC_0069 {
    public int mySqrt(int x) {
        if (x < 4) return x == 0 ? 0 : 1;

        int left = 2;
        int right = x/2;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (mid == x / mid) return mid;
            else if (mid > x / mid) right = mid;
            else left = mid;
        }

        return right < x / right ? right : left;
    }
}
