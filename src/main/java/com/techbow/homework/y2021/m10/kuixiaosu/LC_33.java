package com.techbow.homework.y2021.m10.kuixiaosu;

public class LC_33 {
    public int search(int[] nums, int target) {
        // corner case
        if (nums == null || nums.length == 0) return -1;
        int left = 0 ;
        int right = nums.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[left]) left = mid;
            if (nums[mid] < nums[left]) right = mid;
        }

        int start = right;
        int end = nums.length - 1;

        if (target >= nums[start] && target <= nums[end]) {
            left = start;
            right = nums.length - 1;
        } else {
            right = left;
            left = 0;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(target == nums[mid]) return mid;
            else if(target > nums[mid]) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
