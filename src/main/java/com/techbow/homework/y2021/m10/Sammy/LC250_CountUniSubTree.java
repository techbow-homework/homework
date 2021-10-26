package com.techbow.homework.y2021.m10.Sammy;

public class LC250_CountUniSubTree {
    private int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null) return 0;
        isUniTree(root, count);
        return count;
    }
    private boolean isUniTree(TreeNode root, int val) {
        if(root == null) return true;

        boolean left = isUniTree(root.left, root.val);
        boolean right = isUniTree(root.right, root.val);

        if(left && right){
            count++;
            return root.val == val;
        } else {
            return false;
        }
    }
}
