package com.techbow.homework.y2021.m10.Sammy;

public class LC236_LCABT {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == q || root == p) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null) return root;
        if(left == null && right == null) return null;
        return left != null ? left : right;
    }
}
