package com.techbow.homework.y2021.m09.boyuan.小宋小宋;


import java.util.ArrayList;

public class LC_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, res, target, new ArrayList<Integer>(), 0);
        return res;
    }
    private void backtrack(int[] nums, List<List<Integer>> res, int target, List<Integer> temp, int start) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(nums, res, target - nums[i], temp, i);
            temp.remove(temp.size() - 1);
        }
    }
}
