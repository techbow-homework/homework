package com.techbow.homework.y2021.m10.ryanxu.LC_99;

import Library.TreeNode;

public class LC_99 {

    public void recoverTree(TreeNode root) {

        if (root == null) {
            return;
        }

        TreeNode[] prev = new TreeNode[1];
        TreeNode[] mistake = new TreeNode[2];
        dfs(prev, root, mistake);
        swap(mistake[0], mistake[1]);
    }

    private void dfs(TreeNode[] prev, TreeNode cur, TreeNode[] mistake) {

        if (cur == null) {
            return;
        }

        dfs(prev, cur.left, mistake);
        if (prev[0] != null && prev[0].val >= cur.val) {
            mistake[1] = cur;
            if (mistake[0] == null) {
                mistake[0] = prev[0];
            }
        }
        prev[0] = cur;
        dfs(prev, cur.right, mistake);
    }

    private void swap(TreeNode a, TreeNode b) {

        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }

    public static void main(String[] args) {
        LC_99 lc_99 = new LC_99();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        lc_99.recoverTree(root);
    }
}
