package com.techbow.homework.y2021.m10.kuixiaosu;

public class LC_154 {
    public int findMin(int[] nums) {
        //corner case
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] < nums[right]) return nums[left];
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == nums[left]) left++;
            else if (nums[mid] == nums[right]) right--;
            else if (nums[mid] < nums[left]) right = mid;
            else left = mid;
        }
        if (nums[left] <= nums[right]) return nums[left];
        else return nums[right];
    }
}
