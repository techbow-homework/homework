package com.techbow.homework.y2021.m10.yuewen;

public class BinarySearchTwo {
    public int binarySearch(int[] nums, int target) {
// Corner case
        if (nums == null || nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid;
            else if (nums[mid] > target) right = mid;
            else return mid;
        }
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        return -1;
    }
}
