package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.ArrayList;
import java.util.List;

public class LC2089FindTargetIndicesAfterSortingArray {
    public static List<Integer> targetIndices(int[] nums, int target) {
        int n = nums.length;
        int countLess = 0;
        int count = 0;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(nums[i] < target){
                countLess++;
            }else if(nums[i] == target){
                count ++;
            }
        }
        for(int j = 0; j < count; j++){
            res.add(countLess + j);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,5,2,3};
        System.out.println(targetIndices(nums, 2));//[1,2]
    }
}
