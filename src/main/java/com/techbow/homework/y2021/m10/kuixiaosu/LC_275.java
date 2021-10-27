package com.techbow.homework.y2021.m10.kuixiaosu;

public class LC_275 {
    public int hIndex(int[] citations) {
        // corner case
        if (citations == null || citations.length == 0) return -1;

        int left = 0;
        int right = citations.length - 1;
        int len = citations.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] == len - mid) return len - mid;
            else if (citations[mid] < len - mid) left = mid + 1;
            else right = mid - 1;
        }
        return len - left; // {3}这样的情况
    }
}
