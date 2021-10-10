package com.techbow.homework.y2021.m10.Sammy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC90_SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(res, nums, 0, new ArrayList<>());
        return res;
    }
    private void dfs(List<List<Integer>> res, int[] nums, int idx, List<Integer> curList){
        res.add(new ArrayList<>(curList));

        for(int i = idx; i < nums.length; i++){
            if(i != idx && nums[i] == nums[i - 1]){
                continue;
            }
            curList.add(nums[i]);
            dfs(nums, res, i+1, curList);
            curList.remove(curList.size() - 1);
        }
    }
}
