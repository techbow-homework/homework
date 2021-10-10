package com.techbow.homework.y2021.m09.mengyu;

public class LC_153 {
    public int findMin(int[] nums) {
        //TODO: corner cases
        int left = 0, right = nums.length - 1, mid = 0;
        int min = 0;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > nums[left] && nums[mid] > nums[right]) {
                left = mid;
            }
            if (nums[mid] < nums[left] && nums[mid] < nums[right]) {
                right = mid;
            }
            if (nums[mid] > nums[left] && nums[mid] < nums[right]) {
                return nums[left];
            }
        }
        if (nums[left] < nums[right]) {
            return nums[left];
        } else {
            return nums[right];

        }
    }
}
