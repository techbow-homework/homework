package com.techbow.homework.y2021.m10.Sammy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC47_PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums){
        //cc
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, res, new ArrayList<>(), visited);
        return res;
    }
    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> curList, boolean[] visited){
        if(curList.size() == nums.length){
            res.add(new ArrayList<>(curList));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i]) continue;
            if(i > 0 && nums[i] == nums[i - 1] && !visited[i-1]) continue;

            curList.add(nums[i]);
            visited[i] = true;
            dfs(nums, res, curList, visited);
            curList.remove(curList.size() - 1);
            visited[i] = false;
        }
    }
}
