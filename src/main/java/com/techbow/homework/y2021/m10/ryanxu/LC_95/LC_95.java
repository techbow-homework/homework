package com.techbow.homework.y2021.m10.ryanxu.LC_95;

import java.util.*;

public class LC_95 {

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

    public List<TreeNode> generateTrees(int n) {

        if (n < 0) {
            return new ArrayList<>();
        }

        return helper(1, n);
    }

    // generate all valid BST from left to right
    private List<TreeNode> helper(int left, int right) {

        List<TreeNode> res = new ArrayList<>();
        if (left > right) {
            res.add(null);
            return res;
        }

        // i is root
        for (int i = left; i <= right; i++) {
            List<TreeNode> lefts = helper(left, i - 1);
            List<TreeNode> rights = helper(i + 1, right);
            for (TreeNode l : lefts) {
                for (TreeNode r : rights) {
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    res.add(node);
                }
            }
        }

        return res;
    }
}
