package com.techbow.homework.y2021.m10.yuewen;

public class searchInsert {
    public int serachInser(int [] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length -1;
        while(left +1 < right) {
            int mid = left + (right - left)/2;

            if (target== nums[mid]) {
                return mid;
            }
            else if (target < nums[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (nums[left] > target) {
            return left > 0 ? left -1 : 0;
        }
        else if (nums[left] == target) {
            return left;
        }
        else if (nums[left] < target && target <= nums[right]) {
            return right;
        } else {
            return right + 1;
        }
    }
}
