package com.techbow.homework.y2021.m10.kuixiaosu;

public class BinarySearchSolution1 {
    public int binarySearch (int[] array, int target) {
        // corner case
        if (array == null || array.length == 0) return -1;
        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) return mid;
            if (array[mid] < target) left = mid + 1;
            if (array[mid] > target) right = mid - 1;
        }
        return -1;
    }
}
