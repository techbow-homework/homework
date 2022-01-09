package com.techbow.homework.y2021.m10.ryanxu.LC_222;

import Library.TreeNode;

public class LC_222 {
    public int countNodes(TreeNode root) {

        return dfs(root);
    }

    private int dfs(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        if (leftHeight == rightHeight) {
            return (int) Math.pow(2, leftHeight) - 1 + dfs(node.right) + 1;
        } else {
            return (int) Math.pow(2, rightHeight) - 1 + dfs(node.left) + 1;
        }
    }

    private int getHeight(TreeNode node) {

        int count = 0;
        TreeNode cur = node;
        while (cur != null) {
            count++;
            cur = cur.left;
        }

        return count;
    }
}
