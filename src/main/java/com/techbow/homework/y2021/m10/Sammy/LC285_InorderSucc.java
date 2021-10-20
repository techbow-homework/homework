package com.techbow.homework.y2021.m10.Sammy;

public class LC285_InorderSucc {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        //cc
        if(root == null || p == null) return null;

        TreeNode cur = root;
        TreeNode res = null;

        while(cur != null) {
            if(cur.val <= p.val) cur = cur.right;
            else{
                res = cur;
                cur = cur.left;
        }
        return res;
    }
}
