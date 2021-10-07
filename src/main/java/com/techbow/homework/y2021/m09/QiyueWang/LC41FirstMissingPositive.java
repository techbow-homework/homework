package com.techbow.homework.y2021.m09.QiyueWang;

// if nums[i] in [1, n], put nums[i] at index nums[i] - 1;

public class LC41FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            while(nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]){ // nums[i] in its right pos
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for(int i = 0; i < n; i++){
            if(nums[i] != i + 1){
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,5,6,1,4};
        int[] nums2 = new int[]{3,4,-1,1};
        System.out.println(firstMissingPositive(nums)); // 3
        System.out.println(firstMissingPositive(nums2)); // 2
    }
}
// time O(N) space O(1)