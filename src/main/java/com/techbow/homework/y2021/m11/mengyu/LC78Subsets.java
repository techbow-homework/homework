package com.techbow.homework.y2021.m11.mengyu;

import java.util.ArrayList;
import java.util.List;

public class LC78Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        List<Integer> path = new ArrayList<>();
        dfs(nums, res, path, 0);
        return res;
    }
    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> path, int level) {
        res.add(new ArrayList<Integer>(path));
        if (level == nums.length) return;

        for (int i = level; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, res, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
