package com.techbow.homework.y2021.m10.Sammy;

import java.util.ArrayList;
import java.util.List;

public class LC46_Permutations {
    public List<List<Integer>> permute(int[] nus){
        List<List<Integer>> res = new ArrayList<>();
        dfs(nus, 0, res);
        return res;
    }
    private void dfs(int[] nums, int idx, List<List<Integer>> res) {
        //successful base case
        if(idx == nums.length - 1){
            List<Integer> temp = new ArrayList<>();
            for(int i: nums){
                temp.add(i);
            }
            res.add(temp);
            return;
        }
        for(int i =  idx; i < nums.length; i++){
            swap(nums, i, idx);
            dfs(nums, idx + 1, res);
            swap(nums, i, idx);
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
