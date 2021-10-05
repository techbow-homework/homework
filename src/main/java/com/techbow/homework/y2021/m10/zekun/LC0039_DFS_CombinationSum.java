package com.techbow.homework.y2021.m10.zekun;
import java.util.*;

public class LC0039_DFS_CombinationSum {
    public static void main(String[] args){
        LC0039_DFS_CombinationSum obj = new LC0039_DFS_CombinationSum();
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> sol = obj.combinationSum(candidates, target);
        System.out.println(sol);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        //cc
        if(target == 0 || candidates.length == 0) return res;

        List<Integer> nb = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(target, candidates, 0, 0, nb, res);
        return res;

    }

    private void dfs(int target, int[] candidates, int index, int sum, List<Integer> nb, List<List<Integer>> res){
        int canLen = candidates.length;
        //success case
        if(sum == target){
            List<Integer> copy = new ArrayList<>(nb);
            res.add(copy);
            return;
        }

        //fail case
        if(index >= canLen || sum > target){
            return;
        }

        //check visited: no need
        //recursion body
        for(int i = index; i < canLen; i++){
            nb.add(candidates[i]);
            sum = sum + candidates[i];
            dfs(target, candidates, i, sum, nb, res); // 因为能重复用，所以这里传下去的不是i + 1；
            nb.remove(nb.size() - 1);
            sum = sum - candidates[i];
        }

    }
}
