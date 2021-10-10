package com.techbow.homework.y2021.m10.kuixiaosu;

public class LC_34 {
    public int[] searchRange(int[] nums, int target) {
        //corner case
        if (nums == null || nums.length == 0) return new int[] {-1, -1};
        int[] result = new int[] {-1, -1};

        //search for first position of target
        int left = 0;
        int right = nums.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) left = mid;
            else right = mid;
        }

        if (nums[left] == target) result[0] = left;
        else if (nums[right] == target) result[0] = right;

        //search for last position of target
        left = 0;
        right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (target < nums[mid]) right = mid ;
            else left = mid;
        }
        if (nums[right] == target) result[1] = right;
        else if (nums[left] == target) result[1] = left;
        return result;
    }
}
