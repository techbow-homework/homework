package com.techbow.homework.y2021.m10.qiangzhai;

public class LC40_CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        //cc
        if (candidates == null || candidates.length == 0) return res;
        //
        Arrays.sort(candidates);
        Queue<Node> que = new LinkedList<>();
        Node node = new Node(0, -1, new ArrayList<>());
        que.offer(node);
        while (!que.isEmpty()) {
            Node pollNode = que.poll();
            if (pollNode.sum == target) {
                res.add(pollNode.list);
                //每次level+1的时候，就是要+个ele，等于target此时便不必向下走了
                continue;
            }
            int startPos = pollNode.index + 1;
            for (int i = startPos; i < candidates.length; i++) {
                //去掉重复
                if (i > startPos && candidates[i - 1] == candidates[i]) continue;
                if (pollNode.sum + candidates[i] <= target) {
                    List<Integer> newList = new ArrayList<>(pollNode.list);
                    newList.add(candidates[i]);
                    Node newNode = new Node(pollNode.sum + candidates[i], i, newList);
                    que.offer(newNode);
                }
            }
        }
        return res;
    }
    class Node {
        int sum;
        int index;
        List<Integer> list;
        //
        Node(int sum, int index, List<Integer> list) {
            this.sum = sum;
            this.index = index;
            this.list = list;
        }
    }
}
