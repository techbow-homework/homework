package com.techbow.homework.y2021.m09.boyuan.小宋小宋;

public class LC_81 {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[left] == target || nums[right] == target || nums[mid] == target) return true;

            if (nums[left] == nums[mid]) left++;
            else if (nums[right] == nums[mid]) right --;

            else if (nums[left] < nums[mid]) {
                if (target < nums[mid] && target > nums[left]) right = mid - 1;
                else left = mid + 1;
            } else {
                if (target > nums[mid] && target < nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return false;
    }
}
