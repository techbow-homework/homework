package com.techbow.homework.y2021.m10.Jacob;

public class LC_33 {
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) return -1;
            int left = 0;
            int right = nums.length -1;
            while(left <= right) {
                int mid = left + (right -left) /2;
                if(nums[mid] == target) {
                    return mid;
                } else if(nums[mid] < nums[left]){
                    if(target > nums[mid] && target <= nums[right]) {
                        left = mid +1;
                    } else {
                        right = mid -1;
                    }
                } else {
                    if(target < nums[mid] && target >= nums[left]) {
                        right = mid -1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
            return -1;
        }
    }

