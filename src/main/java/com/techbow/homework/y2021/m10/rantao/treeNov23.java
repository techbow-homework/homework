package com.techbow.homework.y2021.m10.rantao;

public class treeNov23 {
    public boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;

        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }

    private boolean isValid(TreeNode root, long lower, long upper) {
        if (root == null) return true;
        if (root.val <= lower || root.val >= upper) return false;

        return isValid(root.left, lower, root.val) && isValid(root.right, root.val, upper);
    }
}

