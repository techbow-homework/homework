package com.techbow.homework.y2021.m09.mengyu;

public class LC_283MoveZeros {
    public void moveZeroes(int[] nums) {
        /*
        0 1 0 3 12
        i
          j

        */
        int i = 0;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] == 0 && nums[j] != 0) {
                swap(i, j, nums);
                i++;
            } else if (nums[i] != 0) {
                i++;
            }
        }
    }

    private void swap(int firstIndex, int secondIndex, int[] arr) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}
