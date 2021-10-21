package com.techbow.homework.y2021.m10.Sammy;

public class LC701_InsertoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // terminate case
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val < val) { //insertion location @right
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }

        return root;
    }
}
