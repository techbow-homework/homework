package com.techbow.homework.y2021.m10.kuixiaosu;

public class LC_276 {
    public int firstBadVersion(int n) {
        //corner case
        if (n <= 0) return -1;
        int left = 1;
        int right = n;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) right = mid;
            else left = mid;
        }
        if (isBadVersion(left)) return left;
        else if (isBadVersion(right)) return right;
        else return -1;
    }
}
