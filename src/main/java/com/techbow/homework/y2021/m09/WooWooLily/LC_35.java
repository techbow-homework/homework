package com.techbow.homework.y2021.m09.WooWooLily;
//insert serach
public class LC_35 {
    // demo
    // 1 2 3 4 5
    // edge case 0 [ 1 2 3 5] or [1,2 3,4] 5
    // other cases: [ 1 2 2,1, 3,4,5]

    public int insertSearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;

        int left = 0, right = nums.length - 1;
        int mid = 0;
        // edge cases
        if (nums[left] >= target) return left;
        if (nums[right] < target) return right + 1;

        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) right =  mid;
            else left = mid;
        }

        //check left and right
        if (nums[left] <= target) return left;
        return right;
    }


}
