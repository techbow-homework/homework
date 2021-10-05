package com.techbow.homework.y2021.m09.jiale.leetcode;

import com.techbow.homework.y2021.m09.jiale.common.TreeNode;

public class LC_101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return (isSymmetric(left.left, right.right) && isSymmetric(right.left, left.right));
    }
}
