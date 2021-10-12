package com.techbow.homework.y2021.m10.Sammy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC90_SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] numbs){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(numbs);
        dfs(res, numbs, 0, new ArrayList<>());
        return res;
    }
    private void dfs(List<List<Integer>> res, int[] numbs, int idx, List<Integer> curList){
        res.add(new ArrayList<>(curList));

        for(int i = idx; i < numbs.length; i++){
            if(i != idx && numbs[i] == numbs[i - 1]){
                continue;
            }
            curList.add(numbs[i]);
            dfs(res, numbs, i+1, curList);
            curList.remove(curList.size() - 1);
        }
    }
}
