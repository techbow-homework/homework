package com.techbow.homework.y2021.m10.mengyu;

import com.techbow.homework.y2021.m09.mengyu.TreeNode;

public class LC226InvertBT {
    public TreeNode invertBT (TreeNode root) {
        if (root == null) return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertBT(root.right);
        invertBT(root.left);
        return root;
    }
}
