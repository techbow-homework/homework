package com.techbow.homework.y2021.m10.ryanxu.LC_98;

import com.techbow.homework.y2021.m10.ryanxu.Library.TreeNode;

public class LC_98 {

//    private static class TreeNode {
//
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        public TreeNode(int val) {
//            this.val = val;
//        }
//    }

    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        TreeNode[] prev = new TreeNode[1];
        return dfs(root, prev);
    }

    private boolean dfs(TreeNode node, TreeNode[] prev) {

        if (node == null) {
            return true;
        }

        if (!dfs(node.left, prev)) {
            return false;
        }

        if (prev[0] != null && prev[0].val >= node.val) {
            return false;
        }
        prev[0] = node;
        return dfs(node.right, prev);
    }

    public static void main(String[] args) {
        LC_98 lc_98 = new LC_98();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(lc_98.isValidBST(root));
    }
}
