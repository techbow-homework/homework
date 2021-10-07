package com.techbow.homework.y2021.m10.jiale.leetcode;

import com.techbow.homework.y2021.m09.jiale.common.TreeNode;

/**
 * closest target in binary search tree
 */
public class LC_270 {
    public int closestValue(TreeNode root, double target) {
        int val, closest = root.val;
        while (root != null) {
            val = root.val;
            closest = Math.abs(val - target) < Math.abs(closest - target) ? val : closest;
            if (target == root.val) return root.val;
            if (target < val) {
                root = root.left;
            }
            if (target > val) {
                root = root.right;
            }
        }
        return closest;
    }
}
