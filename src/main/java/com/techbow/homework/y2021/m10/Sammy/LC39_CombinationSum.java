package com.techbow.homework.y2021.m10.Sammy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC39_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(res, candidates, target, 0, new ArrayList<>(), 0);
        return res;
    }
    private void dfs(List<List<Integer>> res, int[] candidates, int target, int curSum, List<Integer> curList, int idx){
        //successful base case
        if(curSum == target){
            res.add(new ArrayList<>(curList));
            return;
        }
        //failure base case
        if(curSum > target){
            return;
        }
        for(int i = idx; i < candidates.length ; i++){
            curSum = curSum + candidates[i];//curSum += candidates[i];
            curList.add(candidates[i]);
            dfs(res, candidates, target, curSum, curList, i);
            curList.remove(curList.size() - 1);
            curSum = curSum - candidates[i];//curSum -= candidates[i];
        }
    }
}
