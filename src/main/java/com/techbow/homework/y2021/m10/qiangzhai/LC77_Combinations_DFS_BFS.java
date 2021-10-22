package com.techbow.homework.y2021.m10.qiangzhai;

public class LC77_Combinations_DFS_BFS {
    //DFS
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
    //BFS
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n == 0 || k == 0 || k > n) {
            return result;
        }
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(new ArrayList<>());

        while (!queue.isEmpty()) {
            List<Integer> polledList = queue.poll();
            if (polledList.size() == k) {
                result.add(polledList);
                continue;
            }
            int indexToPopulate = polledList.size();
            int start = (indexToPopulate == 0) ? 1 : polledList.get(indexToPopulate - 1) + 1;
//这里没有用i<=n应为可以优化
//没有node时候，只能走到n - k + 1
//有node时候，可以offset上已有的数量
//这里indexToPopulate一定小于k
            for (int i = start; i <= (n - k + indexToPopulate + 1); i++) {
                List<Integer> newList = new ArrayList<>(polledList);
                newList.add(i);
                queue.offer(newList);
            }
        }
        return result;
    }
//一开始queue的size为1；poll出来时候list的size为0！！！
}
