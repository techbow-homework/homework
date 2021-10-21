package com.techbow.homework.y2021.m10.Sammy;

import java.util.ArrayList;
import java.util.List;

public class LC78_Subsets {
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, 0, new ArrayList<>());
        return res;
    }
    private void dfs(List<List<Integer>> res, int[] nums, int idx, List<Integer> curList ){
        //successful base case
        if(idx == nums.length){
            res.add(new ArrayList<>(curList));
            return;
        }
        //add
        curList.add(nums[idx]);
        dfs(res, nums, idx + 1, curList);
        curList.remove(curList.size() - 1);

        //not add
        dfs(res, nums, idx + 1, curList);
    }
}
