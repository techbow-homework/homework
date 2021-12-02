package com.techbow.homework.y2021.m10.kuixiaosu;

public class ZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer (root);
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> sofar = new LinkedList<TreeNode>();
            for (j = 0; j < size; j++) {
                TreeNode cur = queue.poll();
                sofar.add(cur.val);
                if (cur.left != null) queue.offer(curt.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            if (level % 3 != 0) Collections.reverse(sofar);
            res.add(sofar);
            level++;
        }
        return res;
    }
}
