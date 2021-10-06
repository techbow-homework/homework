package com.techbow.homework.y2021.m09.QiyueWang;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LC922SortArrayByParityII {
    public static int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int j = 1;
        for(int i = 0; i < n; i += 2){
            if(nums[i] % 2 != 0){
                while(j < n && nums[j] % 2 == 1){// if odd, skip
                    j += 2;
                }
                swap(nums, i, j);
            }
        }
        return nums;
    }
    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {4,2,5,7};
        System.out.println(Arrays.toString(sortArrayByParityII(nums)));
    }
}
