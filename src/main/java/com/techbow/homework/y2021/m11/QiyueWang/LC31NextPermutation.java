package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.Arrays;

public class LC31NextPermutation {
    // find the first decreasing element from last and swap it with the first element greater than or equal it. Then reverse the array from the first decreasing element.
    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n == 1) return;
        int i = n - 1;
        while(i > 0){
            if(nums[i] > nums[i - 1]){
                break;
            }
            i--;
        }
        if(i == 0){
            reverse(nums, 0, n - 1);
            return;
        }
        int compare = nums[i - 1];
        int j = n - 1;
        while(j >= i){
            if(nums[j] > compare){
                swap(nums, i - 1, j);
                break;
            }
            j--;
        }
        reverse(nums, i, n - 1);

    }
    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private static void reverse(int[] nums, int i, int j){
        while(i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,8,4,7,6,5,3,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));// 1,5,8,5,1,3,4,6,7
        int[] nums2 = new int[]{1,1,5};
        nextPermutation(nums2);
        System.out.println(Arrays.toString(nums2));// 1,5,1
    }
}
