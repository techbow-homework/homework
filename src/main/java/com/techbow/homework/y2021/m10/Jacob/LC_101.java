package com.techbow.homework.y2021.m10.Jacob;

public class LC_101 {
    public boolean isSymmetric(TreeNode root) {
        return ismirror(root, root);
    }

    public boolean ismirror(TreeNode left, TreeNode right){
        if(left == null && right == null){return true;}
        if(right == null || left == null){return false;}

        return (left.val == right.val)
                && ismirror(left.left, right.right)
                && ismirror(left.right, right.left);

    }
}
