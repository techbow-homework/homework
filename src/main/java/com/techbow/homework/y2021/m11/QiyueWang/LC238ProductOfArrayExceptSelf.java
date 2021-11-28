package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.Arrays;

public class LC238ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int suffix = 1;
        res[0] = 1;
        for(int i = 1; i < n; i++){
            res[i] = res[i - 1] * nums[i - 1]; // answer without suffix
        }
        for(int i = n - 2; i >= 0; i--){
            suffix = suffix * nums[i + 1];// ans without prefix
            res[i] *= suffix;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums))); //[24, 12, 8, 6]
    }
}
// time O(n) space O(1)
