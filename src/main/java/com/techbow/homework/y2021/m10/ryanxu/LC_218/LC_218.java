package com.techbow.homework.y2021.m10.ryanxu.LC_218;

import java.util.*;

public class LC_218 {

    private static class SegTreeNode {
        int start, end, info, tag;
        SegTreeNode left, right;

        public SegTreeNode(int start, int end, int info) {
            this.start = start;
            this.end = end;
            this.info = info;
            this.tag = 0;
            this.left = null;
            this.right = null;
        }

        public void initial(SegTreeNode node, int s, int e) {

            if (s == e) {
                node.info = 0;
                return;
            }

            int mid = node.start + (node.end - node.start) / 2;
            if (node.left == null) {
                node.left = new SegTreeNode(node.start, mid, node.info);
                node.right = new SegTreeNode(mid + 1, node.end, node.info);
            }
            initial(node.left, node.start, mid);
            initial(node.right, mid + 1, node.end);
            node.info = 0;
        }

        public void updateRange(SegTreeNode node, int s, int e, int info) {

            if (s > node.end || e < node.start) {
                return;
            }
            // TODO单点更新
            // 如果单点跳过，叶子节点继续递归会很危险，因为后面的操作没有实际意义。
            if (node.start == node.end) {
                node.info = Math.max(node.info, info);
                return;
            }

            if (s <= node.start && e >= node.end && info >= node.info) {
                node.tag = 1;
                node.info = info;
                return;
            }

            pushDown(node);
            updateRange(node.left, s, e, info);
            updateRange(node.right, s, e, info);
            node.info = Math.max(node.left.info, node.right.info);
        }

        private void pushDown(SegTreeNode node) {

            if (node.tag == 0) {
                return;
            }

            node.left.tag = 1;
            node.right.tag = 1;
            node.left.info = node.info;
            node.right.info = node.info;
            node.tag = 0;
        }

    }

    public List<List<Integer>> getSkyline(int[][] buildings) {

        List<List<Integer>> res = new ArrayList<>();
        if (buildings == null || buildings.length == 0) {
            return res;
        }

        // 离散化
        TreeSet<Integer> set = new TreeSet<>();
        for (int[] building : buildings) {
            set.add(building[0]);
            set.add(building[1]);
        }

        HashMap<Integer, Integer> pos2idx = new HashMap<>();
        HashMap<Integer, Integer> idx2pos = new HashMap<>();
        int idx = 0;
        for (Integer position : set) {
            pos2idx.put(position, idx);
            idx2pos.put(idx, position);
            idx++;
        }

        SegTreeNode root = new SegTreeNode(0, pos2idx.size() - 1, 0);
        root.initial(root, 0, pos2idx.size() - 1);

        for (int[] building : buildings) {
            root.updateRange(root, pos2idx.get(building[0]), pos2idx.get(building[1]) - 1, building[2]);
        }

        List<List<Integer>> candidates = new ArrayList<>();
        dfs(root, candidates);

        int i = 0;
        while (i < candidates.size()) {
            List<Integer> c = candidates.get(i);
            res.add(Arrays.asList(idx2pos.get(c.get(0)), c.get(1)));
            while (i + 1 < candidates.size() && candidates.get(i + 1).get(1) - candidates.get(i).get(1) == 0) {
                i++;
            }
            i++;
        }
        return res;
    }

    private void dfs(SegTreeNode node, List<List<Integer>> candidates) {

        if (node.start == node.end || node.tag == 1) {
            candidates.add(Arrays.asList(node.start, node.info));
            return;
        }

        dfs(node.left, candidates);
        dfs(node.right, candidates);
    }
}
