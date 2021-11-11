package com.techbow.homework.y2021.m10.kuixiaosu;

public class UnknownSizePosition {
    public int unknownSizePosition(MyArray myArray, int target) {//TODO: long
        // corner case

        int left = 0;
        int right = 1;

        while (myArray.get(right) != null && myArray.get(right) < target) {
            left = right;
            right *= 2;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (myArray.get(mid) != null && myArray.get(mid) == target) return mid;
            else if (myArray.get(mid) != null && myArray.get(mid) < target) {
                left = mid + 1;
            }
            else right = mid - 1;
        }
        return -1;
    }
}
