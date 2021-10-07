package com.techbow.homework.y2021.m10.jiale.leetcode;

import com.techbow.homework.y2021.m09.jiale.common.TreeNode;

/**
 * subtree of another node
 */
public class LC_572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (root.val == subRoot.val) {
            if (isSameTree(root, subRoot)) {
                return true;
            }
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    private boolean isSameTree(TreeNode node, TreeNode subRoot) {
        if (node == null && subRoot == null) {
            return true;
        }
        if (node == null || subRoot == null) {
            return false;
        }
        if (node.val == subRoot.val) {
            return isSameTree(node.left, subRoot.left) && isSameTree(node.right, subRoot.right);
        }
        return false;
    }

}
