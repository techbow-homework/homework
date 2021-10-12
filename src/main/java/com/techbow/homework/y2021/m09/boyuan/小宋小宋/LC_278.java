package com.techbow.homework.y2021.m09.boyuan.小宋小宋;

public class LC_278 {
    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        int mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (isBadVersion(mid) == false) left = mid;
            else if (isBadVersion(mid) == true) right = mid;
        }
        return isBadVersion(left) ? left : right;
    }
}
