package com.techbow.homework.y2021.m10.zekun;

public class LC285_Tree_BSTInorderSuccessor {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        //cc
        TreeNode cur = root;
        TreeNode candidate = null;
        while(cur != null){
            if(cur.val > p.val){
                candidate = cur;
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }
        return candidate;
    }
}
