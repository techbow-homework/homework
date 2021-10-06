package com.techbow.homework.y2021.m09.mengyu;

public class LC_702BinarySearch {
    public int search(int[] nums, int target) {
        //trivial
        //TODO: corner cases
        int left = 0, right = nums.length - 1, mid = 0;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
