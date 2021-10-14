package com.techbow.homework.y2021.m09.boyuan.小宋小宋;

public class LC_77 {
    List<List<Integer>> res = new ArrayList<>(); //存储结果
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> track = new LinkedList<>(); //一条路径上遍历的结果
        backtracking(n, k, 1, track);
        return res;
    }
    private void backtracking(int n, int k, int start, LinkedList<Integer> track) {
        if (track.size() == k) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            track.add(i);
            backtracking(n, k, i+1, track);
            track.removeLast();
        }
    }
}
