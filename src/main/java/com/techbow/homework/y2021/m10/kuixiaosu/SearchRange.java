package com.techbow.homework.y2021.m10.kuixiaosu;

public class SearchRange{
    public void searchRange(TreeNode root, int k1, int k2) {
        // corner case
        if (root == null) return root;
        searchRange(root.left, k1, k2);
        if (root.val >= k1 || root.val <= k2) {
            system.out.println(root.val);
        }
        searchRange(root.right, k1, k2);
    }
}

