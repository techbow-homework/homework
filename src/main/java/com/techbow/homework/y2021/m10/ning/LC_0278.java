package com.techbow.homework.y2021.m10.ning;

public class LC_0278 {
    public int firstBadVersion(int n) {
        if (n == 1) return isBadVersion(n) ? 1 : 0;

        int left = 1;
        int right = n;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) right = mid;
            else left = mid;
        }

        return isBadVersion(left) ? left : right;
    }
}
