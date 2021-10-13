package com.techbow.homework.y2021.m10.Sammy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC40_CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //CC
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        boolean[] visited = new boolean[candidates.length];
        dfs(res, candidates, target, 0, new ArrayList<>(), 0, visited);
        return res;
    }
    private void dfs(List<List<Integer>> res, int[] candidates, int target, int curSum, List<Integer> curList, int idx, boolean[] visited){
        //successful base case
        if(curSum == target){
            res.add(new ArrayList<>(curList));
            return;
        }
        //failure base case
        if(curSum > target) return;

        for(int i = idx; i < candidates.length; i++){
            if(visited[i]) continue;
            if(i > 0 && candidates[i] == candidates[i-1] && !visited[i-1]) continue;
            curSum += candidates[i];
            curList.add(candidates[i]);
            visited[i] = true;
            dfs(res, candidates, target, curSum, curList, i, visited);
            curList.remove(curList.size() - 1);
            visited[i] = false;
            curSum -= candidates[i];
        }
    }
}
