package com.techbow.homework.y2021.m10.mengyu;

import com.techbow.homework.y2021.m09.mengyu.TreeNode;

public class LC783minDistanceBtwTwoNodes {
    private Integer ans = Integer.MAX_VALUE;
    private Integer prev = null;
    public int minDistanceBtwTwoNodes (TreeNode root) {
        inorderBfs(root);
        return ans;
    }
    private void inorderBfs(TreeNode root) {
        if (root == null) return;
        inorderBfs(root.left);
        if (prev != null) {
            ans = Math.min(root.val - prev, ans);
        }
        prev = root.val;
        inorderBfs(root.right);
    }
}
