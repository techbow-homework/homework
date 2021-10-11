package com.techbow.homework.y2021.m09.yikegu;

import java.util.Arrays;

public class LC75 {
    public static void sortColor(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        int curr = 0;
        int zero = 0;
        int two = n - 1;
        while(curr < two) {
            if(nums[curr] == 0) {
                swap(nums, curr, zero);
                zero++;
                curr++;
            }else if (nums[curr] == 2) {
                swap(nums, curr, two);
                two--;
            }else{
                curr++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] arg) {
        int[] test = new int[]{2,0,2,1,1,0};
        sortColor(test);
        System.out.println(Arrays.toString(test));

    }
}
