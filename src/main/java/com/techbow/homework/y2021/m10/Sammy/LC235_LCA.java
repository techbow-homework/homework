package com.techbow.homework.y2021.m10.Sammy;

public class LC235_LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        } else if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p,q);
        } else {
            return root;
        }
    }
}
