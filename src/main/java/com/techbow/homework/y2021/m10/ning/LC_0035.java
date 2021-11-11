package com.techbow.homework.y2021.m10.ning;

public class LC_0035 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // cc
        if (target < nums[left]) return 0;
        if (nums[right] < target) return right + 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) right = mid;
            else left = mid;
        }

        return nums[left] == target ? left : right;
    }
}
