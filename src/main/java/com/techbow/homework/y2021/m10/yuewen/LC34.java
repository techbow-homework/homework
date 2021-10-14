package com.techbow.homework.y2021.m10.yuewen;

public class LC34 { public int[] searchRange(int[] nums, int target) {
    //corner case
    if (nums == null || nums.length == 0) {
        return new int [] {-1, -1};
    }
    //fianl return
    final int [] result = new int[2];

    result[0] = findLeft(nums, target);
    result[1] = findRight(nums, target);

    return result;

}

    private int findLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        int middle = 0;

        while(left + 1 < right) {
            int mid = left + (right - left) /2;
            if(nums[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }

        //post
        if(nums[left] == target) {
            return left;
        }
        if(nums[right] == target) {
            return right;
        }

        return -1;

    }

    private int findRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        int middle = 0;

        while(left + 1 < right) {
            int mid = left + (right - left) /2;
            if(nums[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        //post
        if(nums[right] == target) {
            return right;
        }
        if(nums[left] == target) {
            return left;
        }

        return -1;

    }
}
