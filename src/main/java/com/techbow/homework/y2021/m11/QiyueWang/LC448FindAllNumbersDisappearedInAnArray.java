package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.ArrayList;
import java.util.List;

public class LC448FindAllNumbersDisappearedInAnArray {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]){ // in case two num equal
                swap(nums, i, nums[i] - 1);
                i--; // check for swapped num
            }
        }
        //System.out.println(Arrays.toString(nums));
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1){
                res.add(i + 1);
            }
        }
        return res;
    }
    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));// 5,6
    }
}
// time O(n) space O(1)
