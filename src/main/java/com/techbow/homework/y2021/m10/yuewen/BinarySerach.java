package com.techbow.homework.y2021.m10.yuewen;

public class BinarySerach {
    //solution 1->right left （while loop执行完，第一次left>right）
    public int binaryserch(int[] nums, int target) {
//corner case
        if (nums == null || nums.length == 0) {
            return -1;
        }
//set variable
        int left = 0;
        int right = nums.length - 1;
        int middle = 0;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[middle] < target) {
                left = middle;
            }
            if (nums[middle] > target) {
                right = middle;
            }
        }
        return -1;
    }
}

