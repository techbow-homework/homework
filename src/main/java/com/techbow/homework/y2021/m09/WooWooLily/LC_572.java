package com.techbow.homework.y2021.m09.WooWooLily;
//subTree of a Tree
public class LC_572 {
    public boolean isSubTree(TreeNode root, TreeNode sub) {
        //for every treenode on root, find out if it's the same tree as treeNode sub
        if (sub == null) return true;
        if (root == null) return false;
        if (isSameTree(root,sub)) return true;
        return isSubTree(root.left, sub) || isSubTree(root.right, sub);
    }

    private boolean isSameTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.val != b.val) return false;

        return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }

}
