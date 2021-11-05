package com.techbow.homework.y2021.m10.kuixiaosu;

public class LC_162 {
    public int findPeakElement(int[] nums) {
        //corner case
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) return mid;
            else if (nums[mid] < nums[mid-1]) right = mid;
            else left = mid;
        }
        if (nums[left] < nums[right]) return right;
        else return left;
    }
}
