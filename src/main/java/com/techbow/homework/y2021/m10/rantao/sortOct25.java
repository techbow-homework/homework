package com.techbow.homework.y2021.m10.rantao;

import java.util.Arrays;

public class sortOct25 {
    public static int[] sortBinary(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (nums[l] == 1) {
                l++;
            } else if (nums[r] == 0) {
                r--;
            } else {
                swap(nums, l, r);
            }
        }
        return nums;
    }

    public static void swap(int[] array, int l, int r) {
        int temp = array[l];
        array[l] = array[r];
        array[r] = temp;
    }


}

