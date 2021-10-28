package com.techbow.homework.y2021.m10.qiangzhai;

public class LC216_CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        //cc
        if (k > n) return res;
        dfs(k, n, 0, 0, new ArrayList<Integer>(), res);
        return res;
    }
    private void dfs(int k, int n, int index, int sum, List<Integer> list, List<List<Integer>> res) {
        //base case
        if (list.size() == k) {
            if (sum == n) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        //
        for (int i = index; i < 9; i++) {
            if (i + 1 < n) {
                list.add(i + 1);
                dfs(k, n, i + 1, i + 1 + sum, list, res);
                list.remove(list.size() - 1);
            }
        }
    }
}
