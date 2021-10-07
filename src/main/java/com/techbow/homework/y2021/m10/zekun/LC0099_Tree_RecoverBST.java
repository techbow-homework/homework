package com.techbow.homework.y2021.m10.zekun;

public class LC0099_Tree_RecoverBST {
    private TreeNode prev=null;

    public void recoverTree(TreeNode root) {

        TreeNode[] mistake = new TreeNode[2];

        dfsHelper(root, mistake);
        if(mistake[0] != null && mistake[1] != null){
            int tmp = mistake[0].val;
            mistake[0].val = mistake[1].val;
            mistake[1].val = tmp;

        }

    }
    private void dfsHelper(TreeNode root, TreeNode[] mistake){
        if(root == null) return;

        dfsHelper(root.left, mistake);

        if(prev != null && prev.val > root.val){
            if(mistake[0] != null) mistake[0] = prev;
            mistake[1] = root;
        }
        prev = root;
        dfsHelper(root.right, mistake);

    }
}
