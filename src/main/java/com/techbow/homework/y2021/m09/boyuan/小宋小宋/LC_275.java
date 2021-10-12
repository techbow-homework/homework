package com.techbow.homework.y2021.m09.boyuan.小宋小宋;

public class LC_275 {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return -1;
        int left = 0;
        int right = citations.length - 1;
        int mid;
        if (citations.length == 1) return citations[0] == 0 ? 0 : 1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (citations[mid] == citations.length - mid) return citations[mid];
            else if (citations[mid] < citations.length - mid) left = mid + 1;
            else right = mid - 1;
        }
        return citations.length - left;
    }
}
