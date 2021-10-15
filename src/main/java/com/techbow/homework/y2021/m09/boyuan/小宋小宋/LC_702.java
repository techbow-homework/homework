package com.techbow.homework.y2021.m09.boyuan.小宋小宋;

public class LC_702 {
    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 16;
        while (reader.get(right) < target) {
            left = right;
            right = right * 2;
        }
        return binarySearch(reader, target, left, right);
    }

    private int binarySearch(ArrayReader reader, int target, int left, int right) {
        if (reader.get(left) == target) return left;
        if (reader.get(right) == target) return right;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (reader.get(mid) == target) return mid;
            else if (reader.get(mid) < target) left = mid;
            else right = mid;
        }
        if (reader.get(left) == target) return left;
        else if (reader.get(right) == target) return right;
        else return -1;
    }
}
