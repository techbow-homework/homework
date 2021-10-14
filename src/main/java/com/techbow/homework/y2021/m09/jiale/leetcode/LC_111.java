package com.techbow.homework.y2021.m09.jiale.leetcode;

import com.techbow.homework.y2021.m09.jiale.common.TreeNode;

/**
 * min depth of bst
 */
public class LC_111 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left != 0 && right != 0) return Math.min(left, right) + 1;
        else return left + right + 1;
    }
}
