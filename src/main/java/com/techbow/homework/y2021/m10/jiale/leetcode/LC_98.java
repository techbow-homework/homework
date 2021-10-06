package com.techbow.homework.y2021.m10.jiale.leetcode;

import com.techbow.homework.y2021.m09.jiale.common.TreeNode;

/**
 * validate Binary Search Tree
 */
public class LC_98 {
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        if (prev != null && prev.val >= root.val) {
            return false;
        }
        prev = root;
        return isValidBST(root.right);
    }
}
