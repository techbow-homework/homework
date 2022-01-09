package com.techbow.homework.y2021.m10.ryanxu.LC_337;

import java.util.HashMap;

public class LC_337 {

    private static class TreeNode {

        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode() {}
        public TreeNode(int val) {
            this.val = val;
        }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int rob(TreeNode root) {

        if (root == null) {
            return 0;
        }

        HashMap<TreeNode, Integer> memo = new HashMap<>();
        return dfs(root, memo);
    }

    private int dfs(TreeNode node, HashMap<TreeNode, Integer> memo) {

        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return node.val;
        }

        Integer val = memo.get(node);
        if (val != null) {
            return val;
        }

        int res = 0;
        if (node.left != null) {
            if (node.right != null) {
                res = Math.max(res, node.val + dfs(node.left.left, memo) + dfs(node.left.right, memo)
                + dfs(node.right.left, memo) + dfs(node.right.right, memo));
                res = Math.max(res, dfs(node.left, memo) + dfs(node.right, memo));
            } else {
                res = Math.max(res, node.val + dfs(node.left.left, memo) + dfs(node.left.right, memo));
                res = Math.max(res, dfs(node.left, memo));
            }
        } else {
            if (node.right != null) {
                res = Math.max(res, node.val + dfs(node.right.left, memo) + dfs(node.right.right, memo));
                res = Math.max(res, dfs(node.right, memo));
            }
        }

        memo.put(node, res);
        return res;
    }

    public static void main(String[] args) {
        LC_337 lc_337 = new LC_337();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        System.out.println(lc_337.rob(root));
    }
}
