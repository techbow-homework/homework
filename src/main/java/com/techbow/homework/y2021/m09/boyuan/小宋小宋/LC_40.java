package com.techbow.homework.y2021.m09.boyuan.小宋小宋;

public class LC_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return result;
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, result, new LinkedList<>());
        return result;
    }
    private void backtrack(int[] candidates, int target, int start, List<List<Integer>> result, LinkedList<Integer> sum) {
        if (target < 0) return;
        if (target == 0) {
            result.add(new ArrayList<>(sum));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            sum.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, result, sum);
            sum.remove(sum.size() - 1);
        }
    }
}
