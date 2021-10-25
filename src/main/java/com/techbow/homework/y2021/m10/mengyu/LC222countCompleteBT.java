package com.techbow.homework.y2021.m10.mengyu;

import com.techbow.homework.y2021.m09.mengyu.TreeNode;

public class LC222countCompleteBT {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int count = countNodes(root.left) + countNodes(root.right) + 1;
        return count;
    }
}
