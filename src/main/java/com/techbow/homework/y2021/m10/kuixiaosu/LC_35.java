package com.techbow.homework.y2021.m10.kuixiaosu;

public class LC_35 {
    public int searchInsert(int[] nums, int target) {
        //corner case
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (target == nums[mid]) return mid;
            else if (target > nums[mid]) left = mid;
            else right = mid;
        }
        //post processing
        if (nums[left] >= target ) return left;
        else if (nums[right] < target) return right + 1;
        else return right;
    }
}
