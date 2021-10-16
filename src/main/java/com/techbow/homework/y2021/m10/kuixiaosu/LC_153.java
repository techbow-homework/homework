package com.techbow.homework.y2021.m10.kuixiaosu;

public class LC_153 {
    public int findMin(int[] nums) {
        // corner case
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] < nums[right]) return nums[left];
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[left] < nums[mid]) left = mid;
            else right = mid;
        }
        return nums[right];
    }
}
