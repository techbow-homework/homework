package com.techbow.homework.y2021.m10.yeboyr.Nov06;

class Solution {
    public int search(int[] nums, int target) {
        //conner case
        if (nums == null || nums.length == 0) return -1;

        int pivot = 0;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            pivot = left + (right - left) / 2; //io
            if (nums[pivot] == target) return pivot;
            if (nums[pivot] < target)
                left = pivot + 1;
            else
                right = pivot - 1;
        }
        return -1;
    }
}