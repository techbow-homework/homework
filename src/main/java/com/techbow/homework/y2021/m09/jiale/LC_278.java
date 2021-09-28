package com.techbow.homework.y2021.m09.jiale;

public class LC_278 {
    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    private boolean isBadVersion(int input) {
        return false;
    }
}
