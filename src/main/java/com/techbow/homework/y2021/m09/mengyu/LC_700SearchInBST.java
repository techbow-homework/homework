package com.techbow.homework.y2021.m09.mengyu;

public class LC_700SearchInBST {
    //recursion
    public TreeNode searchBST(TreeNode root, int val) {
        //recursion
        if(root == null) return null;
        if(root.val == val) return root;
        return root.val > val ? searchBST(root.left, val) :
                searchBST(root.right, val);
    }
    //iteration
    public TreeNode searchBSTIteration(TreeNode root, int val) {
        while(root != null && root.val != val){
            root = root.val < val ? root.right : root.left;
        }
        return root;
    }
}
