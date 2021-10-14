package com.techbow.homework.y2021.m09.boyuan.小宋小宋;

public class LC_154 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];
        int left = 0;
        int right = nums.length - 1;
        int mid;
        if (nums[left] < nums[right]) return nums[left];
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (nums[left] == nums[mid]) {
                left++;
            } else if (nums[right] == nums[mid]) {
                right--;
            } else if (nums[left] < nums[mid]) {
                left = mid;
            } else right = mid;
        }
        return nums[left] <= nums[right] ? nums[left] : nums[right];
    }
}
