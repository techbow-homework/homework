package com.techbow.homework.y2021.m10.Sammy;

public class LC98_ValidateBST {
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        if(root ==  null) return true;

        if(!isValidBST(root.left)) return false;
        if(prev != null && root.val <= prev.val) return false;

        prev = root;
        return isValidBST(root.right);
    }
}
