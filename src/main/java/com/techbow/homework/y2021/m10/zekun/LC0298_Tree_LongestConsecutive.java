package com.techbow.homework.y2021.m10.zekun;

public class LC0298_Tree_LongestConsecutive {
    private int max = 0;
    public int longestConsecutive(TreeNode root) {
        //cc
        if(root == null) return 0;
        dfsHelper(root);
        return max;
    }

    private int dfsHelper(TreeNode root){
        //basecase
        if(root == null) return 0;
        //left & right
        int lLen = dfsHelper(root.left);
        int rLen = dfsHelper(root.right);
        int len = 1;
        if(root.left != null && root.left.val == root.val + 1){
            len = Math.max(lLen + 1, len);
        }
        if(root.right != null && root.right.val == root.val + 1){
            len = Math.max(len, rLen + 1);
        }
        max = Math.max(max, len);
        return len;
    }
}
