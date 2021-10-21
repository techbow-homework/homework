package com.techbow.homework.y2021.m09.QiyueWang;

public class LC55JumpGame {
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int maxRange = 0;
        for(int i = 0; i < n; i++){
            int maxStep = nums[i];
            if(i + maxStep >= n - 1) return true;
            maxRange = Math.max(maxRange, maxStep + i);
            if(maxRange <= i) break;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        int[] nums2 = new int[]{3,2,1,0,1,4};
        System.out.println(canJump(nums)); // true
        System.out.println(canJump(nums2)); //false
    }
}
// time O(N) space O(1)
