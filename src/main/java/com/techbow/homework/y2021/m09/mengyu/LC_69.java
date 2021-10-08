package com.techbow.homework.y2021.m09.mengyu;

public class LC_69 {
    public int mySqrt(int x) {

        /*
        x = 110 return left
        x = 4
        left = 1;
        right = left * 2;
        1 2 3 4
        l
          m
              r
        if x > r*r
            l = r
            r *= 2
        */
        int left = 1;
        int right = 2;
        long rightSqr = right * right;

        if (x < 2) return x;
//        if (x == 2) return 1;

        while (rightSqr <= x) {
            //           left = right;
            right *= 2;
            rightSqr = (long) right * right;
        }

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            long midSqr = (long) mid * mid;
            if (midSqr == x) return mid;
            if (midSqr > x) {
                right = mid;
            } else if (midSqr < x) {
                left = mid;
            }
        }
        if (right * right == x) {
            return right;
        }
        return left;
    }
}
