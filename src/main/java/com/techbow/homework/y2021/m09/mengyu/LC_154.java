package com.techbow.homework.y2021.m09.mengyu;

public class LC_154 {
    public int findMin(int[] nums) {
        //TODO: corner cases
        int left = 0, right = nums.length - 1, mid = 0;

        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == nums[left] && nums[mid] == nums[right]) {
                left++;
                right--;
            } else if (nums[mid] >= nums[left] && nums[mid] > nums[right]) {
                left = mid;
            } else if (nums[mid] <= nums[left] && nums[mid] <= nums[right]) {
                right = mid;
            } else if (nums[mid] >= nums[left] && nums[mid] <= nums[right]) {
                return nums[left];
            }
        }
        if (nums[left] < nums[right]) {
            return nums[left];
        } else {
            return nums[right];

        }
    }
    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Minimum in Rotated Sorted Array II.
Memory Usage: 38.7 MB, less than 74.23% of Java online submissions for Find Minimum in Rotated Sorted Array II.
     */
}
