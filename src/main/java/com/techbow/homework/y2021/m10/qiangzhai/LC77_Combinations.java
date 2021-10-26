package com.techbow.homework.y2021.m10.qiangzhai;

public class LC77_Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        //cc
        if (n <= 0 ||k > n) return res;
        //
        dfs(n, k, 1, new ArrayList<Integer>(), res);
        return res;
    }
    private void dfs(int n, int k, int index, List<Integer> sol, List<List<Integer>> res) {
        //base case
        if (sol.size() == k) {
            res.add(new ArrayList<Integer>(sol));
            return;
        }
        //
        for (int i = index; i <= n; i++) {
            sol.add(i);
            dfs(n, k, i + 1, sol, res);
            sol.remove(sol.size() - 1);
        }
    }
}
