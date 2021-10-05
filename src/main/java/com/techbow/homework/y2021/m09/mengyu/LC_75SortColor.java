package com.techbow.homework.y2021.m09.mengyu;

public class LC_75SortColor {
    public void sortColors(int[] nums) {
        //TODO: corner case;
        /*[0,0,0,1,1,2]
                   i
                     j
                   m
        */
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] <= nums[minIndex]) {
                    minIndex = j;
                }
            }
            if (nums[minIndex] == nums[i] && minIndex != i) {
                swap(i + 1, minIndex, nums);
            } else if (nums[minIndex] < nums[i]) {
                swap(i, minIndex, nums);
            }
        }
    }
    private void swap (int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
