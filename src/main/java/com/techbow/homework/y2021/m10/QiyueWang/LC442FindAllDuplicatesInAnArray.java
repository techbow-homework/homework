package com.techbow.homework.y2021.m10.QiyueWang;

import java.util.ArrayList;
import java.util.List;

public class LC442FindAllDuplicatesInAnArray {
    public static List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0){ // if negative, previously done, duplicated
                res.add(Math.abs(nums[i]));
            }
            nums[index] = -Math.abs(nums[index]); // mark as negative
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(nums).toString()); // [2,3]
        Double t1 = null;
        System.out.println(t1 == null);
    }
}
