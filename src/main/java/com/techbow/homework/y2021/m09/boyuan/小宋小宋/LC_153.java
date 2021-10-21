package com.techbow.homework.y2021.m09.boyuan.小宋小宋;

public class LC_153 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (nums[left] <= nums[right]) return nums[left];
            else {
                if (nums[mid] < nums[right]) right = mid;
                else left = mid;
            }
        }
        return nums[left] < nums[right] ? nums[left] : nums[right];
    }
}
