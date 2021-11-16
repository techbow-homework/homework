package com.techbow.homework.y2021.m11.mengyu;

import java.util.ArrayList;
import java.util.List;

public class LC39CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> oneResult = new ArrayList<>();
        findCombinations(candidates, target, 0, result, oneResult, 0);
        return result;
    }
    private void findCombinations (int[] candidates, int target, int sum, List<List<Integer>> result, List<Integer> oneResult, int index) {
        if (sum == target) {
            result.add(new ArrayList<>(oneResult));
            return;
        }
        if (sum < target) {
            for (int i = 0; i < candidates.length; i++) {
                oneResult.add(candidates[i]);
                findCombinations(candidates, target, sum += candidates[i], result, oneResult, i);
                oneResult.remove(oneResult.size() - 1);
                sum -= oneResult.get(oneResult.size() - 1);
            }
        }
    }
}
