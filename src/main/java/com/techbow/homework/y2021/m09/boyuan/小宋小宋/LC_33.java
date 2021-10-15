package com.techbow.homework.y2021.m09.boyuan.小宋小宋;

public class LC_33 {
    class Solution {
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) return -1;
            int left = 0;
            int right = nums.length - 1;

            //find the smallest\
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > nums[right]) {
                    left = mid + 1;
                } else right = mid;
            }
            int start = left;
            left = 0;
            right = nums.length - 1;

            if (nums[start] <= target && nums[right] >= target) {
                left = start;
            } else right = start;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) return mid;
                if (nums[mid] > target) right = mid - 1;
                else left = mid + 1;
            }
            return -1;
        }
    }
}
