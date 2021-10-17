package com.techbow.homework.y2021.m10.kuixiaosu;

public class LC_81 {
    public boolean search(int[] nums, int target) {
        //corner case
        if (nums == null || nums.length == 0) return false;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;

            if (nums[mid] > nums[left]) {
                if (nums[mid] >= target && target >= nums[left]) right = mid - 1;
                else left = mid + 1;
            }

            else if (nums[mid] < nums[left]) {
                if (nums[mid] <= target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
            else left++;
        }
        return false;
    }
}
