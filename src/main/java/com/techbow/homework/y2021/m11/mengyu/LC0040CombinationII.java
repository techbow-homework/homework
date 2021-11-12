package com.techbow.homework.y2021.m11.mengyu;

import java.util.*;

public class LC0040CombinationII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return result;
        List<Integer> oneResult = new ArrayList<>();
        Arrays.sort(candidates);
        // [10,1,2,7,6,1,5]
        // 1 1 2 5 6 7 10
        findCombinationsDfs(candidates, target, result, oneResult, 0, 0);
        return result;
    }

    private void findCombinationsDfs(int[] candidates, int target, List<List<Integer>> result,
                                     List<Integer> oneResult, int sum, int index) {
        if (sum > target) return;
        if (sum == target) {
            result.add(new ArrayList<>(oneResult));
            return;
        } else {
            for (int i = index; i < candidates.length; i++) {
                if (i > index && candidates[i] == candidates[i - 1]) continue; //find dup
                sum += candidates[i];
                oneResult.add(candidates[i]);
                findCombinationsDfs(candidates, target, result, oneResult, sum, i + 1);
                sum -= oneResult.get(oneResult.size() - 1);
                oneResult.remove(oneResult.size() - 1);
            }
        }
    }
}
